#include "glwidget.h"
#include <QTextStream>
#include <QKeyEvent>
#include <QColorDialog>

// construtor padrao
GLWidget::GLWidget(QWidget *parent) : QGLWidget(parent)
{
    // inicializar variaveis
    vertices = NULL;
    normals = NULL;
    texCoords = NULL;
    tangents = NULL;
    indices = NULL;

    vboVertices = NULL;
    vboNormals = NULL;
    vboTexCoords = NULL;
    vboTangents = NULL;
    vboIndices = NULL;

    shaderProgram = NULL;
    vertexShader = NULL;
    fragmentShader = NULL;
    currentShader = 0;
    zoom = 0.0;
    fpsCounter = 0;
}

// destrutor padrao
GLWidget::~GLWidget() {
    destroyVBOs();
    destroyShaders();
}

// inicializar texturas
void GLWidget::initializeGL() {
    glEnable(GL_DEPTH_TEST);

    QImage texColor= QImage(":/textures/wood.png") ;
    QImage texNormal= QImage(":/textures/wood.png") ;
    QOpenGLFunctions glFuncs(QOpenGLContext::currentContext());
    glFuncs.glActiveTexture(GL_TEXTURE0);
    texID[0] = bindTexture(texColor);
    glFuncs.glActiveTexture(GL_TEXTURE1);
    texID[1] = bindTexture(texNormal);

    connect(&timer, SIGNAL(timeout()), this, SLOT(animate()));
    timer.start(0);
}

// alterar perspectiva da matriz de projecao para redimensionar o objeto
void GLWidget::resizeGL(int width , int height)
{
    glViewport(0, 0, width , height);

    projectionMatrix.setToIdentity();
    projectionMatrix.perspective (60.0, static_cast <qreal>(width) / static_cast <qreal>(height), 0.1, 20.0);

    trackBall.resizeViewport(width , height);

    updateGL();
}

void GLWidget::paintGL()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    if (!vboVertices)
        return ;

    modelViewMatrix.setToIdentity();
    modelViewMatrix.lookAt(camera.eye ,camera.at,camera.up);
    modelViewMatrix.translate(0, 0, zoom);
    modelViewMatrix.rotate(trackBall.getRotation());

    shaderProgram->bind();

    shaderProgram->setUniformValue("modelViewMatrix", modelViewMatrix);
    shaderProgram->setUniformValue("projectionMatrix", projectionMatrix);
    shaderProgram->setUniformValue("normalMatrix", modelViewMatrix.normalMatrix());

    QVector4D ambientProduct = light.ambient * material.ambient;
    QVector4D diffuseProduct = light.diffuse * material.diffuse;
    QVector4D specularProduct = light.specular * material.specular;

    shaderProgram->setUniformValue("lightPosition", light.position);
    shaderProgram->setUniformValue("ambientProduct", ambientProduct);
    shaderProgram->setUniformValue("diffuseProduct", diffuseProduct);
    shaderProgram->setUniformValue("specularProduct", specularProduct);
    shaderProgram->setUniformValue("shininess", static_cast <GLfloat >( material.shininess));
    shaderProgram->setUniformValue("texColorMap", 0);
    shaderProgram->setUniformValue("texNormalMap", 1);

    QOpenGLFunctions glFuncs(QOpenGLContext::currentContext());
    glFuncs.glActiveTexture(GL_TEXTURE0);
    glBindTexture(GL_TEXTURE_2D, texID[0]);
    QOpenGLFunctions glFuncs2(QOpenGLContext::currentContext());
    glFuncs.glActiveTexture(GL_TEXTURE1);
    glBindTexture(GL_TEXTURE_2D, texID[1]);

    vboVertices->bind();
    shaderProgram->enableAttributeArray("vPosition") ;
    shaderProgram->setAttributeBuffer("vPosition", GL_FLOAT , 0, 4, 0);

    vboNormals->bind();
    shaderProgram->enableAttributeArray("vNormal") ;
    shaderProgram->setAttributeBuffer("vNormal", GL_FLOAT , 0, 3, 0);

    vboTexCoords->bind();
    shaderProgram->enableAttributeArray("vTexCoord") ;
    shaderProgram->setAttributeBuffer("vTexCoord", GL_FLOAT , 0, 2, 0);

    vboTangents->bind();
    shaderProgram->enableAttributeArray("vTangent") ;
    shaderProgram->setAttributeBuffer("vTangent", GL_FLOAT , 0, 4, 0);

    vboIndices->bind();

    glDrawElements(GL_TRIANGLES , numFaces * 3, GL_UNSIGNED_INT , 0);

    vboIndices->release();
    vboTangents->release();
    vboTexCoords->release();
    vboNormals->release();
    vboVertices->release();
    shaderProgram->release();
}

