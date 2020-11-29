package com.edsonsuarez.servicessocios.service;

import com.edsonsuarez.SocioDto;

public interface SocioServ {
    public Object findAll();
    public Object findById(String id);
    public Object insert(SocioDto s);
    public Object update(SocioDto s , String id);
    public String delete(String id);
}
