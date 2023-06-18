package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.Date;
import java.util.List;

public record OcupacaoDTO(
        Date data,
        List<Integer> slots) {

}
