package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAerovia;
import com.trabalhoFinal.SisTrafegoAereo.Utils.Errors.NaoEncontrado;

@Service
public class ServicoAerovia {
    private IRepAerovia repAerovia;

    @Autowired
    public ServicoAerovia(IRepAerovia repAerovia) {
        this.repAerovia = repAerovia;
    }

    public Aerovia busca(String nome, int altitude) throws NaoEncontrado {
        Aerovia aerovia = this.repAerovia.busca(nome, altitude);

        if (aerovia == null) {
            throw new NaoEncontrado("Aerovia desconhecida");
        }

        return aerovia;
    }

}
