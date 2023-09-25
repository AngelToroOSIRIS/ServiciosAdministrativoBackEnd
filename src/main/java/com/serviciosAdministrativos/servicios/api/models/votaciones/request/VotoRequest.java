package com.serviciosAdministrativos.servicios.api.models.votaciones.request;

import java.util.ArrayList;

public class VotoRequest {
    private Integer idcrp;
    private ArrayList<Integer> candidatos;
    private String periodo;

    public ArrayList<Integer> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Integer> candidatos) {
        this.candidatos = candidatos;
    }

    public Integer getIdcrp() {
        return idcrp;
    }

    public void setIdcrp(Integer idcrp) {
        this.idcrp = idcrp;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}

