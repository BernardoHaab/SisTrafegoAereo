package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

public interface IRepAeroviaCRUD extends CrudRepository<Aerovia, Long> {
    List<Aerovia> findByOrigemDestino(Aeroporto origem, Aeroporto destino);
}