void GLWidget::definirCorFundo( ) {
    QColor color = QColorDialog::getColor();
    glClearColor(color.redF(), color.greenF(), color.blueF(), color.alphaF());

    updateGL();
}

// selecionar arquivo off
void GLWidget::showFileOpenDialog()
{;
    QByteArray fileFormat = "off";
    QString fileName;
    // abrir janela para selecao do arquivo
    fileName = QFileDialog::getOpenFileName(this , "Open File", QDir::homePath(), QString("%1 Files (*.%2)").arg(QString(fileFormat.toUpper())).arg(QString(fileFormat)));
    // caso algum arquivo tenha sido selecionado, realizar calculos do objeto e exeibi-lo
    if (!fileName.isEmpty()) {
        readOFFFile(fileName);
        genNormals();
        genTexCoordsCylinder();
        genTangents();
        createVBOs();
        createShaders();
        updateGL();
    }
}

// ler arquivo off e armazenar informacoes sobre vertices e faces
void GLWidget::readOFFFile( const QString &fileName)
{
    // tentar ler arquivo, mostrar mensagem de erro caso nao consiga
    std::ifstream stream;
    stream.open( fileName.toUtf8(), std::ifstream::in);
    if (!stream.is_open()) {
        qWarning("Cannot open file.") ;
        return ;
    }

    //inicializar vetores de vertices e faces
    std::string line;
    std::getline(stream, line);
    stream >> numVertices >> numFaces >> line;

    // contar quantidade de faces com mais de 3 vertices
    std::getline(stream, line);
    for ( unsigned int i = 0; i < numVertices; i++ ) {
        std::getline(stream, line);
        QString s = QString::fromStdString(line);
    }
    // calcular quantidade de faces triangulares do objeto
    unsigned int facesAdicionais = 0;
    for ( unsigned int i = 0; i < numFaces; i++) {
        unsigned int qntVertices;
        stream >> qntVertices;
        std::getline(stream, line);
        if ( qntVertices > 3 )
            facesAdicionais += qntVertices - 3;
    }
    numFaces += facesAdicionais;
    stream.close();
    stream.open( fileName.toUtf8(), std::ifstream::in);
    std::getline(stream, line);
    std::getline(stream, line);
    delete [] vertices;
    vertices = new QVector4D[numVertices];
    delete [] indices;
    indices = new unsigned int [numFaces * 3];

    // ler e armazenar dados sobre os vertices
    // calcula os valores maximos e minimos de cada posicao para centralizacao e redimensionamento
    if (numVertices > 0) {
        double minLim = std::numeric_limits <double >::min();
        double maxLim = std::numeric_limits <double >::max();
        QVector4D max(minLim, minLim, minLim, 1.0);
        QVector4D min(maxLim, maxLim, maxLim, 1.0);

        for ( unsigned int i = 0; i < numVertices; i++) {
            double x, y, z;
            stream >> x >> y >> z;
            max.setX(qMax((double)max.x(), x));
            max.setY(qMax((double)max.y(), y));
            max.setZ(qMax((double)max.z(), z));
            min.setX(qMin((double)min.x(), x));
            min.setY(qMin((double)min.y(), y));
            min.setZ(qMin((double)min.z(), z));

            vertices[i] = QVector4D(x, y, z, 1.0);
        }

        // centraliza e redimensiona os vertices
        QVector4D midpoint = (min + max) * 0.5;
        double invdiag = 1 / (max - min).length();

        for ( unsigned int i = 0; i < numVertices; i++) {
            vertices[i] = (vertices[i] - midpoint)*invdiag;
            vertices[i]. setW(1);
        }
    }
    // armazenar informacoes sobre os vertices que compoem as faces
    for ( unsigned int i = 0; i < numFaces; i++) {
        unsigned int a, b, c, qntVertices;
        // ler vertices iniciais
        stream >> qntVertices >> a >> b;
        unsigned int verticesAdicionais = qntVertices - 3;
        // armazenar vertices dos triangulos
        for ( unsigned int j = 0; j <= verticesAdicionais; j++ ) {
            stream >> c;
            indices[(i+j)*3] = a;
            indices[((i+j)*3) + 1] = b;
            indices[((i+j)*3) + 2] = c;
            b = c;
        }
        i += verticesAdicionais;
    }

    stream.close();

    emit statusBarMessage(QString("Vertices %1, Faces %2").arg(numVertices).arg(numFaces));

}

