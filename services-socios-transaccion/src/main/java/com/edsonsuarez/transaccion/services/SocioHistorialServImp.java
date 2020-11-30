package com.edsonsuarez.transaccion.services;

import com.edsonsuarez.SocioHistorialDto;
import com.edsonsuarez.transaccion.AppRestTemplateConfig;
import com.edsonsuarez.transaccion.cliente.SocioTransMySQLClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SocioHistorialServ")
public class SocioHistorialServImp implements SocioHistorialServ {

    @Autowired
    private SocioTransMySQLClient socioTransMySQLClient;

    @Autowired
    private AppRestTemplateConfig restTemplate;

    @Override
    public boolean buscarSocio(String dni) {
        return restTemplate.restSociosmanRest().getForObject("http://services_socios/buscardni/"+dni, Boolean.class);
    }

    @Override
    public SocioHistorialDto registrar(SocioHistorialDto dto,String dni) {
        if(buscarSocio(dni)){
            return socioTransMySQLClient.registrar(dto);
        }else{
            return new SocioHistorialDto();
        }
    }
}
