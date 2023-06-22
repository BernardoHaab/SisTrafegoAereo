package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeroporto;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepAerovia;

@Repository
@Primary
public class RepAeroviaJPA implements IRepAerovia {
    private IRepAeroviaCRUD aeroviaCRUD;

    @Autowired
    public RepAeroviaJPA(IRepAeroviaCRUD aeroviaCRUD) {
        this.aeroviaCRUD = aeroviaCRUD;
    }

    @Override
    public Aerovia busca(String nome, int altitude) {
        return this.aeroviaCRUD.listByNomeAndAltitude(nome, altitude);
    }

    @Override
    public boolean existeAerovia(String nome, int altitude) {
        return this.aeroviaCRUD.listByNomeAndAltitude(nome, altitude) != null;
    }

    @Override
    public List<Aerovia> listaAerovias(Aeroporto origem, Aeroporto destino) {
        return this.aeroviaCRUD.findByOrigemAndDestino(origem, destino);
    }

    @Override
    public List<Integer> getAltitudesLivres(String nomeAerovia, Date data, Integer slotHora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAltitudesLivres'");
    }

}
