package model;

public class Produto {
    private String id;
    private String nome;
    private double precoBase;

    public Produto(String id, String nome, double precoBase) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getPrecoBase() { return precoBase; }

    public void setNome(String nome) { this.nome = nome; }
    public void setPrecoBase(double precoBase) { this.precoBase = precoBase; }
}

