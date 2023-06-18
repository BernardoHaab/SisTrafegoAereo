package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

public abstract class Aeronave {

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
