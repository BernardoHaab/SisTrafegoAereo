package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.Date;
import java.util.List;

public record CadastraViagemDTO(
        Long id,
        String prefixoAeronave,
        String nomeAerovia,
        String nomePiloto,
        int altitude,
        Date data,
        List<Integer> slots) {
}
