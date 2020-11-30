package com.edsonsuarez.apirestmysql.maper;

import com.edsonsuarez.SocioHistorialDto;
import com.edsonsuarez.apirestmysql.entity.SocioHistorialEntity;
import org.modelmapper.ModelMapper;

public class SocioHistorialMapper {

    private ModelMapper mapper = new ModelMapper();

    public SocioHistorialEntity map(SocioHistorialDto model) {
        return mapper.map(model,SocioHistorialEntity.class);
    }

    public SocioHistorialDto map(SocioHistorialEntity entity) {
        return mapper.map(entity, SocioHistorialDto.class);
    }
}
