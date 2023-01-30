package grafos;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JPanel {

    static String arquivoAeroportos = "aeroportos.txt";
    static String arquivoRotas = "rotas.txt";
    
    
    
    static JFrame frame = new JFrame("Grafos");
    static JPanel mapa = new JPanel();
    static JToggleButton escolherAeroportoPartida = new JToggleButton("Escolher");
    static JToggleButton escolherAeroportoDestino = new JToggleButton("Escolher");
    static JButton calcular = new JButton("Calcular");
    static JLabel aeroporto1 = new JLabel("Aeroporto Partida: ");
    static JLabel aeroporto2 = new JLabel("Aeroporto Destino: ");
    static JLabel menorDist = new JLabel("Menor Distancia: ");
    static JComboBox algoritmos;
    private static String[] caminhos;
    private static int[][] tarifas;
    private static int[][] cloneTarifas;
    private static double[][] distancias;
    private static double[][] cloneDistancias;
    private static double[] menor;
    private static int[][] matrizRotas;
    private static BufferedImage backgroundImg;
    private static int tamanhoY;
    private static int tamanhoX;
    private static boolean[] visitados;
    private static Aeroporto[] aeroportos;
    private static Aeroporto partida;
    private static Aeroporto destino;
    private static Rota[] rotas;
    private static Map<String, Integer> hash;
    private static Map<Integer, String> hashRotas;
    private Point ponto = null;
    private static int raio = 8;
    private static GUI gui;
    private static int indiceDestino;
    private static int menorTarifa;
    private static String menorCaminho;
    private static int menorSomatorio;
    private static int[][] menorConjunto;
    private static int combinacoes = 0;

    public int getTamanhoY() {
        return tamanhoY;
    }

    public int getTamanhoX() {
        return tamanhoX;
    }

    public GUI() throws IOException {
        BufferedImage bImg = ImageIO.read(new File("mapa.jpg"));
        tamanhoX = bImg.getWidth();
        tamanhoY = bImg.getHeight();
        backgroundImg = new BufferedImage(tamanhoX, tamanhoY, BufferedImage.TYPE_INT_RGB);
        Graphics g = backgroundImg.getGraphics();
        g.drawImage(bImg, 0, 0, this);
        g.dispose();

        try {
            lerAeroportos();
            lerRotas();
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseMotionListener(myMouseAdapter);
        addMouseListener(myMouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tamanhoX, tamanhoY);
    }

    public void desenharAeroporto(int x, int y, String nome, Color cor) {
        Graphics g = backgroundImg.getGraphics();
        g.setColor(cor);
        g.fillOval(x, y, raio, raio);
        g.drawString(nome, x + 10, y + 10);
        g.dispose();

        repaint();
    }

    public void desenharRota(int x, int y, int x2, int y2, int preco, Color cor) {
        Graphics g = backgroundImg.getGraphics();
        g.setColor(cor);
        g.drawLine(x + 4, y + 4, x2 + 4, y2 + 4);
        int posX = (x + x2 + 8) / 2;
        int posY = (y + y2 + 8) / 2;
        g.drawString(String.valueOf(preco), posX + 10, posY + 10);
        //g.drawString("0", posX+20, posY+20);
        g.dispose();

        repaint();
    }

    public void desenharRota(int x, int y, int x2, int y2, Color cor) {
        Graphics g = backgroundImg.getGraphics();
        g.setColor(cor);
        g.drawLine(x + 4, y + 4, x2 + 4, y2 + 4);
        int posX = (x + x2 + 8) / 2;
        int posY = (y + y2 + 8) / 2;
        g.dispose();

        repaint();
    }

    private static void criarEMostrarGui() {
        gui = null;
        try {
            gui = new GUI();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }

        mapa.add(gui);
        String[] algs = {"Menor Distância", "Menor Tarifa", "Viagem ao redor do mundo - BF", "Viagem ao redor do mundo - Heurística", "Trechos - BF", "Trechos - Heurística", "Altura - BF", "Altura - Heurística"};
        algoritmos = new JComboBox(algs);
        algoritmos.setBounds(tamanhoX + 5, 15, 230, 30);
        aeroporto1.setBounds(tamanhoX + 5, 50, 170, 30);
        aeroporto2.setBounds(tamanhoX + 5, 130, 170, 30);
        escolherAeroportoPartida.setBounds(tamanhoX + 70, 90, 100, 20);
        escolherAeroportoDestino.setBounds(tamanhoX + 70, 170, 100, 20);
        calcular.setBounds(tamanhoX + 70, 210, 100, 20);
        menorDist.setBounds(tamanhoX + 5, 250, 160, 30);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mapa.setBounds(0, 0, tamanhoX, tamanhoY);
        frame.getContentPane().add(mapa);
        frame.getContentPane().add(algoritmos);
        frame.getContentPane().add(aeroporto1);
        frame.getContentPane().add(aeroporto2);
        frame.getContentPane().add(escolherAeroportoPartida);
        frame.getContentPane().add(escolherAeroportoDestino);
        frame.getContentPane().add(calcular);
        frame.getContentPane().add(menorDist);
        frame.setSize(tamanhoX + 260, tamanhoY+45);
        frame.setLayout(null);
        frame.setVisible(true);

        algoritmos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    esconderBotoes();
                    switch (algoritmos.getSelectedIndex()) {
                        case 0:
                            escolherAeroportoPartida.setVisible(true);
                            escolherAeroportoDestino.setVisible(true);
                            menorDist.setText("Menor Distancia: ");
                            menorDist.setVisible(true);
                            aeroporto1.setVisible(true);
                            aeroporto2.setVisible(true);
                            calcular.setVisible(true);
                            algoritmos.setBounds(tamanhoX + 5, 15, 230, 30);
                            aeroporto1.setBounds(tamanhoX + 5, 50, 170, 30);
                            aeroporto2.setBounds(tamanhoX + 5, 130, 170, 30);
                            escolherAeroportoPartida.setBounds(tamanhoX + 70, 90, 100, 20);
                            escolherAeroportoDestino.setBounds(tamanhoX + 70, 170, 100, 20);
                            calcular.setBounds(tamanhoX + 70, 210, 100, 20);
                            menorDist.setBounds(tamanhoX + 5, 250, 230, 30);
                            break;
                        case 1:
                            escolherAeroportoPartida.setVisible(true);
                            escolherAeroportoDestino.setVisible(true);
                            menorDist.setText("Menor Tarifa: ");
                            menorDist.setVisible(true);
                            aeroporto1.setVisible(true);
                            aeroporto2.setVisible(true);
                            calcular.setVisible(true);
                            algoritmos.setBounds(tamanhoX + 5, 15, 230, 30);
                            aeroporto1.setBounds(tamanhoX + 5, 50, 170, 30);
                            aeroporto2.setBounds(tamanhoX + 5, 130, 170, 30);
                            escolherAeroportoPartida.setBounds(tamanhoX + 70, 90, 100, 20);
                            escolherAeroportoDestino.setBounds(tamanhoX + 70, 170, 100, 20);
                            calcular.setBounds(tamanhoX + 70, 210, 100, 20);
                            menorDist.setBounds(tamanhoX + 5, 250, 230, 30);
                            break;
                        case 2:
                            algoritmos.setVisible(true);
                            aeroporto1.setVisible(true);
                            escolherAeroportoPartida.setVisible(true);
                            calcular.setVisible(true);
                            menorDist.setVisible(true);
                            menorDist.setText("Menor Tarifa: ");
                            algoritmos.setBounds(tamanhoX + 5, 15, 230, 30);
                            aeroporto1.setBounds(tamanhoX + 5, 50, 170, 30);
                            escolherAeroportoPartida.setBounds(tamanhoX + 70, 90, 100, 20);
                            calcular.setBounds(tamanhoX + 70, 130, 100, 20);
                            menorDist.setBounds(tamanhoX + 5, 170, 230, 30);
                            break;
                        case 3:
                            algoritmos.setVisible(true);
                            aeroporto1.setVisible(true);
                            escolherAeroportoPartida.setVisible(true);
                            calcular.setVisible(true);
                            menorDist.setVisible(true);
                            menorDist.setText("Menor Tarifa: ");
                            algoritmos.setBounds(tamanhoX + 5, 15, 230, 30);
                            aeroporto1.setBounds(tamanhoX + 5, 50, 170, 30);
                            escolherAeroportoPartida.setBounds(tamanhoX + 70, 90, 100, 20);
                            calcular.setBounds(tamanhoX + 70, 130, 100, 20);
                            menorDist.setBounds(tamanhoX + 5, 170, 230, 30);
                            break;
                        case 4:
                            calcular.setBounds(tamanhoX + 70, 50, 100, 20);
                            calcular.setVisible(true);
                            menorDist.setBounds(tamanhoX + 5, 90, 230, 20);
                            menorDist.setVisible(true);
                            menorDist.setText("Menor Tarifa: ");
                            break;
                        case 5:
                            calcular.setBounds(tamanhoX + 70, 50, 100, 20);
                            calcular.setVisible(true);
                            menorDist.setBounds(tamanhoX + 5, 90, 230, 20);
                            menorDist.setVisible(true);
                            menorDist.setText("Menor Tarifa: ");
                            break;
                        case 6:
                            calcular.setBounds(tamanhoX + 70, 50, 100, 20);
                            calcular.setVisible(true);
                            menorDist.setBounds(tamanhoX + 5, 90, 230, 20);
                            menorDist.setVisible(true);
                            menorDist.setText("Menor Tarifa: ");
                            break;
                        case 7:
                            calcular.setBounds(tamanhoX + 70, 50, 100, 20);
                            calcular.setVisible(true);
                            break;
                    }
                }
            }
        });

        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.redesenharMapa();
                long inicio = System.currentTimeMillis();
                switch (algoritmos.getSelectedIndex()) {
                    case 0:
                        if (partida != null && destino != null) {
                            calcularMenorDistancia(partida, destino);
                            long fim = System.currentTimeMillis();
                            long tempo = fim - inicio;
                            System.out.println("Tempo: " + tempo);
                            gui.pintarCaminho();
                        }
                        break;
                    case 1:
                        if (partida != null && destino != null) {
                            calcularMenorTarifa(partida, destino);
                            long fim = System.currentTimeMillis();
                            long tempo = fim - inicio;
                            System.out.println("Tempo: " + tempo);
                            gui.pintarCaminho();
                        }
                        break;
                    case 2:
                        if (partida != null) {
                            voltaAoMundoBf(partida);
                            long fim = System.currentTimeMillis();
                            long tempo = fim - inicio;
                            System.out.println("Tempo: " + tempo);
                            gui.pintarCaminhoVoltaAoMundoBf();
                        }
                        break;
                    case 3:
                        if (partida != null) {
                            voltaAoMundoHeuristica(partida);
                            long fim = System.currentTimeMillis();
                            long tempo = fim - inicio;
                            System.out.println("Tempo: " + tempo);
                            gui.pintarCaminhoVoltaAoMundoHeuristica();
                        }
                        break;
                    case 4:
                        subconjuntoTrechosBf();
                        long fim = System.currentTimeMillis();
                        long tempo = fim - inicio;
                        System.out.println("Tempo: " + tempo);
                        gui.pintarCaminhoAgmBf();
                        break;
                    case 5:
                        subconjuntoTrechos();
                        fim = System.currentTimeMillis();
                        tempo = fim - inicio;
                        System.out.println("Tempo: " + tempo);
                        gui.pintarCaminhoAgmHeuristica();
                        break;
                    case 6:
                        alturaBf();
                        fim = System.currentTimeMillis();
                        tempo = fim - inicio;
                        System.out.println("Tempo: " + tempo);
                        gui.escreverAlturasHeuristica(Color.RED, -4);
                        break;
                    case 7:
                        alturaHeuristica();
                        fim = System.currentTimeMillis();
                        tempo = fim - inicio;
                        System.out.println("Tempo: " + tempo);
                        gui.escreverAlturasHeuristica(Color.MAGENTA, -14);
                        break;
                }
            }
        });

    }

    public void redesenharMapa() {
        for (int i = 0; i < aeroportos.length; i++) {
            desenharAeroporto(aeroportos[i].getLongitude(), aeroportos[i].getLatitude(), aeroportos[i].getNome(), Color.BLACK);
        }
        for (int i = 0; i < rotas.length; i++) {
            desenharRota(rotas[i].a1.getLongitude(), rotas[i].a1.getLatitude(),
                    rotas[i].a2.getLongitude(), rotas[i].a2.getLatitude(), rotas[i].getPreco(), Color.BLACK);
        }
    }

    public void pintarCaminho() {
        String[] s = caminhos[indiceDestino].split("-");
        for (int i = 0; i < s.length; i++) {
            Aeroporto temp = aeroportos[hash.get(s[i])];
            gui.desenharAeroporto(temp.getLongitude(), temp.getLatitude(), temp.getNome(), Color.YELLOW);
            if (i != s.length - 1) {
                Aeroporto temp2 = aeroportos[hash.get(s[i + 1])];
                gui.desenharRota(temp.getLongitude(), temp.getLatitude(), temp2.getLongitude(), temp2.getLatitude(), Color.YELLOW);
            }
        }
    }

    public void escreverAlturasHeuristica(Color cor, int a) {
        for (int i = 0; i < rotas.length; i++) {
            Graphics g = backgroundImg.getGraphics();
            g.setColor(cor);
            int posX = (rotas[i].a1.getLongitude() + rotas[i].a2.getLongitude() + 8) / 2;
            int posY = (rotas[i].a1.getLatitude() + rotas[i].a2.getLatitude() + 8) / 2;
            g.drawString(String.valueOf(rotas[i].getAltura()), posX + a, posY + a);
            g.dispose();

            repaint();
        }
    }

    public void escreverAlturasBf() {

    }

    public void pintarCaminhoAgmBf() {
        for (int i = 0; i < caminhos.length; i++) {
            String[] str = caminhos[i].split("-");
            if (str.length > 1) {
                Aeroporto temp = aeroportos[hash.get(str[0])];
                Aeroporto temp2 = aeroportos[hash.get(str[1])];
                gui.desenharRota(temp.getLongitude(), temp.getLatitude(), temp2.getLongitude(), temp2.getLatitude(), Color.YELLOW);
                gui.desenharAeroporto(temp.getLongitude(), temp.getLatitude(), temp.getNome(), Color.YELLOW);
                gui.desenharAeroporto(temp2.getLongitude(), temp2.getLatitude(), temp2.getNome(), Color.YELLOW);
            }
        }
    }

    public void pintarCaminhoAgmHeuristica() {
        String[] str;
        for (int i = 1; i < caminhos.length; i++) {
            str = caminhos[i].split("-");
            Aeroporto temp = aeroportos[hash.get(str[0])];
            gui.desenharAeroporto(temp.getLongitude(), temp.getLatitude(), temp.getNome(), Color.YELLOW);
                Aeroporto temp2 = aeroportos[hash.get(str[1])];
                gui.desenharRota(temp.getLongitude(), temp.getLatitude(), temp2.getLongitude(), temp2.getLatitude(), Color.YELLOW);
                gui.desenharAeroporto(temp2.getLongitude(), temp2.getLatitude(), temp2.getNome(), Color.YELLOW);
        }
    }

    public void pintarCaminhoVoltaAoMundoBf() {
        if (menorCaminho != "") {
            String[] s = menorCaminho.split("-");
            for (int i = 0; i < s.length; i++) {
                Aeroporto temp = aeroportos[hash.get(s[i])];
                gui.desenharAeroporto(temp.getLongitude(), temp.getLatitude(), temp.getNome(), Color.YELLOW);
                if (i != s.length - 1) {
                    Aeroporto temp2 = aeroportos[hash.get(s[i + 1])];
                    gui.desenharRota(temp.getLongitude(), temp.getLatitude(), temp2.getLongitude(), temp2.getLatitude(), Color.YELLOW);
                }
            }
        }
    }

    public void pintarCaminhoVoltaAoMundoHeuristica() {
        for (int i = 0; i < caminhos.length - 1; i++) {
            if (tarifas[i][i + 1] != 0) {
                Aeroporto temp = aeroportos[hash.get(caminhos[i])];
                gui.desenharAeroporto(temp.getLongitude(), temp.getLatitude(), temp.getNome(), Color.YELLOW);
                if (i != caminhos.length - 1) {
                    Aeroporto temp2 = aeroportos[hash.get(caminhos[i + 1])];
                    gui.desenharRota(temp.getLongitude(), temp.getLatitude(), temp2.getLongitude(), temp2.getLatitude(), Color.YELLOW);
                }
            }
        }
        Aeroporto temp = aeroportos[hash.get(caminhos[0])];
        Aeroporto temp2 = aeroportos[hash.get(caminhos[caminhos.length - 1])];
        gui.desenharRota(temp.getLongitude(), temp.getLatitude(), temp2.getLongitude(), temp2.getLatitude(), Color.YELLOW);
    }

    public static void esconderBotoes() {
        escolherAeroportoPartida.setVisible(false);
        escolherAeroportoDestino.setVisible(false);
        aeroporto1.setVisible(false);
        aeroporto2.setVisible(false);
        calcular.setVisible(false);
        menorDist.setVisible(false);
    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent mEvt) {
            if (escolherAeroportoPartida.isSelected()) {
                ponto = mEvt.getPoint();
                if (buscarAeroporto(ponto.x, ponto.y) != null) {
                    partida = buscarAeroporto(ponto.x, ponto.y);
                    aeroporto1.setText("Aeroporto Partida: " + partida.getNome());
                    escolherAeroportoPartida.setSelected(false);
                }
            }
            if (escolherAeroportoDestino.isSelected()) {
                ponto = mEvt.getPoint();
                if (buscarAeroporto(ponto.x, ponto.y) != null) {
                    destino = buscarAeroporto(ponto.x, ponto.y);
                    aeroporto2.setText("Aeroporto Destino: " + destino.getNome());
                    escolherAeroportoDestino.setSelected(false);
                }
            }
        }
    }

    public Aeroporto buscarAeroporto(int x, int y) {
        Aeroporto a1 = null;
        for (int i = 0; i < aeroportos.length; i++) {
            if (x > aeroportos[i].getLongitude() - raio && x < aeroportos[i].getLongitude() + raio
                    && y > aeroportos[i].getLatitude() - raio && y < aeroportos[i].getLatitude() + raio) {
                a1 = aeroportos[i];
                i = aeroportos.length;
            }
        }
        return a1;
    }

    public static void inicializarVetores() {
        menor = new double[aeroportos.length];
        caminhos = new String[aeroportos.length];
        visitados = new boolean[aeroportos.length];
        for (int i = 0; i < menor.length; i++) {
            menor[i] = Integer.MAX_VALUE;
            caminhos[i] = "";
            visitados[i] = false;
        }
    }

    public static void subconjuntoTrechosBf() {
        boolean[] vertVisitados = new boolean[aeroportos.length];
        String[] caminhosVert = new String[aeroportos.length];
        menorCaminho = "";
        menorTarifa = Integer.MAX_VALUE;
        subconjuntoTrechosBfRec(0, 0, caminhosVert, 0, vertVisitados);
        menorDist.setText("Menor Tarifa: R$" + menorTarifa);
    }

    public static void subconjuntoTrechosBfRec(int atual, int anterior, String[] caminhosVert, int tarifa, boolean[] vertVisitados) {

        vertVisitados[atual] = true;
        tarifa += tarifas[atual][anterior];
        caminhosVert[atual] = aeroportos[atual].getNome() + "-";
        if (!todosVisitados(vertVisitados)) {
            for (int i = 0; i < aeroportos.length; i++) {
                for (int j = 0; j < aeroportos.length; j++) {
                    if (!vertVisitados[j] && tarifas[i][j] != 0) {
                        boolean[] vertVisitadosClone = vertVisitados.clone();
                        caminhosVert[atual] = aeroportos[i].getNome() + "-" + aeroportos[j].getNome();
                        subconjuntoTrechosBfRec(j, i, caminhosVert.clone(), tarifa, vertVisitadosClone);
                    }
                }
            }
        } else {
            if (tarifa < menorTarifa) {
                menorTarifa = tarifa;
                caminhos = caminhosVert.clone();
            }
        }
    }

    public static void subconjuntoTrechos() {
        inicializarVetores();
        int[] menoresTarifas = new int[aeroportos.length];
        for (int i = 0; i < aeroportos.length; i++) {
            menoresTarifas[i] = 0;
        }
        boolean[] arvore = new boolean[aeroportos.length];
        // vetor para checar se vertice pertence a arvore
        arvore[0] = true;
        // vetor para guardar caminhos
        caminhos = new String[aeroportos.length];
        int menor = Integer.MAX_VALUE;
        int indiceMenor1 = 0;
        int indiceMenor2 = 0;
        int atual;
        for (int i = 1; i < aeroportos.length; i++) {
            atual = 0;
            for (int j = 0; j < i; j++) {
                // decidir qual vetor sera analisado
                for (int a = 0; a < arvore.length; a++) {
                    if (arvore[atual]) {
                        a = arvore.length;
                    } else {
                        atual++;
                    }
                }
                // analisar se alguma aresta do atual e' a menor
                for (int k = 0; k < aeroportos.length; k++) {
                    if (tarifas[atual][k] < menor && tarifas[atual][k] != 0 && !arvore[k]) {
                        menor = tarifas[atual][k];
                        indiceMenor1 = atual;
                        indiceMenor2 = k;
                        menoresTarifas[i] = menor;
                    }
                }
                atual++;
            }
            arvore[indiceMenor2] = true;
            caminhos[i] = aeroportos[indiceMenor1].getNome() + "-" + aeroportos[indiceMenor2].getNome();
            menor = Integer.MAX_VALUE;
        }
        menor = menoresTarifas[0];
        for (int i = 1; i < menoresTarifas.length; i++) {
            menor += menoresTarifas[i];
        }
        menorDist.setText("Menor Tarifa: R$" + menor);
    }

    public static void voltaAoMundoBf(Aeroporto partida) {
        boolean[] vertVisitados = new boolean[aeroportos.length];
        menorCaminho = "";
        menorTarifa = Integer.MAX_VALUE;
        for (int i = 0; i < aeroportos.length; i++) {
            vertVisitados[i] = false;
        }
        int indicePartida = hash.get(partida.getNome());
        voltaAoMundoBfRec(indicePartida, indicePartida, menorCaminho, 0, indicePartida, vertVisitados);
        String[] str = menorCaminho.split("-");
        menorTarifa = 0;
        // calcular tarifa baseado do caminho calculado
        for (int i = 0; i < str.length - 1; i++) {
            menorTarifa += (tarifas[hash.get(str[i])][hash.get(str[i + 1])]);
        }
        menorDist.setText("Menor Tarifa: R$" + menorTarifa);
    }

    public static void voltaAoMundoBfRec(int atual, int anterior, String caminho, int tarifa, int primeiro, boolean[] vertVisitados) {
        vertVisitados[atual] = true;
        caminho += aeroportos[atual].getNome() + "-";
        tarifa += tarifas[anterior][atual];
        for (int j = 0; j < aeroportos.length; j++) {
            if (!todosVisitados(vertVisitados)) {
                if (!vertVisitados[j] && tarifas[atual][j] != 0) {
                    boolean[] vertVisitadosClone = vertVisitados.clone();
                    voltaAoMundoBfRec(j, atual, caminho, tarifa, primeiro, vertVisitadosClone);
                }
            } else {
                if (tarifas[atual][primeiro] != 0) {
                    tarifa += tarifas[atual][primeiro];
                    if (tarifa < menorTarifa) {
                        menorTarifa = tarifa;
                        caminho += aeroportos[primeiro].getNome();
                        menorCaminho = caminho;
                    } else {
                        j = aeroportos.length;
                    }
                }
            }
        }
    }

    public static boolean todosVisitados(boolean[] vertVisitados) {
        boolean v = true;
        for (int i = 0; i < vertVisitados.length; i++) {
            if (vertVisitados[i] == false) {
                v = false;
                i = vertVisitados.length;
            }
        }
        return v;
    }

    public static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
        } else {
            for (int i = 0; i < n; i++) {
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
            }
        }

    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
        }
        perm2(a, n);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            perm2(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void voltaAoMundoHeuristica(Aeroporto partida) {
        inicializarVetores();
        int indicePartida = hash.get(partida.getNome());
        int atual = indicePartida;
        int menor;
        int indiceMenor = -1;
        int tarifaTotal = 0;
        String caminho = "";
        // repetir para quase todos aeroportos, o ultimo apenas adicionara
        // o valor da tarifa de volta para o inicial
        for (int i = 0; i < aeroportos.length - 1; i++) {
            visitados[atual] = true;
            menor = Integer.MAX_VALUE;
            for (int j = 0; j < aeroportos.length; j++) {
                // testar se possui aresta e nao foi visitado, nao comparar com vertice inicial
                if (!visitados[j] && tarifas[atual][j] != 0 && tarifas[atual][j] < menor && j != indicePartida) {
                    menor = tarifas[atual][j];
                    indiceMenor = j;
                }
            }
            // atualizar caminho e tarifa total
            caminhos[i] = aeroportos[indiceMenor].getNome();
            tarifaTotal += tarifas[atual][indiceMenor];
            // ir para proximo vertice
            if (indiceMenor >= 0) {
                atual = indiceMenor;
            } else {
                i = aeroportos.length;
            }
        }
        // adicionar dados da volta ao vertice inicial para completar o ciclo
        caminhos[caminhos.length - 1] = partida.getNome();
        tarifaTotal += tarifas[atual][hash.get(partida.getNome())];
        menorDist.setText("Menor Tarifa: R$" + tarifaTotal);
    }

    public static void alturaBf() {
        montarMatrizRotas();
        int qntConjuntos = 0;
        int somatorio = 0;
        menorSomatorio = Integer.MAX_VALUE;
        int[][] conjuntos = new int[matrizRotas.length][matrizRotas.length];
        int altura;
        boolean[] retirados = new boolean[matrizRotas.length];
        boolean[] retiradosAtual = new boolean[matrizRotas.length];
        boolean[] conjuntoAtual = new boolean[matrizRotas.length];
        for (int i = 0; i < matrizRotas.length; i++) {
            for (int j = 0; j < matrizRotas.length; j++) {
                conjuntos[i][j] = -1;
            }
            retirados[i] = false;
            retiradosAtual[i] = false;
            conjuntoAtual[i] = false;
        }
        for (int i = 0; i < matrizRotas.length; i++) {
            alturaBfRec(i, qntConjuntos, somatorio, conjuntos, retirados, retiradosAtual, conjuntoAtual, 0);
        }
        int qnt = 0, maior = Integer.MAX_VALUE, indiceMaior = 0;
        boolean verificados[] = new boolean[matrizRotas.length];
        for (int i = 0; i < matrizRotas.length; i++) {
            verificados[i] = false;
        }
        altura = 10000;
        for (int a = 0; a < matrizRotas.length; a++) {
            qnt = 0;
            for (int i = 0; i < matrizRotas.length; i++) {
                if (!verificados[i]) {
                    for (int j = 0; j < matrizRotas.length; j++) {
                        if (menorConjunto[i][j] != -1) {
                            qnt++;
                        }
                        if (qnt > maior) {
                            maior = qnt;
                            indiceMaior = i;
                        }
                    }
                }
            }
            for (int i = 0; i < matrizRotas.length; i++) {
                if (menorConjunto[indiceMaior][i] != -1 && !verificados[indiceMaior]) {
                    rotas[menorConjunto[indiceMaior][i]].altura = altura;
                } else {
                    i = matrizRotas.length;
                }
            }
            verificados[indiceMaior] = true;
            altura += 1000;
        }
    }

    public static void alturaBfRec(int atual, int qntConjuntos, int somatorio, int[][] conjuntos,
            boolean[] retirados, boolean[] retiradosAtual, boolean[] conjuntoAtual, int numConjunto) {
        if (!todosRetirados(retirados)) {
            // continuar enquanto nao tiver removido todos da iteracao atual
            if (!todosRetirados(retiradosAtual)) {
                // retirar vertice e vizinhos dos vertices dessa iteracao
                retiradosAtual[atual] = true;
                conjuntoAtual[atual] = true;
                for (int i = 0; i < matrizRotas.length; i++) {
                    if (matrizRotas[atual][i] == 1) {
                        retiradosAtual[i] = true;
                    }
                }
                for (int i = 0; i < matrizRotas.length; i++) {
                    if (matrizRotas[atual][i] == 0 && !retiradosAtual[i]) {
                        int[][] conjClone = new int[matrizRotas.length][matrizRotas.length];
                        boolean[] retClone = new boolean[matrizRotas.length];
                        boolean[] retAtClone = new boolean[matrizRotas.length];
                        boolean[] conjAtClone = new boolean[matrizRotas.length];
                        for (int k = 0; k < matrizRotas.length; k++) {
                            for (int j = 0; j < matrizRotas.length; j++) {
                                conjClone[k][j] = conjuntos[k][j];
                            }
                            retClone[k] = retirados[k];
                            retAtClone[k] = retiradosAtual[k];
                            conjAtClone[k] = conjuntoAtual[k];
                        }
                        for (int j = 0; j < matrizRotas.length; j++) {
                            alturaBfRec(i, qntConjuntos, somatorio, conjClone, retClone,
                                    retAtClone, conjAtClone, numConjunto);
                        }
                    }
                }
            }
            // marcar vertices como retirados e adicionar ao conjunto das solucoes atual
            int qnt = 0;
            for (int i = 0; i < matrizRotas.length; i++) {
                if (conjuntoAtual[i]) {
                    retirados[i] = true;
                    conjuntos[numConjunto][qnt] = i;
                    qnt++;
                }
                // reiniciar conjuntoAtual para proxima iteracao
                conjuntoAtual[i] = false;
            }
            retiradosAtual = retirados.clone();
        }
        combinacoes++;
        // calcular somatorio e decidir se e' o menor
        somatorio = 0;
        int maior = Integer.MIN_VALUE;
        int indiceMaior = 0;
        int qnt = 0;
        int qntTotal = 0;
        int altura = 10;
        boolean[] verificados = new boolean[matrizRotas.length];
        for (int i = 0; i < matrizRotas.length; i++) {
            verificados[i] = false;
        }
        for (int a = 0; a < matrizRotas.length; a++) {
            qnt = 0;
            for (int i = 0; i < matrizRotas.length; i++) {
                if (!verificados[i]) {
                    for (int j = 0; j < matrizRotas.length; j++) {
                        if (conjuntos[i][j] != -1) {
                            qnt++;
                            qntTotal++;
                        }
                        if (qnt > maior) {
                            maior = qnt;
                            indiceMaior = i;
                        }
                    }
                }
            }
            verificados[indiceMaior] = true;
            somatorio += qnt * altura;
            altura++;
        }
        if (somatorio < menorSomatorio && qntTotal == matrizRotas.length) {
            menorSomatorio = somatorio;
            menorConjunto = conjuntos.clone();
        }
    }

    public static void alturaHeuristica() {
        montarMatrizRotas();
        int grau;
        int menorGrau = Integer.MAX_VALUE;
        int indiceMenorGrau = 0;
        int altura = 10000;
        boolean[] retirados = new boolean[matrizRotas.length];
        boolean[] retiradosAtual = new boolean[matrizRotas.length];
        boolean[] conjuntoAtual = new boolean[matrizRotas.length];
        for (int i = 0; i < matrizRotas.length; i++) {
            retirados[i] = false;
            retiradosAtual[i] = false;
            conjuntoAtual[i] = false;
        }
        // continuar enquanto nao tiver removido todos vertices do grafo
        while (!todosRetirados(retirados)) {
            // continuar enquanto nao tiver removido todos da iteracao atual
            while (!todosRetirados(retiradosAtual)) {
                // percorrer todos os vertices
                for (int i = 0; i < matrizRotas.length; i++) {
                    grau = 0;
                    if (!retiradosAtual[i]) {
                        // calcular grau do vertice atual
                        for (int j = 0; j < matrizRotas.length; j++) {
                            if (matrizRotas[i][j] == 1) {
                                grau++;
                            }
                        }
                        if (grau == 0) {
                            menorGrau = grau;
                            indiceMenorGrau = i;
                            i = matrizRotas.length;
                        } else if (grau < menorGrau) {
                            menorGrau = grau;
                            indiceMenorGrau = i;
                        }
                    }
                }
                // retirar vertice e vizinhos dos vertices dessa iteracao
                retiradosAtual[indiceMenorGrau] = true;
                conjuntoAtual[indiceMenorGrau] = true;
                for (int i = 0; i < matrizRotas.length; i++) {
                    if (matrizRotas[indiceMenorGrau][i] == 1) {
                        retiradosAtual[i] = true;
                    }
                }
                menorGrau = Integer.MAX_VALUE;
            }
            // marcar vertices como retirados e mudar altura dos que pertencem ao conjunto encontrado
            for (int i = 0; i < matrizRotas.length; i++) {
                if (conjuntoAtual[i]) {
                    rotas[i].altura = altura;
                    retirados[i] = true;
                }
                // reiniciar conjuntoAtual para proxima iteracao
                conjuntoAtual[i] = false;
            }
            retiradosAtual = retirados.clone();
            altura += 1000;
        }

    }

    public static boolean todosRetirados(boolean[] retirados) {
        boolean v = true;
        for (int i = 0; i < matrizRotas.length; i++) {
            if (retirados[i] == false) {
                v = false;
                i = matrizRotas.length;
            }
        }
        return v;
    }

    public static void montarMatrizRotas() {
        matrizRotas = new int[rotas.length][rotas.length];
        int ax, ay, bx, by, cx, cy, dx, dy;
        for (int i = 0; i < rotas.length; i++) {
            matrizRotas[i][i] = 0;
            for (int j = i + 1; j < rotas.length; j++) {
                ax = rotas[i].a1.getLongitude();
                ay = rotas[i].a1.getLatitude();
                bx = rotas[i].a2.getLongitude();
                by = rotas[i].a2.getLatitude();
                cx = rotas[j].a1.getLongitude();
                cy = rotas[j].a1.getLatitude();
                dx = rotas[j].a2.getLongitude();
                dy = rotas[j].a2.getLatitude();
                //starting point of line 1
                Point2D.Double temp1 = new Point2D.Double(ax, ay);
                //ending point of line 1
                Point2D.Double temp2 = new Point2D.Double(bx, by);
                //starting point of line 2
                Point2D.Double temp3 = new Point2D.Double(cx, cy);
                //ending point of line 2
                Point2D.Double temp4 = new Point2D.Double(dx, dy);

                //determine if the lines intersect
                boolean intersects = Line2D.linesIntersect(temp1.x, temp1.y, temp2.x, temp2.y, temp3.x, temp3.y, temp4.x, temp4.y);

                //determines if the lines share an endpoint
                boolean shareAnyPoint = shareAnyPoint(temp1, temp2, temp3, temp4);

                if (intersects && !shareAnyPoint) {
                    matrizRotas[i][j] = 1;
                    matrizRotas[j][i] = 1;
                } else {
                    matrizRotas[i][j] = 0;
                    matrizRotas[j][i] = 0;
                }
            }
        }
    }

    public static int[] coloracaoIngenua() {
        // preencher vetor com cores disponiveis
        // cores e igual ao tamanho de aeroportos pois em grafos completos terao n cores
        int[] cores = new int[rotas.length];
        for (int i = 0; i < rotas.length; i++) {
            cores[i] = i;
        }
        int[] coresRotas = new int[rotas.length];
        // definir cor do vertice inicial
        coresRotas[0] = 0;
        int[] coresVizinhos;
        // percorrer resto dos vertices
        for (int i = 1; i < rotas.length; i++) {
            // reiniciar vetor de cores ja utilizadas pelos vizinhos
            coresVizinhos = new int[rotas.length];
            for (int j = 0; j < rotas.length; j++) {
                coresVizinhos[j] = 0;
            }
            // verificar cores utilizadas pelos vizinhos
            for (int j = 0; j < rotas.length; j++) {
                if (matrizRotas[i][j] != 0) {
                    coresVizinhos[coresRotas[j]] = 1;
                }
            }
            // definir cor como primeira nao utilizada pelos vizinhos
            for (int j = 0; j < rotas.length; j++) {
                if (coresVizinhos[j] != 1) {
                    coresRotas[i] = j;
                    j = rotas.length;
                }
            }
        }
        return coresRotas;
    }

    public static boolean shareAnyPoint(Point2D.Double A, Point2D.Double B, Point2D.Double C, Point2D.Double D) {
        if (isPointOnTheLine(A, B, C)) {
            return true;
        } else if (isPointOnTheLine(A, B, D)) {
            return true;
        } else if (isPointOnTheLine(C, D, A)) {
            return true;
        } else if (isPointOnTheLine(C, D, B)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPointOnTheLine(Point2D.Double A, Point2D.Double B, Point2D.Double P) {
        double m = (B.y - A.y) / (B.x - A.x);

        //handle special case where the line is vertical
        if (Double.isInfinite(m)) {
            if (A.x == P.x) {
                return true;
            } else {
                return false;
            }
        }

        if ((P.y - A.y) == m * (P.x - A.x)) {
            return true;
        } else {
            return false;
        }
    }

    public static void calcularMenorDistancia(Aeroporto partida, Aeroporto destino) {
        inicializarVetores();
        cloneDistancias = new double[aeroportos.length][aeroportos.length];
        for (int i = 0; i < aeroportos.length; i++) {
            for (int j = 0; j < aeroportos.length; j++) {
                cloneDistancias[i][j] = distancias[i][j];
            }
        }
        int indicePartida = hash.get(partida.getNome());
        indiceDestino = hash.get(destino.getNome());
        menor[indicePartida] = 0;
        caminhos[indicePartida] = partida.getNome();
        menorDistancia(partida, destino);
        double menorDistancia = menor[indiceDestino];
        if (menorDistancia != Integer.MAX_VALUE) {
            menorDist.setText("Menor Distancia: " + menorDistancia);
        } else {
            menorDist.setText("Caminho nao encontrado");
        }
    }

    public static void menorDistancia(Aeroporto partida, Aeroporto destino) {
        hash.get(partida.getNome());
        int aeroporto = hash.get(partida.getNome());
        int menorDistancia = Integer.MAX_VALUE;
        int indiceMenorDistancia = 0;
        for (int i = 0; i < aeroportos.length; i++) {
            if (cloneDistancias[aeroporto][i] != 0) {
                if (cloneDistancias[aeroporto][i] + menor[aeroporto] < menor[i]) {
                    menor[i] = cloneDistancias[aeroporto][i] + menor[aeroporto];
                    caminhos[i] = caminhos[aeroporto] + "-" + aeroportos[i].getNome();
                }
                cloneDistancias[i][aeroporto] = 0;
            }
        }
        visitados[aeroporto] = true;
        for (int i = 0; i < visitados.length; i++) {
            if (menor[i] < menorDistancia && !(visitados[i])) {
                menorDistancia = (int) menor[i];
                indiceMenorDistancia = i;
            }
        }
        if (menorDistancia != Integer.MAX_VALUE) {
            menorDistancia(aeroportos[indiceMenorDistancia], destino);
        }
    }

    public static void calcularMenorTarifa(Aeroporto partida, Aeroporto destino) {
        inicializarVetores();
        cloneTarifas = new int[aeroportos.length][aeroportos.length];
        for (int i = 0; i < aeroportos.length; i++) {
            for (int j = 0; j < aeroportos.length; j++) {
                cloneTarifas[i][j] = tarifas[i][j];
            }
        }
        int indicePartida = hash.get(partida.getNome());
        indiceDestino = hash.get(destino.getNome());
        menor[indicePartida] = 0;
        caminhos[indicePartida] = partida.getNome();
        menorTarifa(partida, destino);
        double menorDistancia = menor[indiceDestino];
        if (menorDistancia != Integer.MAX_VALUE) {
            menorDist.setText("Menor Tarifa: R$" + menorDistancia);
        } else {
            menorDist.setText("Caminho nao encontrado");
        }
    }

    public static void menorTarifa(Aeroporto partida, Aeroporto destino) {
        hash.get(partida.getNome());
        int aeroporto = hash.get(partida.getNome());
        int menorTarifa = Integer.MAX_VALUE;
        int indiceMenorTarifa = 0;
        for (int i = 0; i < aeroportos.length; i++) {
            if (cloneTarifas[aeroporto][i] != 0) {
                if (cloneTarifas[aeroporto][i] + menor[aeroporto] < menor[i]) {
                    menor[i] = cloneTarifas[aeroporto][i] + menor[aeroporto];
                    caminhos[i] = caminhos[aeroporto] + "-" + aeroportos[i].getNome();
                }
                cloneTarifas[i][aeroporto] = 0;
            }
        }
        visitados[aeroporto] = true;
        for (int i = 0; i < visitados.length; i++) {
            if (menor[i] < menorTarifa && !(visitados[i])) {
                menorTarifa = (int) menor[i];
                indiceMenorTarifa = i;
            }
        }
        if (menorTarifa != Integer.MAX_VALUE) {
            menorTarifa(aeroportos[indiceMenorTarifa], destino);
        }
    }

    public void lerAeroportos() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(arquivoAeroportos));
        String s = br.readLine();
        String[] str;
        int qnt = Integer.valueOf(s);
        aeroportos = new Aeroporto[qnt];
        hash = new HashMap<String, Integer>();
        for (int i = 0; i < qnt; i++) {
            s = br.readLine();
            str = s.split(" ");
            aeroportos[i] = new Aeroporto(str[0], Double.valueOf(str[1]), Double.valueOf(str[2]), tamanhoX, tamanhoY);
            desenharAeroporto(aeroportos[i].getLongitude(), aeroportos[i].getLatitude(), aeroportos[i].getNome(), Color.BLACK);
            hash.put(str[0], i);
        }
        br.close();
    }

    public void lerRotas() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(arquivoRotas));
        String s = br.readLine();
        String[] str;
        int qnt = Integer.valueOf(s);
        int val;
        rotas = new Rota[qnt];
        hashRotas = new HashMap<Integer, String>();
        inicializarMatrizes();
        for (int i = 0; i < qnt; i++) {
            s = br.readLine();
            str = s.split(" ");
            val = Integer.valueOf(str[2]);
            rotas[i] = new Rota(aeroportos[hash.get(str[0])],
                    aeroportos[hash.get(str[1])], val);
            tarifas[hash.get(str[0])][hash.get(str[1])] = val;
            tarifas[hash.get(str[1])][hash.get(str[0])] = val;
            distancias[hash.get(str[0])][hash.get(str[1])] = calcularDistancia(aeroportos[hash.get(str[0])], aeroportos[hash.get(str[1])]);
            distancias[hash.get(str[1])][hash.get(str[0])] = distancias[hash.get(str[0])][hash.get(str[1])];
            desenharRota(rotas[i].a1.getLongitude(), rotas[i].a1.getLatitude(),
                    rotas[i].a2.getLongitude(), rotas[i].a2.getLatitude(), rotas[i].getPreco(), Color.BLACK);
            hashRotas.put(i, str[0] + "-" + str[1]);
        }
        mostrarMatriz();
        br.close();
    }

    public void inicializarMatrizes() {
        tarifas = new int[aeroportos.length][aeroportos.length];
        distancias = new double[aeroportos.length][aeroportos.length];
        for (int i = 0; i < aeroportos.length; i++) {
            for (int j = 0; j < aeroportos.length; j++) {
                tarifas[i][j] = 0;
                distancias[i][j] = 0;
            }
        }
    }

    public void mostrarMatriz() {
        for (int i = 0; i < aeroportos.length; i++) {
            for (int j = 0; j < aeroportos.length; j++) {
            }
        }
        for (int i = 0; i < aeroportos.length; i++) {
            for (int j = 0; j < aeroportos.length; j++) {
            }
        }
    }

    public double calcularDistancia(Aeroporto partida, Aeroporto destino) {
        return Math.sqrt(((destino.getLongitude() - partida.getLongitude())
                * (destino.getLongitude() - partida.getLongitude()))
                + ((destino.getLatitude() - partida.getLatitude())
                * (destino.getLatitude() - partida.getLatitude())));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarEMostrarGui();
            }
        });
    }
}
