package com.trabalhoFinal.SisTrafegoAereo.Aplicacao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos.ServicoAerovia;

@Component
public class ListaAerovias_UC {
    private ServicoAerovia servicoAerovia;
    private ServicoAeroporto servicoAeroporto;

    public ListaAerovias_UC(ServicoAerovia servicoAerovia, ServicoAeroporto servicoAeroporto) {
        this.servicoAerovia = servicoAerovia;
        this.servicoAeroporto = servicoAeroporto;
    }

    public List<Aerovia> run(String codIataOrigem, String codIataDestino) {
        Aeroporto origem = this.servicoAeroporto.getAeroporto(codIataOrigem);
        Aeroporto destino = this.servicoAeroporto.getAeroporto(codIataDestino);

        System.out.println(origem);

        return this.servicoAerovia.listaAerovias(origem, destino);
    }

}
