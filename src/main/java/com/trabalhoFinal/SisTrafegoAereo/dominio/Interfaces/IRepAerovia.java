package com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces;

import java.util.List;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

public interface IRepAerovia {

    public Aerovia busca(String nome, int altitude);

    public boolean existeAerovia(String nome, int altitude);

    public List<Aerovia> listaAerovias(Aeroporto origem, Aeroporto destino);
}
