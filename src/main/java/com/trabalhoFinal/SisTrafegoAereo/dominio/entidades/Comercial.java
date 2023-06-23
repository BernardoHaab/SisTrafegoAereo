package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("C")
@DiscriminatorColumn(name = "comercial")
public abstract class Comercial extends Aeronave {
    protected String nomeCompanhia;

    public Comercial() {}

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
