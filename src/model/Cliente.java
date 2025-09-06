package model;

public class Cliente {
    private String id;
    private String nome;
    private String documento; // CPF

    public Cliente(String id, String nome, String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento é obrigatório.");
        }
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDocumento() { return documento; }
}
