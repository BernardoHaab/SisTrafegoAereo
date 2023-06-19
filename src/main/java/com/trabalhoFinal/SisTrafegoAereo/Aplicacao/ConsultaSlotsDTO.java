package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.time.LocalTime;
import java.util.Date;

public record ConsultaSlotsDTO(
    String rota,
    Date data,
    LocalTime horario
) {

}
