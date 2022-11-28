package br.edu.infnet.pedido.model.entidade;

import java.util.Objects;


public abstract class Colaborador  {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;


    @Override
    public String toString() {
        return nome + "; " + email + "; " + telefone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Colaborador other = (Colaborador) obj;
        if (nome != other.nome)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}