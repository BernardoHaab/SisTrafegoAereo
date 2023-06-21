package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Aeronave {
    @Id
	protected String prefixo;
	protected Double velocidade;
	protected Double autonomia;

    public Aeronave(String prefixo, Double velocidade, Double autonomia) {
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
    public Double getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }
    public Double getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(Double autonomia) {
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return "Aeronave [prefixo=" + prefixo + ", velocidade=" + velocidade + ", autonomia=" + autonomia + "]";
    }

}
