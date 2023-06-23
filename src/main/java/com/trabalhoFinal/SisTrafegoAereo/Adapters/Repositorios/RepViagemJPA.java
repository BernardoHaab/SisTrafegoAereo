package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepViagem;

@Repository
@Primary
public class RepViagemJPA implements IRepViagem {
    private IRepViagemCRUD viagemCRUD;

    public RepViagemJPA(IRepViagemCRUD viagemCRUD) {
        this.viagemCRUD = viagemCRUD;
    }

    @Override
    public Viagem cadastraViagem(Long idViagem, String nomePiloto, Ocupacao ocupacao) {
        return this.viagemCRUD.save(new Viagem(idViagem, nomePiloto, ocupacao));
    }

    @Override
    public boolean removeViagem(Long idViagem) {
        this.viagemCRUD.deleteById(idViagem);
        return true;
    }

    @Override
    public boolean existeViagem(Long idViagem) {
        return this.viagemCRUD.existsById(idViagem);
    }

    @Override
    public Viagem getViagem(Long idViagem) {
        return this.viagemCRUD.findById(idViagem).orElse(null);
    }

}
