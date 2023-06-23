package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

public interface IRepAeroviaCRUD extends CrudRepository<Aerovia, Long> {
    Aerovia findByNomeAndAltitude(String nome, int altitude);

    List<Aerovia> findByOrigemAndDestino(Aeroporto origem, Aeroporto destino);

    @Modifying
    @Query("SELECT a.altitude FROM Aerovia a WHERE a.nome = :nomeAerovia AND NOT EXISTS ( SELECT o.aerovia FROM Ocupacao o WHERE o.aerovia.nome = :nomeAerovia AND o.data = :data AND :slotHora >= o.slotHoraInicio AND :slotHora <= o.slotHoraFim)")
    List<Integer> findAlitutudesLivres(String nomeAerovia, Date data, Integer slotHora);

}
