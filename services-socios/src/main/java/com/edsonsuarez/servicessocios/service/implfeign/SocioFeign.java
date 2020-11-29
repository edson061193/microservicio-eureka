package com.edsonsuarez.servicessocios.service.implfeign;

import com.edsonsuarez.SocioDto;
import com.edsonsuarez.servicessocios.cliente.ManSocioCliente;
import com.edsonsuarez.servicessocios.controller.SocioController;
import com.edsonsuarez.servicessocios.service.SocioServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("socioServiceFeign")
public class SocioFeign implements SocioServ {

    private static Logger log = LoggerFactory.getLogger(SocioFeign.class);

    @Autowired
    private ManSocioCliente socioCliente;

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

}
