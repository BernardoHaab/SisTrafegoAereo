package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAeronave;
import com.trabalhoFinal.SisTrafegoAereo.Utils.Errors.NaoEncontrado;

@Service
public class ServicoAeronave {
    private IRepAeronave repAeronave;

    public ServicoAeronave(IRepAeronave repAeronave) {
        this.repAeronave = repAeronave;
    }

    public Aeronave buscaPorPrefixo(String prefixo) throws NaoEncontrado {
        Aeronave aeronave = this.repAeronave.buscaPorPrefixo(prefixo);

        if (aeronave == null) {
            throw new NaoEncontrado("Aeronave desconhecida");
        }

        return aeronave;
    }
}
