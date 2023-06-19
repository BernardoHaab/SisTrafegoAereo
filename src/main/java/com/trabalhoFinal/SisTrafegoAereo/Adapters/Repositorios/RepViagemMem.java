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

        System.out.println("viagemNova");
        System.out.println(viagemNova);
        viagens.add(viagemNova);

        return viagemNova;
    }

    @Override
    public boolean removeViagem(Long idViagem) {
        return viagens.removeIf((viagem) -> viagem.getIdViagem().equals(idViagem));
    }

    @Override
    public Viagem getViagem(Long idViagem) {
        return viagens.stream().filter((viagem) -> viagem.getIdViagem().equals(idViagem)).findFirst().orElse(null);
    }

}
