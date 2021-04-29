package com.example.examplecontacts;

import java.io.Serializable;

public class Contatto implements Serializable {
    private int id;
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(int id, String nome, String cognome, String telefono) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return ""+id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
