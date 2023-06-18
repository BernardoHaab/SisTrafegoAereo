package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

@Service
public class ServicoAerovia {

    public Aerovia buscaPorNome(String nome) {
        return new Aerovia(new Aeroporto("Porto Alegre", "POA"), new Aeroporto("São Paulo", "GRU"), 100, nome, 2500);
    }

}
