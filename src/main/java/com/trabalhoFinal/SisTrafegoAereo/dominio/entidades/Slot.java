package com.trabalhoFinal.SisTrafegoAereo.dominio.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(SlotKey.class)
public class Slot {
    @Id
    private Date data;
    @Id
    private Integer slotHota;

    public Slot(Date data, Integer slotHota) {
        this.data = data;
        this.slotHota = slotHota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getSlotHota() {
        return slotHota;
    }

    public void setSlotHota(Integer slotHota) {
        this.slotHota = slotHota;
    }

    @Override
    public String toString() {
        return "Slot [data=" + data + ", slotHota=" + slotHota + "]";
    }

}
