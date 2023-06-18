package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

public class Viagem {
    private Long idViagem;
    private String nomeMotorista;
    private Ocupacao ocupacao;

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
