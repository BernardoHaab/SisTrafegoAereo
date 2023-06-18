package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAeronave;

@Service
public class ServicoAeronave {
    private IRepAeronave repAeronave;

    public ServicoAeronave(IRepAeronave repAeronave) {
        this.repAeronave = repAeronave;
    }

    public Aeronave buscaPorPrefixo(String prefixo) {
        return this.repAeronave.buscaPorPrefixo(prefixo);
    }
}
