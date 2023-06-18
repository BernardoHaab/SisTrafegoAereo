package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepViagem;

@Service
public class ServicoViagem {

    private IRepViagem repViagem;

    @Autowired
    public ServicoViagem(IRepViagem repViagem) {
        this.repViagem = repViagem;
    }

    public Viagem cadastraViagem(Long id, String piloto, Ocupacao ocupacao) {
        return this.repViagem.cadastraViagem(id, piloto, ocupacao);
    }

}
