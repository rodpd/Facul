package com.example.a06;

public class Contato {

    private int id;
    private String nome;
    private String email;
    private int telefone;
    private String endereco;
    private String nascimento;

    public Contato (String nome, String email, int telefone, String endereco, String nascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return nome + "\n" + email + "\n" + telefone + "\n" + endereco + "\n" + nascimento + "\n" + id;
    }

    public void setId (int id) { this.id = id; }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
