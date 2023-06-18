package com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;

public interface IRepAeronave {

    public Aeronave buscaPorPrefixo(String prefixo);

    public boolean existeAeronave(String prefixo);

}
