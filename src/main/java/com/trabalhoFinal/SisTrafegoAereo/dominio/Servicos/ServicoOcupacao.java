package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.OcupacaoDTO;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;

@Service
public class ServicoOcupacao {

    // @ToDo: Implementar/Persistir cadastro de ocupação
    public Ocupacao cadastraOcupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia, Aeronave aeronave) {
        return new Ocupacao(data, slotHoraInicio, slotHoraFim, aerovia, aeronave);
    }

    // @ToDo: Implementar verificação se Aerovia esta ocupada
    public boolean isAeroviaOcupada(String nomeAerovia, OcupacaoDTO horarios) {
        return false;
    }

    // @ToDo: Implementar verificação se Aeronave esta ocupada
    public boolean isAeronaveOcupada(String prefixAeronave, OcupacaoDTO horarios) {
        return false;
    }
}
