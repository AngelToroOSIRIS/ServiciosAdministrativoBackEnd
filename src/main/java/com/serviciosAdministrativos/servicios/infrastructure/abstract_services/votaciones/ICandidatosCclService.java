package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosEntity;

import java.util.ArrayList;

public interface ICandidatosCclService {
    ArrayList<CandidatosEntity>buscarCandidatosCcl(Integer idcrp);
}
