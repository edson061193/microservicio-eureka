package com.edsonsuarez.servicessocios.cliente;

import com.edsonsuarez.SocioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mantenimientosocios")
public interface ManSocioClienteMongoDb {

    @GetMapping("/listar")
    Object listar();

    @GetMapping("/listar/{id}")
    Object obtenerSocioId(@PathVariable String id);

    @PostMapping("/registrar")
    Object nuevoRegistro(@RequestBody SocioDto socio);

    @PutMapping("/modificar/{id}")
    Object modificarRegistro(@RequestBody SocioDto socio, @PathVariable String id);

    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable String id);

    @GetMapping("/buscar-dni/{dni}")
    boolean buscarSocio(@PathVariable String dni);
}
