package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViagem;
    private String nomeMotorista;
    @ManyToOne
    private Ocupacao ocupacao;

    public Viagem() {}

    public Viagem(Long idViagem, String nomeMotorista, Ocupacao ocupacao) {
        this.idViagem = idViagem;
        this.nomeMotorista = nomeMotorista;
        this.ocupacao = ocupacao;
    }

    public Long getIdViagem() {
        return idViagem;
    }
    public void setIdViagem(Long idViagem) {
        this.idViagem = idViagem;
    }
    public String getNomeMotorista() {
        return nomeMotorista;
    }
    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }
    public Ocupacao getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(Ocupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return "Viagem [idViagem=" + idViagem + ", nomeMotorista=" + nomeMotorista + ", ocupacao=" + ocupacao + "]";
    }

}
