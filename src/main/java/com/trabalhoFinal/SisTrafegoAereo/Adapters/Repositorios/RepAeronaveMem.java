package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.ComercialCarga;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.ComercialPassageiros;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.PequenoPorte;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAeronave;

@Repository
public class RepAeronaveMem implements IRepAeronave {
    List<Aeronave> aeronaves = new LinkedList<>();

    public RepAeronaveMem() {
        aeronaves.add(new PequenoPorte("PPABC", 850, 1500, "Paulo"));
        aeronaves.add(new ComercialCarga("PPSTD", 850, 3000, "Paulo", 10000));
        aeronaves.add(new ComercialPassageiros("PTFGH", 850, 3000, "Paulo", 100));
    }

    @Override
    public Aeronave buscaPorPrefixo(String prefixo) {
        return aeronaves.stream().filter((aeronave) -> aeronave.getPrefixo().equals(prefixo)).findFirst().orElse(null);
    }

}