// calcula a normal em relacao a cada vertice
void GLWidget::genNormals()
{
    delete [] normals;
    normals = new QVector3D[numVertices];

    // para cada face
    for ( unsigned int i = 0; i < numFaces; i++) {
        // armazenar vertices que a descrevem
        unsigned int i1 = indices[i * 3 ];
        unsigned int i2 = indices[i * 3 + 1];
        unsigned int i3 = indices[i * 3 + 2];
        QVector3D v1 = vertices[i1].toVector3D();
        QVector3D v2 = vertices[i2].toVector3D();
        QVector3D v3 = vertices[i3].toVector3D();
        // calcular vetor normal da face
        QVector3D faceNormal = QVector3D::crossProduct(v2 - v1 , v3 - v1);
        // adicionar normal a soma de normais do vertice
        normals[i1] += faceNormal;
        normals[i2] += faceNormal;
        normals[i3] += faceNormal;
    }
    // normalizar vetores normais dos vertices
    for ( unsigned int i = 0; i < numVertices; i++)
        normals[i].normalize();
}

// gerar coordenadas da textura
void GLWidget::genTexCoordsCylinder()
{
    delete [] texCoords;
    texCoords = new QVector2D[numVertices];

    // calcular limites
    double minLim = std::numeric_limits <double >::min();
    double maxLim = std::numeric_limits <double >::max();
    QVector2D max(minLim , minLim);
    QVector2D min(maxLim , maxLim);
    for ( unsigned int i = 0; i < numVertices; i++) {
        QVector2D pos = vertices[i].toVector2D();
        max.setX(qMax(max.x(), pos.x()));
        max.setY(qMax(max.y(), pos.y()));
        min.setX(qMin(min.x(), pos.x()));
        min.setY(qMin(min.y(), pos.y()));
    }
    QVector2D size = max - min;
    // calcular coordenadas da textura em relacao aos vertices
    for ( unsigned int i = 0; i < numVertices; i++) {
        double x = 2.0 * (vertices[i].x() - min.x()) / size.x() - 1.0;
        texCoords[i] = QVector2D( acos(x) / M_PI, (vertices[i].y() - min.y()) / size.y());
    }
}

