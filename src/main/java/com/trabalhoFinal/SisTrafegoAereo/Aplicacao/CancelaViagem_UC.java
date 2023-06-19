package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import org.springframework.stereotype.Component;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoOcupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoViagem;

@Component
public class CancelaViagem_UC {
    private ServicoViagem servicoViagem;
    private ServicoOcupacao servicoOcupacao;

    public CancelaViagem_UC(ServicoViagem servicoViagem, ServicoOcupacao servicoOcupacao) {
        this.servicoViagem = servicoViagem;
        this.servicoOcupacao = servicoOcupacao;
    }

    public boolean run(Long idViagem) {
        Viagem viagem = this.servicoViagem.getViagem(idViagem);

        System.out.println(viagem);
        this.servicoOcupacao.liberaOcupacao(viagem.getOcupacao());

        return this.servicoViagem.removeViagem(idViagem);
    }

}
