package br.com.sistemacompra.model;

public class Mercado {
    private int id;
    private int descricao;

    public Mercado(int descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
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
