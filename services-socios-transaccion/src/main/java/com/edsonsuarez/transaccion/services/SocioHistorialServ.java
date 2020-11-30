package com.edsonsuarez.transaccion.services;

import com.edsonsuarez.SocioHistorialDto;

public interface SocioHistorialServ {
    boolean buscarSocio(String dni);
    SocioHistorialDto registrar(SocioHistorialDto dto,String dni);
}
