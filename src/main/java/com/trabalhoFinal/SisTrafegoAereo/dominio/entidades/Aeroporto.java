package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Aeroporto {
    private String codigoIata;

    private String cidade;

    public Aeroporto(String cidade, String codigoIata) {
        this.cidade = cidade;
        this.codigoIata = codigoIata;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCodigoIata() {
        return codigoIata;
    }

    public void setCodigoIata(String codigoIata) {
        this.codigoIata = codigoIata;
    }

    @Override
    public String toString() {
        return "Aeroporto [cidade=" + cidade + ", codigoIata=" + codigoIata + "]";
    }
}
