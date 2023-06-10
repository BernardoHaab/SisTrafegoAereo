package com.trabalhoFinal.SisTrafegoAereo.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComercialPassageiros extends Comercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
