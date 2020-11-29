package com.edsonsuarez.servicessocios.cliente;

import com.edsonsuarez.SocioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mantenimientosocios")
public interface ManSocioCliente {

    @GetMapping("/listar")
    public Object listar();

    @GetMapping("/listar/{id}")
    public Object obtenerSocioId(@PathVariable String id);

    @PostMapping("/registrar")
    public Object nuevoRegistro(@RequestBody SocioDto socio);

    @PutMapping("/modificar/{id}")
    public Object modificarRegistro(@RequestBody SocioDto socio, @PathVariable String id);

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id);
}
