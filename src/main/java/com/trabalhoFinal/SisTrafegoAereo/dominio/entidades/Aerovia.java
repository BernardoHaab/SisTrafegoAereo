package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aerovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aeroporto origem;

    @ManyToOne
	private Aeroporto destino;
	private float distancia;
	private String nome;
	private int altitude;

    public Aerovia() {

    }

    public Aerovia(Aeroporto origem, Aeroporto destino, float distancia, String nome, int altitude) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.nome = nome;
        this.altitude = altitude;
    }

    public Aerovia(Long id, Aeroporto origem, Aeroporto destino, float distancia, String nome, int altitude) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.nome = nome;
        this.altitude = altitude;
    }

    public Aeroporto getOrigem() {
        return origem;
    }
    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }
    public Aeroporto getDestino() {
        return destino;
    }
    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
    public float getDistancia() {
        return distancia;
    }
    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAltitude() {
        return altitude;
    }
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "Aerovia [id=" + id + ", origem=" + origem + ", destino=" + destino + ", distancia=" + distancia
                + ", nome=" + nome + ", altitude=" + altitude + "]";
    }

}
