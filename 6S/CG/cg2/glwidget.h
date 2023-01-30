#ifndef GLWIDGET_H
#define GLWIDGET_H

#include <QGLWidget>
#include <QtOpenGL>

#include <iostream>
#include <fstream>
#include <limits>
#include <cmath>

#include "camera.h"
#include "light.h"
#include "material.h"
#include <trackball.h>

#include <QKeyEvent>

class GLWidget : public QGLWidget
{
    Q_OBJECT
public:
    explicit GLWidget(QWidget *parent = 0);
    virtual ~GLWidget();

signals:
    void statusBarMessage(QString ns);
    void setShaderIndex(int ind);

public slots :
    void showFileOpenDialog();
    void animate();
    void takeScreenshot();
    void definirCorFundo();
    void changeShader(int index);

protected :
    void initializeGL();
    void resizeGL(int width , int height);
    void paintGL();
    void mouseMoveEvent(QMouseEvent *event);
    void mousePressEvent(QMouseEvent *event);
    void mouseReleaseEvent(QMouseEvent *event);
    void wheelEvent(QWheelEvent *event);
    void keyPressEvent(QKeyEvent *event);

private:
    void readOFFFile( const QString &fileName);
    void genNormals();
    void genTexCoordsCylinder();
    void genTangents();
    void createVBOs();
    void destroyVBOs();
    void createShaders();
    void destroyShaders();

    unsigned int numVertices;
    unsigned int numFaces;
    QVector4D *vertices;
    QVector3D *normals;
    QVector2D *texCoords;
    QVector4D *tangents;
    unsigned int *indices;

    QGLBuffer *vboVertices;
    QGLBuffer *vboNormals;
    QGLBuffer *vboTexCoords;
    QGLBuffer *vboTangents;
    QGLBuffer *vboIndices;

    QGLShader *vertexShader;
    QGLShader *fragmentShader;
    QGLShaderProgram *shaderProgram;
    unsigned int currentShader;

    int texID[2];

    QMatrix4x4 modelViewMatrix;
    QMatrix4x4 projectionMatrix;

    Camera camera;
    Light light;
    Material material;

    TrackBall trackBall;

    double zoom;

    QTimer timer;

    unsigned int fpsCounter;
};

#endif // GLWIDGET_H
