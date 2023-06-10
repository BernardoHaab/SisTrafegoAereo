package com.trabalhoFinal.SisTrafegoAereo.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class Aeronave {

    @Id
    @Column(length = 3)
	protected String prefixo;
	protected double velocidade;
	protected double autonomia;

    public Aeronave(String prefixo, double velocidade, double autonomia) {
        this.prefixo = prefixo;
        this.velocidade = velocidade;
        this.autonomia = autonomia;
    }

    public String getPrefixo() {
        return prefixo;
    }
    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    public double getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    public double getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return "Aeronave [prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia + "]";
    }

}
