package com.edsonsuarez.apirestmysql.services.impl;

import com.edsonsuarez.SocioHistorialDto;
import com.edsonsuarez.apirestmysql.entity.SocioHistorialEntity;
import com.edsonsuarez.apirestmysql.maper.SocioHistorialMapper;
import com.edsonsuarez.apirestmysql.repository.SocioHistorialRepository;
import com.edsonsuarez.apirestmysql.services.SocioHistorialServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class SocioHistorialImpl implements SocioHistorialServ {

    @Autowired
    private SocioHistorialRepository socioHistorialRepository;

    private SocioHistorialMapper historialMapper= new SocioHistorialMapper();

    @Override
    public SocioHistorialDto registroHistorial(SocioHistorialDto model) {
        SocioHistorialEntity historialEntity = historialMapper.map(model);
        historialEntity.setFechaupdate(LocalDateTime.now(ZoneId.of("America/Lima")));
        socioHistorialRepository.save(historialEntity);
        return historialMapper.map(historialEntity);
    }

}
