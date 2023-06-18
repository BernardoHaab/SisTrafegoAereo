package com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;

public interface IRepViagem {
    public Viagem cadastraViagem(Long idViagem, String nomePiloto, Ocupacao ocupacao);
}
