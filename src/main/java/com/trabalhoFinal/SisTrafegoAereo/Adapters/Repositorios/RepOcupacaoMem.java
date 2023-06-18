package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepOcupacao;

@Repository
public class RepOcupacaoMem implements IRepOcupacao {
    List<Ocupacao> ocupacoes = new LinkedList<>();

    @Override
    public Ocupacao cadastraOcupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia,
            Aeronave aeronave) {
        Ocupacao oc = new Ocupacao(data, slotHoraInicio, slotHoraFim, aerovia, aeronave);

        ocupacoes.add(oc);

        return oc;
    }

    @Override
    public boolean isAeronaveOcupada(String prefixAeronave, Date data, Integer slotHoraInicio, Integer slotHoraFim) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        return this.ocupacoes.stream()
        .filter((oc) -> oc.getAeronave().getPrefixo().equals(prefixAeronave))
        .filter((oc) -> fmt.format(oc.getData()).equals(fmt.format(data)))
        .filter((oc) -> slotHoraInicio >= oc.getSlotHoraInicio() && slotHoraInicio <= oc.getSlotHoraFim() || slotHoraFim >= oc.getSlotHoraInicio() && slotHoraFim <= oc.getSlotHoraFim())
        .findAny()
        .isPresent();
    }

    @Override
    public boolean isAeroviaOcupada(String nomeAerovia, Date data, Integer slotHoraInicio, Integer slotHoraFim) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        return this.ocupacoes.stream()
        .filter((oc) -> oc.getAerovia().getNome().equals(nomeAerovia))
        .filter((oc) -> fmt.format(oc.getData()).equals(fmt.format(data)))
        .filter((oc) -> slotHoraInicio >= oc.getSlotHoraInicio() && slotHoraInicio <= oc.getSlotHoraFim() || slotHoraFim >= oc.getSlotHoraInicio() && slotHoraFim <= oc.getSlotHoraFim())
        .findAny()
        .isPresent();
    }

}
