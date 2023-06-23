package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import org.springframework.stereotype.Component;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoOcupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoViagem;
import com.trabalhoFinal.SisTrafegoAereo.Utils.Errors.NaoEncontrado;

@Component
public class CancelaViagem_UC {
    private ServicoViagem servicoViagem;
    private ServicoOcupacao servicoOcupacao;

    public CancelaViagem_UC(ServicoViagem servicoViagem, ServicoOcupacao servicoOcupacao) {
        this.servicoViagem = servicoViagem;
        this.servicoOcupacao = servicoOcupacao;
    }

    public boolean run(Long idViagem) throws NaoEncontrado {
        Viagem viagem = this.servicoViagem.getViagem(idViagem);

        if (viagem == null) {
            throw new NaoEncontrado("Voo não encontrado");
        }

        this.servicoOcupacao.liberaOcupacao(viagem.getOcupacao());

        return this.servicoViagem.removeViagem(idViagem);
    }

}
