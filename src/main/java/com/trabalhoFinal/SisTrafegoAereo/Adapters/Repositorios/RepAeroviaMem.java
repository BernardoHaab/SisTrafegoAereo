package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAerovia;

@Repository
public class RepAeroviaMem implements IRepAerovia {
    List<Aerovia> aerovias = new LinkedList<>();
    RepOcupacaoMem repOcupacaoMem;

    @Autowired
    public RepAeroviaMem(RepAeroportoMem repAeroportoMem, RepOcupacaoMem repOcupacaoMem) {
        this.repOcupacaoMem = repOcupacaoMem;

        Aeroporto poa = repAeroportoMem.getAeroporto("POA");
        Aeroporto flo = repAeroportoMem.getAeroporto("FLO");
        Aeroporto cwb = repAeroportoMem.getAeroporto("CWB");
        Aeroporto gru = repAeroportoMem.getAeroporto("GRU");

        aerovias.add(new Aerovia(poa, flo, 450, "POA-FLO", 30000));
        aerovias.add(new Aerovia(poa, flo, 450, "POA-FLO", 290000));
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

    @Override
    public List<Aerovia> listaAerovias(Aeroporto origem, Aeroporto destino) {
        return this.aerovias.stream()
        .filter((aerovia) -> aerovia.getOrigem().equals(origem))
        .filter((aerovia) -> aerovia.getDestino().equals(destino))
        .toList();
    }

    @Override
    public List<Integer> getAltitudesLivres(String nomeAerovia, Date data, Integer slotHora) {
        List<Integer> todasAltitudes = aerovias.stream()
            .filter((aerovia) -> aerovia.getNome().equals(nomeAerovia))
            .map((aerovia) -> aerovia.getAltitude())
            .toList();

        List<Integer> ocupadas = this.repOcupacaoMem.getAltitudesOcupadas(nomeAerovia, data, slotHora);

        return todasAltitudes.stream().filter((al) -> !ocupadas.contains(al)).toList();
    }

}
