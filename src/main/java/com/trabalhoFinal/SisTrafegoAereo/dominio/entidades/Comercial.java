package com.trabalhoFinal.SisTrafegoAereo.dominio.entidades;

public abstract class Comercial extends Aeronave {
    protected String nomeCompanhia;

    public Comercial(String prefixo, double velocidade, double autonomia, String nomeCompanhia) {
        super(prefixo, velocidade, autonomia);
        this.nomeCompanhia = nomeCompanhia;
    }

    public String getNomeCompanhia() {
        return nomeCompanhia;
    }

    public void setNomeCompanhia(String nomeCompanhia) {
        this.nomeCompanhia = nomeCompanhia;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n\t\tComercial [nomeCompanhia=" + nomeCompanhia + "]";
    }


}
