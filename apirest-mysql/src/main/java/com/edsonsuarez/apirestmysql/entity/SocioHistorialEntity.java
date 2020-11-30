package com.edsonsuarez.apirestmysql.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.*;

@Entity
@Table(name = "TBL_HISTORIAL_ESTADO")
public class SocioHistorialEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idhistorial;

    @Column(name = "fechaupdate")
    private LocalDateTime fechaupdate;

    @Column(name = "estado")
    private String nuevoEstado;

    @Column(name = "idsocio")
    private String socioId;

    public SocioHistorialEntity() {
    }

    public SocioHistorialEntity(Long idhistorial, LocalDateTime fechaupdate, String nuevoEstado, String socioId) {
        this.idhistorial = idhistorial;
        this.fechaupdate = fechaupdate;
        this.nuevoEstado = nuevoEstado;
        this.socioId = socioId;
    }

    public LocalDateTime getFechaupdate() {
        return LocalDateTime.now(ZoneId.of("America/Lima"));
    }

    public void setFechaupdate(LocalDateTime fechaupdate) {
        this.fechaupdate = LocalDateTime.now(ZoneId.of("America/Lima"));
    }

    public Long getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(Long idhistorial) {
        this.idhistorial = idhistorial;
    }


    public String getNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(String nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    public String getSocioId() {
        return socioId;
    }

    public void setSocioId(String socioId) {
        this.socioId = socioId;
    }
}
