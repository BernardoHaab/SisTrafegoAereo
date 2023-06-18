package com.trabalhoFinal.SisTrafegoAereo.Dominio.Servicos;

import org.springframework.stereotype.Service;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.PequenoPorte;

@Service
public class ServicoAeronave {

    // @ToDo: Implementar busca por prefixo
    public Aeronave buscaPorPrefixo(String prefixo) {
        return new PequenoPorte(prefixo, 100, 1000, "Jorge");
    }
}
