package model;

public class Cliente {
    private String id;
    private String nome;
    private String documento;

    public Cliente(String id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDocumento() { return documento; }

    public void setNome(String nome) { this.nome = nome; }
}
