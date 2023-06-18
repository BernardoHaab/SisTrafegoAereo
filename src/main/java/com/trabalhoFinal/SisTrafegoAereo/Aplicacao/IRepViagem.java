package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;

public interface IRepViagem {
    public Viagem cadastraViagem(Long idViagem, String nomePiloto, Ocupacao ocupacao);
}
