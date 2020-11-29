package com.edsonsuarez.servicessocios.service.implrestemp;

import com.edsonsuarez.SocioDto;
import com.edsonsuarez.servicessocios.service.SocioServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SocioServImpl implements SocioServ {

    @Autowired
    private RestTemplate clienteRest;


    @Override
    public Object findAll() {
        return null;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object insert(SocioDto s) {
        return null;
    }

    @Override
    public Object update(SocioDto s, String id) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
