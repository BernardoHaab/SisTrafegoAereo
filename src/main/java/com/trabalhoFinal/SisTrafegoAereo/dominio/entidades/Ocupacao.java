package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ocupacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Integer slotHoraInicio;
    private Integer slotHoraFim;
    @ManyToOne
    private Aerovia aerovia;
    @ManyToOne
    private Aeronave aeronave;

    public Ocupacao() {}

    public Ocupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia, Aeronave aeronave) {
        this.data = data;
        this.slotHoraInicio = slotHoraInicio;
        this.slotHoraFim = slotHoraFim;
        this.aerovia = aerovia;
        this.aeronave = aeronave;
    }

    public Ocupacao(Long id, Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia,
            Aeronave aeronave) {
        this.id = id;
        this.data = data;
        this.slotHoraInicio = slotHoraInicio;
        this.slotHoraFim = slotHoraFim;
        this.aerovia = aerovia;
        this.aeronave = aeronave;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getSlotHoraInicio() {
        return slotHoraInicio;
    }

    public void setSlotHoraInicio(Integer slotHoraInicio) {
        this.slotHoraInicio = slotHoraInicio;
    }

    public Integer getSlotHoraFim() {
        return slotHoraFim;
    }

    public void setSlotHoraFim(Integer slotHoraFim) {
        this.slotHoraFim = slotHoraFim;
    }

    public Aerovia getAerovia() {
        return aerovia;
    }

    public void setAerovia(Aerovia aerovia) {
        this.aerovia = aerovia;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ocupacao [id=" + id + ", data=" + data + ", slotHoraInicio=" + slotHoraInicio + ", slotHoraFim="
                + slotHoraFim + ", aerovia=" + aerovia + ", aeronave=" + aeronave + "]";
    }

}
