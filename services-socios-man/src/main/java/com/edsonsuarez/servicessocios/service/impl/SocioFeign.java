package com.edsonsuarez.servicessocios.service.impl;

import com.edsonsuarez.SocioDto;
import com.edsonsuarez.servicessocios.cliente.ManSocioClienteMongoDb;
import com.edsonsuarez.servicessocios.service.SocioServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("socioServiceFeign")
public class SocioFeign implements SocioServ {

    private static Logger log = LoggerFactory.getLogger(SocioFeign.class);

    @Autowired
    private ManSocioClienteMongoDb socioCliente;

    @Override
    public Object findAll() {
        return socioCliente.listar();
    }

    @Override
    public Object findById(String id) {
        return  socioCliente.obtenerSocioId(id);
    }

    @Override
    public Object insert(SocioDto s) {
        return socioCliente.nuevoRegistro(s);
    }

    @Override
    public Object update(SocioDto s, String id) {
        return socioCliente.modificarRegistro(s,id);
    }

    @Override
    public String delete(String id) {
        return socioCliente.eliminar(id);
    }

    @Override
    public boolean buscarSocio(String dni) {
        return socioCliente.buscarSocio(dni);
    }

}
