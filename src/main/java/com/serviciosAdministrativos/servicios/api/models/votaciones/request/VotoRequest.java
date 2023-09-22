package com.serviciosAdministrativos.servicios.api.models.votaciones.request;

import java.time.LocalDateTime;

public class VotoRequest {
    private Integer id;
    private Integer idcrp;
    private Integer nroton;
    private String identificacion;
    private String fecha;

    public Integer getNroton() {
        return nroton;
    }

    public void setNroton(Integer nroton) {
        this.nroton = nroton;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcrp() {
        return idcrp;
    }

    public void setIdcrp(Integer idcrp) {
        this.idcrp = idcrp;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
