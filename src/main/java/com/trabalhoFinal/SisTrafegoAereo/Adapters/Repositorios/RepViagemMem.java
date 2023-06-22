package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.server.NotAcceptableStatusException;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepViagem;

@Repository
public class RepViagemMem implements IRepViagem {
    private List<Viagem> viagens = new LinkedList<>();

    @Override
    public Viagem cadastraViagem(Long idViagem, String nomePiloto, Ocupacao ocupacao) throws RuntimeException {
        if (existeViagem(idViagem)) {
            throw new NotAcceptableStatusException("Id já usado em outra viagem");
        }

        Viagem viagemNova = new Viagem(idViagem, nomePiloto, ocupacao);

        viagens.add(viagemNova);

        return viagemNova;
    }

    @Override
    public boolean removeViagem(Long idViagem) {
        return viagens.removeIf((viagem) -> viagem.getIdViagem().equals(idViagem));
    }

    @Override
    public boolean existeViagem(Long idViagem) {
        return viagens.stream().filter((viagem) -> viagem.getIdViagem().equals(idViagem)).findAny().isPresent();
    }

    @Override
    public Viagem getViagem(Long idViagem) {
        return viagens.stream().filter((viagem) -> viagem.getIdViagem().equals(idViagem)).findFirst().orElse(null);
    }

}
