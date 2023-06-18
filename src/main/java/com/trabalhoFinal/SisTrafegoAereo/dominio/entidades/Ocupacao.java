package com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades;

import java.util.Date;

public class Ocupacao {
    private Date data;
    private Integer slotHoraInicio;
    private Integer slotHoraFim;
    private Aerovia aerovia;
    private Aeronave aeronave;

    public Ocupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia, Aeronave aeronave) {
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

    @Override
    public String toString() {
        return "Ocupacao [data=" + data + ", slotHoraInicio=" + slotHoraInicio + ", slotHoraFim=" + slotHoraFim
                + ", aerovia=" + aerovia + ", aeronave=" + aeronave + "]";
    }

}
