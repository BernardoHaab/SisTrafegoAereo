package com.trabalhoFinal.SisTrafegoAereo.Adapters.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.CadastraViagem_UC;
import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.ValidaViagem_UC;
import com.trabalhoFinal.SisTrafegoAereo.Aplicacao.ViagemDTO;
import com.trabalhoFinal.SisTrafegoAereo.Dominio.Entidades.Viagem;

@RestController
@RequestMapping("/scta")
public class ViagemController {
    private CadastraViagem_UC cadastraViagem_UC;
    private ValidaViagem_UC validaViagem_UC;

    @Autowired
    public ViagemController(CadastraViagem_UC cadastraViagem_UC, ValidaViagem_UC validaViagem_UC) {
        this.cadastraViagem_UC = cadastraViagem_UC;
        this.validaViagem_UC = validaViagem_UC;
    }

    @PostMapping("/aprovaPlanoDeVoo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Viagem> cadastraViagem(@RequestBody final ViagemDTO cadastraViagemDTO) {
        Viagem v = cadastraViagem_UC.run(cadastraViagemDTO);
        return ResponseEntity.status(HttpStatus.OK).body(v);
    }

    @PostMapping("/avaliaPlanoDeVoo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> validaViagem(@RequestBody final ViagemDTO cadastraViagemDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(validaViagem_UC.run(cadastraViagemDTO));
    }
}
