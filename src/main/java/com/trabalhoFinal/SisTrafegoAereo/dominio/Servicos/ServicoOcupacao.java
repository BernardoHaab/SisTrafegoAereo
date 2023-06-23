package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepOcupacao;

@Service
public class ServicoOcupacao {
    private IRepOcupacao repOcupacao;
    private ServicoAeronave servicoAeronave;
    private ServicoAerovia servicoAerovia;

    public ServicoOcupacao(IRepOcupacao repOcupacao, ServicoAeronave servicoAeronave, ServicoAerovia servicoAerovia) {
        this.repOcupacao = repOcupacao;
        this.servicoAeronave = servicoAeronave;
        this.servicoAerovia = servicoAerovia;
    }

    public Ocupacao cadastraOcupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia, Aeronave aeronave) {
        if (!isSlotOcupacaoValido(slotHoraInicio, slotHoraFim)) {
            throw new NotAcceptableStatusException("Slot de hora deve estar no intervalo 0-23");
        };

        if (this.isAeroviaOcupada(aerovia.getNome(), aerovia.getAltitude(), data, slotHoraInicio, slotHoraFim)) {
            throw new NotAcceptableStatusException("Aerovia Ocupada");
        }

        if (this.isAeronaveOcupada(aeronave.getPrefixo(), data, slotHoraInicio, slotHoraFim)) {
            throw new NotAcceptableStatusException("Aeronave ocupada");
        }

        return this.repOcupacao.cadastraOcupacao(data, slotHoraInicio, slotHoraFim, aerovia, aeronave);
    }

    public boolean isAeroviaOcupada(String nomeAerovia, int altitude, Date data, Integer slotHoraInicio, Integer slotHoraFim) {
        Aerovia aerovia = this.servicoAerovia.busca(nomeAerovia, altitude);
        return this.repOcupacao.isAeroviaOcupada(aerovia, data, slotHoraInicio, slotHoraFim);
    }

    public boolean isAeronaveOcupada(String prefixAeronave, Date data, Integer slotHoraInicio, Integer slotHoraFim) {
        Aeronave aeronave = this.servicoAeronave.buscaPorPrefixo(prefixAeronave);
        return this.repOcupacao.isAeronaveOcupada(aeronave, data, slotHoraInicio, slotHoraFim);
    }

    public boolean isSlotOcupacaoValido(Integer slotHoraInicio, Integer slotHoraFim) {
        return  slotHoraInicio <= slotHoraFim && (slotHoraInicio >= 0 && slotHoraFim <= 23);
    }

    public boolean liberaOcupacao(Ocupacao ocupacao) {
        return this.repOcupacao.liberaOcupacao(ocupacao);
    }

}