// calcular tangentes por vertice
void GLWidget::genTangents()
{
    delete [] tangents;
    tangents = new QVector4D[numVertices];
    QVector3D *bitangents = new QVector3D[numVertices];

    for ( unsigned int i = 0; i < numFaces; i++) {
        unsigned int i1 = indices[i * 3 ];
        unsigned int i2 = indices[i * 3 + 1];
        unsigned int i3 = indices[i * 3 + 2];
        QVector3D E = vertices[i1].toVector3D();
        QVector3D F = vertices[i2].toVector3D();
        QVector3D G = vertices[i3].toVector3D();
        QVector2D stE = texCoords[i1];
        QVector2D stF = texCoords[i2];
        QVector2D stG = texCoords[i3];
        QVector3D P = F - E;
        QVector3D Q = G - E;

        QVector2D st1 = stF - stE;
        QVector2D st2 = stG - stE;
        QMatrix2x2 M;
        M(0,0) = st2.y(); M(0,1) = -st1.y();
        M(1,0) = -st2.x(); M(1,1) = st1.x();
        M *= (1.0 / (st1.x()*st2.y() - st2.x()*st1.y()));

        QVector4D T = QVector4D(M(0,0)*P.x()+M(0,1)*Q.x(), M(0,0)*P.y()+M(0,1)*Q.y(), M(0,0)*P.z()+M(0,1)*Q.z(), 0.0);
        QVector3D B = QVector3D(M(1,0)*P.x()+M(1,1)*Q.x(), M(1,0)*P.y()+M(1,1)*Q.y(), M(1,0)*P.z()+M(1,1)*Q.z());
        tangents[i1] += T;
        tangents[i2] += T;
        tangents[i3] += T;
        bitangents[i1] += B;
        bitangents[i2] += B;
        bitangents[i3] += B;
    }

    for ( unsigned int i = 0; i < numVertices; i++) {
    const QVector3D& n = normals[i];
    const QVector4D& t = tangents[i];

    tangents[i] = (t - n * QVector3D::dotProduct(n, t.toVector3D())).normalized();
    QVector3D b = QVector3D::crossProduct(n, t.toVector3D());
    double hand = QVector3D:: dotProduct(b, bitangents[i]);
    tangents[i].setW((hand < 0.0) ? -1.0 : 1.0);
    }

    delete [] bitangents;
}

// metodo p/ criar shaders
void GLWidget::createShaders()
{
    destroyShaders();

    // armazenar caminho dos arquivos de shaders
    QString vertexShaderFile[] = {":/shaders/vgouraud.glsl", ":/shaders/vphong.glsl", ":/shaders/vtexture.glsl", ":/shaders/vnormal.glsl"};
    QString fragmentShaderFile[] = {":/shaders/fgouraud.glsl", ":/shaders/fphong.glsl", ":/shaders/ftexture.glsl", ":/shaders/fnormal.glsl"};

    // inicializar e adiocionar shaders
    vertexShader = new QGLShader(QGLShader::Vertex);
    if (!vertexShader->compileSourceFile(vertexShaderFile[currentShader]))
        qWarning() << vertexShader->log();

    fragmentShader = new QGLShader(QGLShader::Fragment);
    if (!fragmentShader->compileSourceFile(fragmentShaderFile[currentShader]))
        qWarning() << fragmentShader->log();

    shaderProgram = new QGLShaderProgram;
    shaderProgram->addShader(vertexShader);
    shaderProgram->addShader(fragmentShader);

    if (!shaderProgram->link())
        qWarning() << shaderProgram->log() << endl;
}

void GLWidget::destroyShaders()
    {
    delete vertexShader;
    vertexShader = NULL;
    delete fragmentShader;
    fragmentShader = NULL;

    if (shaderProgram) {
        shaderProgram->release();
        delete shaderProgram;
        shaderProgram = NULL;
    }
}

