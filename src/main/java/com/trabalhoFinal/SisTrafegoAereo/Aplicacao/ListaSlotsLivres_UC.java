package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAerovia;

@Component
public class ListaSlotsLivres_UC {
    private ServicoAerovia servicoAerovia;

    public ListaSlotsLivres_UC(ServicoAerovia servicoAerovia) {
        this.servicoAerovia = servicoAerovia;
    }

    public List<SlotLivreDTO> run(String nomeAerovia, Date data, Integer slotHora) {
        List<Integer> altitudesLivres = this.servicoAerovia.getAltitudesLivres(nomeAerovia, data, slotHora);

        return altitudesLivres.stream().map((al) -> new SlotLivreDTO(al, slotHora)).toList();
    }

}
