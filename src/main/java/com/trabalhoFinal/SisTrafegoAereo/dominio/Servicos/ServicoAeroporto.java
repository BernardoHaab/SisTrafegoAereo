package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Utils.Errors.NaoEncontrado;

@Service
public class ServicoAeroporto {
    private IRepAeroporto repAeroporto;

    public ServicoAeroporto(IRepAeroporto repAeroporto) {
        this.repAeroporto = repAeroporto;
    }

    public Aeroporto getAeroporto(String codigoIata) throws NaoEncontrado {
        Aeroporto aeroporto = this.repAeroporto.getAeroporto(codigoIata);

        if (aeroporto == null) {
            throw new NaoEncontrado("Aeroporto não encontrado");
        }

        return aeroporto;
    }

}
