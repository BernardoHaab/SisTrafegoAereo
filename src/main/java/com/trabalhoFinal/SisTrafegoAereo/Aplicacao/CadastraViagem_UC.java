package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.NotAcceptableStatusException;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoOcupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoViagem;
import com.trabalhoFinal.SisTrafegoAereo.Utils.Validation.ValidaSlots;

@Component
public class CadastraViagem_UC {
    private ServicoViagem servicoViagem;
    private ServicoOcupacao servicoOcupacao;
    private ServicoAerovia servicoAerovia;
    private ServicoAeronave servicoAeronave;

    @Autowired
    public CadastraViagem_UC(ServicoViagem servicoViagem, ServicoOcupacao servicoOcupacao, ServicoAerovia servicoAerovia, ServicoAeronave servicoAeronave) {
        this.servicoViagem = servicoViagem;
        this.servicoOcupacao = servicoOcupacao;
        this.servicoAerovia = servicoAerovia;
        this.servicoAeronave = servicoAeronave;
    }

    public Viagem run(CadastraViagemDTO cadastraViagemDTO) throws RuntimeException {

        OcupacaoDTO ocDto = new OcupacaoDTO(cadastraViagemDTO.data(), cadastraViagemDTO.slots());

        if (servicoOcupacao.isAeroviaOcupada(cadastraViagemDTO.nomeAerovia(), ocDto)) {
            throw new NotAcceptableStatusException("Aerovia Ocupada");
        } else if (servicoOcupacao.isAeronaveOcupada(cadastraViagemDTO.prefixoAeronave(), ocDto)) {
            throw new NotAcceptableStatusException("Aeronave ocupada");
        }

        if (!ValidaSlots.valida(cadastraViagemDTO.slots())) {
            throw new NotAcceptableStatusException("Slot de hora deve estar no intervalo 0-23");
        };

        Ocupacao ocupacao = criaOcupacao(cadastraViagemDTO);

        return this.servicoViagem.cadastraViagem(cadastraViagemDTO.id(), cadastraViagemDTO.nomePiloto(), ocupacao);
    }

    private Ocupacao criaOcupacao(CadastraViagemDTO cadastraViagemDTO) {
        List<Integer> sortedSlots =  cadastraViagemDTO.slots().stream().sorted().toList();
        Integer slotHoraInicio = sortedSlots.get(0);
        Integer slotHoraFim = sortedSlots.get(sortedSlots.size()-1);
        Aeronave aeronave = this.servicoAeronave.buscaPorPrefixo(cadastraViagemDTO.prefixoAeronave());

        if (aeronave == null) {
            throw new NotAcceptableStatusException("Aeronave desconhecida");
        }

        Aerovia aerovia = this.servicoAerovia.buscaPorNome(cadastraViagemDTO.nomeAerovia());

        if (aerovia == null) {
            throw new NotAcceptableStatusException("Aerovia desconhecida");
        }

        return this.servicoOcupacao.cadastraOcupacao(
            cadastraViagemDTO.data(),
            slotHoraInicio,
            slotHoraFim,
            aerovia,
            aeronave);
    }


}
