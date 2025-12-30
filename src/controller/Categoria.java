package controller;

import java.io.Serializable;

public class Categoria implements Serializable {

    private String nome;

    public Categoria() {
        this.nome = "";
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguais = false;

        if (obj != null && this.getClass() == obj.getClass()) {
            Categoria c = (Categoria) obj;
            iguais = this.nome.equals(c.nome);
        }

        return iguais;
    }

    @Override
    public Object clone() {
        Categoria clone = new Categoria (this.nome);
        return clone;
    }
}
