package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;

public interface IRepOcupacaoCRUD extends CrudRepository<Ocupacao, Long> {

    boolean existsByAeroviaAndDataAndSlotHoraInicioAndSlotHoraFim(Aerovia aerovia, Date data, Integer slotHoraInicio, Integer slotHoraFim);

    boolean existsByAeronaveAndDataAndSlotHoraInicioAndSlotHoraFim(Aeronave aeronave, Date data, Integer slotHoraInicio, Integer slotHoraFim);
}
