package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import org.springframework.data.repository.CrudRepository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;

public interface IRepAeroportoCRUD extends CrudRepository<Aeroporto, String> {
    Aeroporto findByCodigoIata(String codigoIata);
}
