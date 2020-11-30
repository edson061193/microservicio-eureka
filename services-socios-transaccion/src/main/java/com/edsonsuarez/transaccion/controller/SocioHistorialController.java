package com.edsonsuarez.transaccion.controller;

import com.edsonsuarez.SocioHistorialDto;
import com.edsonsuarez.transaccion.services.SocioHistorialServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocioHistorialController {

    @Autowired
    @Qualifier("SocioHistorialServ")
    private SocioHistorialServImp registroHistorial;

    @PostMapping("/registrohistorial/{dni}")
    public SocioHistorialDto registroHistorial(@RequestBody SocioHistorialDto model, @PathVariable String dni){
        return registroHistorial.registrar(model,dni);
    }
}
