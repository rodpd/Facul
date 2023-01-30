package com.example.pfinal;

import java.util.ArrayList;

public class Audio {

    String nome;
    ArrayList<Integer>  notas;
    ArrayList<Long> intervalos;

    public Audio ( ) {
        this.nome = "";
        this.notas = new ArrayList();
        this.intervalos = new ArrayList();
    }

    public Audio ( ArrayList<Integer>  notas, ArrayList<Long>  intervalos ) {
        this.notas = notas;
        this.intervalos = intervalos;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public ArrayList<Long> getIntervalos() {
        return intervalos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public void setIntervalos(ArrayList<Long> intervalos) {
        this.intervalos = intervalos;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "nome='" + nome + '\'' +
                ", notas=" + notas +
                ", intervalos=" + intervalos +
                '}';
    }
}
