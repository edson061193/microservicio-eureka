package com.edsonsuarez.apirestmongodb.controller;


import com.edsonsuarez.SocioDto;
import com.edsonsuarez.apirestmongodb.model.Socio;
import com.edsonsuarez.apirestmongodb.repository.SocioRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class SocioController {

    @Autowired
    SocioRepository socioRepository;

    @GetMapping("/listar")
    public List<Socio> getSocios(){
        List<Socio> socioList = socioRepository.findAll();
        return socioList;
    }

    @GetMapping("/listar/{id}")
    public Object getSocio(@PathVariable String id){
        Optional<Socio> emp = socioRepository.findById(id);
        return  emp.get();
    }

    @PutMapping("/modificar/{id}")
    public Object updateSocio(@RequestBody SocioDto newSocio, @PathVariable String id){
        Optional<Socio> optionalEmp = socioRepository.findById(id.toString());
        if (optionalEmp.isPresent()) {
            Socio socio = optionalEmp.get();
            socio.setAmaterno(newSocio.getAmaterno());
            socio.setApaterno(newSocio.getApaterno());
            socio.setNombres(newSocio.getNombres());
            socio.setTelefono(newSocio.getTelefono());
            socio.setCorreo(newSocio.getCorreo());
            socio.setMenbresia(newSocio.getMenbresia());
            socio.setEstado(newSocio.getEstado());
            socioRepository.save(socio);
        }
        return optionalEmp.get();
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = "application/json; charset=utf-8")
    public String deleteSocio(@PathVariable String id) {
        Boolean result = socioRepository.existsById(id);
        socioRepository.deleteById(id);
        return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
    }

    @PostMapping("/registrar")
    public Object addSocio(@RequestBody SocioDto socio){
        String id = String.valueOf(new Random().nextInt() & Integer.MAX_VALUE);
        Socio newSocio = new Socio();
        newSocio.setId(id);
        newSocio.setNombres(socio.getNombres());
        newSocio.setEstado(socio.getEstado());
        newSocio.setMenbresia(socio.getMenbresia());
        newSocio.setCorreo(socio.getCorreo());
        newSocio.setTelefono(socio.getTelefono());
        newSocio.setDni(socio.getDni());
        newSocio.setApaterno(socio.getApaterno());
        newSocio.setAmaterno(socio.getAmaterno());
        socioRepository.insert(newSocio);
        return newSocio;
    }
}
