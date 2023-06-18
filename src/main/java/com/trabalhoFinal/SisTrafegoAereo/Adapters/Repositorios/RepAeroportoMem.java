package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAeroporto;

@Repository
public class RepAeroportoMem implements IRepAeroporto {
    List<Aeroporto> aeroportos = new LinkedList<>();

    public RepAeroportoMem() {
        aeroportos.add(new Aeroporto("Porto Aelegre", "POA"));
        aeroportos.add(new Aeroporto("Florianópolis", "FLO"));
        aeroportos.add(new Aeroporto("Curitiba", "CWB"));
        aeroportos.add(new Aeroporto("São Paulo", "GRU"));
    }

    @Override
    public Aeroporto getAeroporto(String codigoIata) {
        return aeroportos.stream().filter((aeroporto) -> aeroporto.getCodigoIata().equals(codigoIata)).findAny().orElse(null);
    }

}
