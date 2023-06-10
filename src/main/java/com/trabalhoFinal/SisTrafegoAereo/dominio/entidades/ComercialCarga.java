package com.trabalhoFinal.SisTrafegoAereo.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComercialCarga extends Comercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double cargaMax;

    public ComercialCarga(String prefixo, double velocidade, double autonomia, String nomeCompanhia, double cargaMax) {
        super(prefixo, velocidade, autonomia, nomeCompanhia);
        this.cargaMax = cargaMax;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(double cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n\t\tComercialCarga [cargaMax=" + cargaMax + "]";
    }

}
