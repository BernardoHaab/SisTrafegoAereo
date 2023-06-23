package com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces;

import java.util.Date;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;

public interface IRepOcupacao {

    public Ocupacao cadastraOcupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia, Aeronave aeronave);

    public boolean isAeronaveOcupada(Aeronave aeronave, Date data, Integer slotHoraInicio, Integer slotHoraFim);

    public boolean isAeroviaOcupada(Aerovia aerovia, Date data, Integer slotHoraInicio, Integer slotHoraFim);

    public boolean liberaOcupacao(Ocupacao ocupacao);

}