// metodo p/ armazenar as informacoes do objeto em VBOs
void GLWidget::createVBOs()
{
    destroyVBOs();

    // armazenar vertices
    vboVertices = new QGLBuffer(QGLBuffer::VertexBuffer);
    vboVertices->create();
    vboVertices->bind();
    vboVertices->setUsagePattern(QGLBuffer::StaticDraw);
    vboVertices->allocate( vertices , numVertices * sizeof (QVector4D));
    delete [] vertices;
    vertices = NULL;

    // armazenar normais
    vboNormals = new QGLBuffer(QGLBuffer::VertexBuffer);
    vboNormals->create();
    vboNormals->bind();
    vboNormals->setUsagePattern(QGLBuffer::StaticDraw);
    vboNormals->allocate(normals , numVertices * sizeof (QVector3D));
    delete [] normals;
    normals = NULL;

    // armazenar coordenadas da textura
    vboTexCoords = new QGLBuffer(QGLBuffer::VertexBuffer);
    vboTexCoords->create();
    vboTexCoords->bind();
    vboTexCoords->setUsagePattern(QGLBuffer::StaticDraw);
    vboTexCoords->allocate( texCoords , numVertices * sizeof (QVector2D));
    delete [] texCoords;
    texCoords = NULL;

    // armazenar tangentes
    vboTangents = new QGLBuffer(QGLBuffer::VertexBuffer);
    vboTangents->create();
    vboTangents->bind();
    vboTangents->setUsagePattern(QGLBuffer::StaticDraw);
    vboTangents->allocate( tangents , numVertices * sizeof (QVector4D));
    delete [] tangents;
    tangents = NULL;

    // armazenar indices dos vertices que compoem as faces ( 3 para cada face )
    vboIndices = new QGLBuffer(QGLBuffer::IndexBuffer);
    vboIndices->create();
    vboIndices->bind();
    vboIndices->setUsagePattern(QGLBuffer::StaticDraw);
    vboIndices->allocate(indices , numFaces * 3 * sizeof ( unsigned int ));
    delete [] indices;
    indices = NULL;
    }

// zerar VBOs
void GLWidget::destroyVBOs() {
    if (vboVertices) {
        vboVertices->release();
        delete vboVertices;
        vboVertices = NULL;
    }

    if (vboNormals) {
        vboNormals->release();
        delete vboNormals;
        vboNormals = NULL;
    }

    if (vboTexCoords) {
        vboTexCoords->release();
        delete vboTexCoords;
        vboTexCoords = NULL;
    }

    if (vboTangents) {
        vboTangents->release();
        delete vboTangents;
        vboTangents = NULL;
    }

    if (vboIndices) {
        vboIndices->release();
        delete vboIndices;
        vboIndices = NULL;
    }
}

/* trocar de shader dependendo da tecla apertada
 * 0 -> gouraud
 * 1 -> phong
 * 2 -> phong c/ textura
 * 3 -> phong c/ bump mapping
 */
void GLWidget::keyPressEvent(QKeyEvent *event) {
    switch (event->key()) {
        case Qt::Key_0:
            currentShader = 0;
            createShaders();
            updateGL();
            break ;
         case Qt::Key_1:
            currentShader = 1;
            createShaders();
            updateGL();
            break ;
        case Qt::Key_2:
            currentShader = 2;
            createShaders();
            updateGL();
            break ;
        case Qt::Key_3:
            currentShader = 3;
            createShaders();
            updateGL();
            break ;
        case Qt::Key_Escape:
            qApp->quit();
    }
    // emitir alerta p/ trocar indice da comboBox dos shaders
    emit setShaderIndex(currentShader);
}

// alterar shader de acordo com o indice passado pela comboBox dos shaders
void GLWidget::changeShader(int index) {
        currentShader = index;
        createShaders();
        updateGL();
}

// controlar movimentos do mouse
void GLWidget::mouseMoveEvent(QMouseEvent *event) {
    trackBall.mouseMove(event->pos());
}

void GLWidget::mousePressEvent(QMouseEvent *event) {
    if (event->button() & Qt::LeftButton)
        trackBall.mousePress(event->pos());
}

void GLWidget::mouseReleaseEvent(QMouseEvent *event) {
    if (event->button() == Qt::LeftButton)
        trackBall.mouseRelease(event->pos());
}

void GLWidget::wheelEvent(QWheelEvent *event) {
    zoom += 0.001 * event->delta();
}

void GLWidget::animate() {
    updateGL();
}

// capturar imagem do widget
void GLWidget::takeScreenshot() {
    QImage screenshot = grabFrameBuffer();
    QString fileName;
    // abrir janela para inserir as informacoes ( nome e onde ira salvar ) do arquivo
    fileName = QFileDialog::getSaveFileName(this , "Save File As", QDir:: homePath(), QString("PNG Files (*.png)"));
    if (fileName.length()) {
        if (!fileName.contains(".png") )
            fileName += ".png";
        screenshot.save(fileName, "PNG");
    }
}
