package com.serviciosAdministrativos.servicios.domain.entities.DBTwo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "cuerpocol")
public class VotacionActivaEntity {

    @Id
    private Integer id;
    private static Integer idcrp;
    private String nombre;

    private Integer tprep;
    private Integer estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getIdcrp() {
        return idcrp;
    }

    public void setIdcrp(Integer idcrp) {
        this.idcrp = idcrp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTprep() {
        return tprep;
    }

    public void setTprep(Integer tprep) {
        this.tprep = tprep;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}