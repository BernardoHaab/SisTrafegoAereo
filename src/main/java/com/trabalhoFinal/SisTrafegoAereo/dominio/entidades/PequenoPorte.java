package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class PequenoPorte extends Aeronave {
    private String nomeManutencao;

    public PequenoPorte() {}

    public PequenoPorte(String prefixo, double velocidade, double autonomia, String nomeManutencao) {
        super(prefixo, velocidade, autonomia);
        this.nomeManutencao = nomeManutencao;
    }

    public String getNomeManutencao() {
        return nomeManutencao;
    }

    public void setNomeManutencao(String nomeManutencao) {
        this.nomeManutencao = nomeManutencao;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n\t\tPequenoPorte [nomeManutencao=" + nomeManutencao + "]";
    }
}
