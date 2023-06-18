package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.IRepViagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;

@Service
public class ServicoViagem {
    private ServicoOcupacao servicoOcupacao;
    private ServicoAeronave servicoAeronave;
    private ServicoAerovia servicoAerovia;

    private IRepViagem repViagem;

    @Autowired
    public ServicoViagem(ServicoOcupacao servicoOcupacao, ServicoAeronave servicoAeronave, ServicoAerovia servicoAerovia, IRepViagem repViagem) {
        this.servicoOcupacao = servicoOcupacao;
        this.servicoAeronave = servicoAeronave;
        this.servicoAerovia = servicoAerovia;
        this.repViagem = repViagem;
    }

    public Viagem cadastraViagem(Long id, String piloto, Ocupacao ocupacao) {
        return this.repViagem.cadastraViagem(id, piloto, ocupacao);
    }

}
