package com.edsonsuarez.apirestmongodb.controller;

import com.edsonsuarez.apirestmongodb.model.Socio;
import com.edsonsuarez.apirestmongodb.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class SocioController {
    @Autowired
    SocioRepository socioRepository;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }

    @GetMapping("/socios")
    public List<Socio> getSocios(){
        List<Socio> socioList = socioRepository.findAll();
        return socioList;
    }

    @GetMapping("/socio/{id}")
    public Optional<Socio> getSocio(@PathVariable String id){
        Optional<Socio> emp = socioRepository.findById(id);
        return emp;
    }

    @PutMapping("/socio/{id}")
    public Optional<Socio> updateSocio(@RequestBody Socio newSocio, @PathVariable String id){
        Optional<Socio> optionalEmp = socioRepository.findById(id);
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
        return optionalEmp;
    }

    @DeleteMapping(value = "/socio/{id}", produces = "application/json; charset=utf-8")
    public String deleteSocio(@PathVariable String id) {
        Boolean result = socioRepository.existsById(id);
        socioRepository.deleteById(id);
        return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
    }

    @PostMapping("/socio")
    public Socio addSocio(@RequestBody Socio newSocio){
        String id = String.valueOf(new Random().nextInt() & Integer.MAX_VALUE);
        newSocio.setId(id);
        socioRepository.insert(newSocio);
        return newSocio;
    }
}
