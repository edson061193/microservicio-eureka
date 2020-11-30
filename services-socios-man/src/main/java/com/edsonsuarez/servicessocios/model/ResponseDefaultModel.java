package com.edsonsuarez.servicessocios.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDefaultModel {
    private String mensaje;
    private String codigo;
    private Object body;
}
