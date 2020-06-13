package vendas.fornecedor;

public class Fornecedor {
    private int id;
    private String nome;
    private String email;
    private boolean ativo;
    private String observacoes;

    public Fornecedor() {
    }

    public Fornecedor(int id, String nome, String email, boolean ativo, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", ativo=" + ativo + ", observacoes=" + observacoes + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
