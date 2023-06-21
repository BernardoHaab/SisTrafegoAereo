package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CP")
public class ComercialPassageiros extends Comercial {
    private int id;
    private int maxPassageiros;

    public ComercialPassageiros(String prefixo, double velocidade, double autonomia, String nomeCompanhia,
            int maxPassageiros) {
        super(prefixo, velocidade, autonomia, nomeCompanhia);
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n\t\tComercialPassageiros [maxPassageiros=" + maxPassageiros + "]";
    }

}
