package com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

public interface IRepAerovia {

    public Aerovia busca(String nome, int altitude);

}
