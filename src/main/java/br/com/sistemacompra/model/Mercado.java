package br.com.sistemacompra.model;

public class Mercado {
    private Long id;
    private String descricao;

    public Mercado() {

    }

    public Mercado(String descricao) {
        this.descricao = descricao;
    }

    public Mercado(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Mercado{" +
                "id=" + id +
                ", descricao=" + descricao +
                '}';
    }
}
