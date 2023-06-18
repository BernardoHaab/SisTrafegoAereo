package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAerovia;

@Repository
public class RepAeroviaMem implements IRepAerovia {
    List<Aerovia> aerovias = new LinkedList<>();

    public RepAeroviaMem() {
        Aeroporto poa = new Aeroporto("Porto Aelegre", "POA");
        Aeroporto flo = new Aeroporto("Florianópolis", "FLO");
        Aeroporto cwb = new Aeroporto("Curitiba", "CWB");
        Aeroporto gru = new Aeroporto("São Paulo", "GRU");

        aerovias.add(new Aerovia(poa, flo, 450, "POA-FLO", 30000));
        aerovias.add(new Aerovia(flo, poa, 450, "FLO-POA", 30000));

        aerovias.add(new Aerovia(poa, gru, 1100, "POA-GRU", 28000));
        aerovias.add(new Aerovia(gru, poa, 1100, "GRU-POA", 28000));

        aerovias.add(new Aerovia(cwb, gru, 400, "CWB-GRU", 33000));
        aerovias.add(new Aerovia(gru, cwb, 400, "GRU-CWB", 33000));

        aerovias.add(new Aerovia(cwb, flo, 300, "CWB-FLO", 25000));
        aerovias.add(new Aerovia(flo, cwb, 300, "FLO-CWB", 25000));
    }

    @Override
    public Aerovia busca(String nome, int altitude) {
        return this.aerovias.stream()
                .filter((aerovia) -> aerovia.getNome().equals(nome) && aerovia.getAltitude() == altitude).findFirst()
                .orElse(null);
    }

    @Override
    public boolean existeAerovia(String nome, int altitude) {
        return this.aerovias.stream()
                .filter((aerovia) -> aerovia.getNome().equals(nome) && aerovia.getAltitude() == altitude).findAny().isPresent();
    }

}
