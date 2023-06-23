package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import org.springframework.data.repository.CrudRepository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;

public interface IRepViagemCRUD extends CrudRepository<Viagem, Long> {

}
