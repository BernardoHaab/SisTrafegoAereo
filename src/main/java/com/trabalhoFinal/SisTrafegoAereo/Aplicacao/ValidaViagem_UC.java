package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoOcupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoViagem;

@Component
public class ValidaViagem_UC {
    private ServicoOcupacao servicoOcupacao;
    private ServicoAeronave servicoAeronave;
    private ServicoAerovia servicoAerovia;
    private ServicoViagem servicoViagem;

    public ValidaViagem_UC(ServicoOcupacao servicoOcupacao, ServicoAeronave servicoAeronave, ServicoAerovia servicoAerovia, ServicoViagem servicoViagem) {
        this.servicoOcupacao = servicoOcupacao;
        this.servicoAeronave = servicoAeronave;
        this.servicoAerovia = servicoAerovia;
        this.servicoViagem = servicoViagem;
    }

    public List<String> run(ViagemDTO viagemDTO) {
        List<String> res = new LinkedList<>();

        List<Integer> sortedSlots =  viagemDTO.slots().stream().sorted().toList();
        Integer slotHoraInicio = sortedSlots.get(0);
        Integer slotHoraFim = sortedSlots.get(sortedSlots.size()-1);

        if (this.servicoViagem.existeViagemId(viagemDTO.id())) {
            res.add("Id já usado em outra viagem.");
        }

        if (!this.servicoOcupacao.isSlotOcupacaoValido(slotHoraInicio, slotHoraFim)) {
            res.add("Slots de hora inválidos.");
        }

        if (!servicoAeronave.existeAeronave(viagemDTO.prefixoAeronave())) {
            res.add("Aeronave desconhecida");
        } else if (this.servicoOcupacao.isAeronaveOcupada(viagemDTO.prefixoAeronave(), viagemDTO.data(), slotHoraInicio, slotHoraFim)) {
            res.add("Aeronave ocupada.");
        }

        if (!servicoAerovia.existeAerovia(viagemDTO.nomeAerovia(), viagemDTO.altitude())) {
            res.add("Aerovia desconhecida");
        } else if (this.servicoOcupacao.isAeroviaOcupada(viagemDTO.nomeAerovia(), viagemDTO.altitude(), viagemDTO.data(), slotHoraInicio, slotHoraFim)) {
            res.add("Aerovia ocupada.");
        }

        if (res.size() == 0) {
            res.add("Aprovado");
        }

        return res;
    }

}
