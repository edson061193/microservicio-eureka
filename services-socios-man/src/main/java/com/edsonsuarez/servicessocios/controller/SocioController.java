package com.edsonsuarez.servicessocios.controller;

import com.edsonsuarez.SocioDto;
import com.edsonsuarez.servicessocios.model.ResponseDefaultModel;
import com.edsonsuarez.servicessocios.service.impl.SocioFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocioController {

    private static Logger log = LoggerFactory.getLogger(SocioController.class);

    @Autowired
    @Qualifier("socioServiceFeign")
    private SocioFeign socioFeign;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativoListSocio")
    @GetMapping("/listar")
    public Object listarTodo(){
        return socioFeign.findAll();
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativoListIDSocio")
    @GetMapping(value = "/listar/{id}" , produces = "application/json; charset=utf-8")
    public Object obtenerSocioId(@PathVariable String id){
        return socioFeign.findById(id);
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativoNuevoRegistro")
    @PostMapping(value = "/registrar", produces = "application/json; charset=utf-8")
    public Object nuevoRegistro(@RequestBody SocioDto newSocio){
        return socioFeign.insert(newSocio);
    }

    @PutMapping(value = "/modificar/{id}" , produces = "application/json; charset=utf-8")
    public Object modificarRegistro(@RequestBody SocioDto newSocio, @PathVariable(value = "id") String id){
        return socioFeign.update(newSocio,id);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = "application/json; charset=utf-8")
    public String eliminar(@PathVariable String id) {
        return socioFeign.delete(id);
    }



    public Object metodoAlternativoListIDSocio(String id){
        ResponseDefaultModel responseDefault = new ResponseDefaultModel();
        responseDefault.setCodigo("503");
        responseDefault.setMensaje("Buscando...");
        responseDefault.setBody(id);
        return responseDefault;
    }

    public Object metodoAlternativoListSocio(){
        ResponseDefaultModel responseDefault = new ResponseDefaultModel();
        responseDefault.setCodigo("502");
        responseDefault.setMensaje("Estamos en mantenimiento,Intente más tarde");
        responseDefault.setBody(null);
        return responseDefault;
    }

    public Object metodoAlternativoNuevoRegistro(SocioDto newSocio){
        ResponseDefaultModel responseDefault = new ResponseDefaultModel();
        responseDefault.setCodigo("502");
        responseDefault.setMensaje("Por el momento no podemos hacer transsaciones, Intente más tarde");
        responseDefault.setBody(newSocio);
        return responseDefault;
    }
}
