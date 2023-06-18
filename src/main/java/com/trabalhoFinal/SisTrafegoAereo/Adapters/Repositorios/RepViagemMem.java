package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepViagem;

@Repository
public class RepViagemMem implements IRepViagem {
    private List<Viagem> viagens = new LinkedList<>();

    @Override
    public Viagem cadastraViagem(Long idViagem, String nomePiloto, Ocupacao ocupacao) {
        Viagem viagemNova = new Viagem(idViagem, nomePiloto, ocupacao);
        viagens.add(viagemNova);

        return viagemNova;
    }

}
