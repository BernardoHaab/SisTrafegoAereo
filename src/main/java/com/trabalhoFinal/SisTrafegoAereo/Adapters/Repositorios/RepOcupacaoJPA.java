package com.trabalhoFinal.SisTrafegoAereo.Adapters.Repositorios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aeronave;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Ocupacao;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Interfaces.IRepOcupacao;

@Repository
@Primary
public class RepOcupacaoJPA implements IRepOcupacao {
    private IRepOcupacaoCRUD ocupacaoCRUD;

    @Autowired
    public RepOcupacaoJPA(IRepOcupacaoCRUD ocupacaoCRUD) {
        this.ocupacaoCRUD = ocupacaoCRUD;
    }

    @Override
    public Ocupacao cadastraOcupacao(Date data, Integer slotHoraInicio, Integer slotHoraFim, Aerovia aerovia,
            Aeronave aeronave) {
        return this.ocupacaoCRUD.save(new Ocupacao(data, slotHoraInicio, slotHoraFim, aerovia, aeronave));

    }

    @Override
    public boolean isAeronaveOcupada(Aeronave aeronave, Date data, Integer slotHoraInicio, Integer slotHoraFim) {
        return this.ocupacaoCRUD.existsByAeronaveAndDataAndSlotHoraInicioAndSlotHoraFim(aeronave, data, slotHoraInicio, slotHoraFim);
    }

    @Override
    public boolean isAeroviaOcupada(Aerovia aerovia, Date data, Integer slotHoraInicio, Integer slotHoraFim) {
        return this.ocupacaoCRUD.existsByAeroviaAndDataAndSlotHoraInicioAndSlotHoraFim(aerovia, data, slotHoraInicio, slotHoraFim);
    }

    @Override
    public boolean liberaOcupacao(Ocupacao ocupacao) {
        this.ocupacaoCRUD.delete(ocupacao);
        return true;
    }

}
