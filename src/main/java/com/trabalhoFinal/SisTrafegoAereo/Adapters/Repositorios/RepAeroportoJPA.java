package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAeroporto;

@Repository
@Primary
public class RepAeroportoJPA implements IRepAeroporto {
    private IRepAeroportoCRUD crudAeroporto;

    @Autowired
    public RepAeroportoJPA(IRepAeroportoCRUD crudAeroporto) {
        this.crudAeroporto = crudAeroporto;
    }

    @Override
    public Aeroporto getAeroporto(String codigoIata) {
        return this.crudAeroporto.findByCodigoIata(codigoIata);
    }

}
