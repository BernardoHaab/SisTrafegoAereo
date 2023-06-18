package com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces;

import java.util.Date;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;

public interface IRepOcupacao {

    public Ocupacao cadastraOcupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia, Aeronave aeronave);

    public boolean isAeronaveOcupada(String prefixAeronave, Date data, Integer slotHoraInicio, Integer slotHoraFim);

    public boolean isAeroviaOcupada(String nomeAerovia, Date data, Integer slotHoraInicio, Integer slotHoraFim);

}
