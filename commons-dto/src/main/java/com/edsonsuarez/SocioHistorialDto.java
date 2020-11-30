package com.edsonsuarez;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SocioHistorialDto {

    private Long idhistorial;
    private LocalDateTime fechaupdate;
    private String nuevoEstado;
    private String socioId;

}
