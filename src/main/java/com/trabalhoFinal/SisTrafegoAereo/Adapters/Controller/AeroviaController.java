package com.trabalhoFinal.SisTrafegoAereo.Adapters.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.ConsultaSlotsDTO;
import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.ListaAerovias_UC;
import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.ListaSlotsLivres_UC;
import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.SlotLivreDTO;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Aerovia;

@RestController
@RequestMapping("/scta")
public class AeroviaController {
    private ListaAerovias_UC listaAerovias_UC;
    private ListaSlotsLivres_UC listaSlotsLivres_UC;

    public AeroviaController(ListaAerovias_UC listaAerovias_UC, ListaSlotsLivres_UC listaSlotsLivres_UC) {
        this.listaAerovias_UC = listaAerovias_UC;
        this.listaSlotsLivres_UC = listaSlotsLivres_UC;
    }

    @GetMapping("/rotas/{origem}/{destino}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Aerovia>> listaAerovias(
            @PathVariable("origem") String codIataOrigem,
            @PathVariable("destino") String codIataDestinom) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.listaAerovias_UC.run(codIataOrigem, codIataDestinom));
    }

    @PostMapping("/slotslivres")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<SlotLivreDTO>> listaSlotsLivres(@RequestBody final ConsultaSlotsDTO req) {
        Integer slotHora = req.horario().getHour();

        System.out.println(slotHora);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.listaSlotsLivres_UC.run(req.rota(), req.data(), slotHora));
    }

}
