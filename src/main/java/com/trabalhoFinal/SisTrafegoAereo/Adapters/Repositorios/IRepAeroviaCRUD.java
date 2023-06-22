package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

public interface IRepAeroviaCRUD extends CrudRepository<Aerovia, Long> {
    Aerovia listByNomeAndAltitude(String nome, int altitude);
    // List<Aerovia> listByNomeAndAltitude(String nome, int altitude);
    List<Aerovia> findByOrigemAndDestino(Aeroporto origem, Aeroporto destino);
}
