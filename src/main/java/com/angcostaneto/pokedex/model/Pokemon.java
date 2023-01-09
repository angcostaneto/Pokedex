package com.angcostaneto.pokedex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pokemon {
    @Id
    private String id;
    private String nome;
    private String categoria;
    private String habilidade;
    private Double peso;

    public Pokemon(String id, String nome, String categoria, String habilidade, Double peso) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.habilidade = habilidade;
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * Necssario para ter uma persistencia de dados
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon pokemon)) return false;

        if (getId() != null ? !getId().equals(pokemon.getId()) : pokemon.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(pokemon.getNome()) : pokemon.getNome() != null) return false;
        if (getCategoria() != null ? !getCategoria().equals(pokemon.getCategoria()) : pokemon.getCategoria() != null)
            return false;
        if (getHabilidade() != null ? !getHabilidade().equals(pokemon.getHabilidade()) : pokemon.getHabilidade() != null)
            return false;
        return getPeso() != null ? getPeso().equals(pokemon.getPeso()) : pokemon.getPeso() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getCategoria() != null ? getCategoria().hashCode() : 0);
        result = 31 * result + (getHabilidade() != null ? getHabilidade().hashCode() : 0);
        result = 31 * result + (getPeso() != null ? getPeso().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", habilidade='" + habilidade + '\'' +
                ", peso=" + peso +
                '}';
    }
}
