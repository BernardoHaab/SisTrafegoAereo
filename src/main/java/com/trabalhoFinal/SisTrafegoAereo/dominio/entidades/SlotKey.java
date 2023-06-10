package com.trabalhoFinal.SisTrafegoAereo.dominio.entidades;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class SlotKey implements Serializable {
    private Date data;
    private Integer slotHota;


    public SlotKey(Date data, Integer slotHota) {
        this.data = data;
        this.slotHota = slotHota;
    }

}
