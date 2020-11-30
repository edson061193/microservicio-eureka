package com.edsonsuarez.apirestmysql.controller;

import com.edsonsuarez.SocioHistorialDto;
import com.edsonsuarez.apirestmysql.services.SocioHistorialServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocioHistorialController {

    @Autowired
    private SocioHistorialServ socioHistorialServ;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }

    @PostMapping("/registrohistorial")
    public SocioHistorialDto registroHistorial(@RequestBody SocioHistorialDto model){
        return socioHistorialServ.registroHistorial(model);
    }
}
