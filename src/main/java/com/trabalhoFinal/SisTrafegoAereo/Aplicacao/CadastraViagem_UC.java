package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoOcupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoViagem;

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

    public Viagem run(ViagemDTO cadastraViagemDTO) throws RuntimeException {
        Ocupacao ocupacao = criaOcupacao(cadastraViagemDTO);

        return this.servicoViagem.cadastraViagem(cadastraViagemDTO.id(), cadastraViagemDTO.nomePiloto(), ocupacao);
    }

    private Ocupacao criaOcupacao(ViagemDTO cadastraViagemDTO) throws RuntimeException {
        List<Integer> sortedSlots = cadastraViagemDTO.slots().stream().sorted().toList();
        Integer slotHoraInicio = sortedSlots.get(0);
        Integer slotHoraFim = sortedSlots.get(sortedSlots.size()-1);
        Aeronave aeronave = this.servicoAeronave.buscaPorPrefixo(cadastraViagemDTO.prefixoAeronave());

        Aerovia aerovia = this.servicoAerovia.busca(cadastraViagemDTO.nomeAerovia(), cadastraViagemDTO.altitude());

        return this.servicoOcupacao.cadastraOcupacao(
            cadastraViagemDTO.data(),
            slotHoraInicio,
            slotHoraFim,
            aerovia,
            aeronave);
    }


}
