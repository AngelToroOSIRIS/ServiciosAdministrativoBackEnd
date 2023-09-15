package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosCopasstEntity;

import java.util.ArrayList;

public interface ICandidatosCopasstService {
    ArrayList<CandidatosCopasstEntity> buscarCandidatos(Integer idcrp);
}
