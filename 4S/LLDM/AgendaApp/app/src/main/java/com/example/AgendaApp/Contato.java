
package com.example.AgendaApp;
public class Contato {

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String nascimento;
    private String cep;

    public Contato (String nome, String email, String telefone,String cep, String endereco, String nascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.nascimento = nascimento;
    }

    public Contato () { }
    @Override
    public String toString() {
    return "Nome: " + nome + "\nEmail: " + email + "\nTelefone: " + telefone + "\n" + "CEP: " + cep
            + "\nEndereco: " + endereco + "\nNascimento: " + nascimento;
    }

    public void setId (String id) { this.id = id; }

    public String getId() { return id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
