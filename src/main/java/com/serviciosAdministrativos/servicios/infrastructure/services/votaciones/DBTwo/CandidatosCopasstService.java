package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosCopasstEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.CandidatosCopasstRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCopasstService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CandidatosCopasstService implements ICandidatosCopasstService {
    private final CandidatosCopasstRepository candidatosCopasstRepository;

    public CandidatosCopasstService(CandidatosCopasstRepository candidatosCopasstRepository) {
        this.candidatosCopasstRepository = candidatosCopasstRepository;
    }

    public ArrayList<CandidatosCopasstEntity> buscarCandidatos(Integer idcrp){
        ArrayList<CandidatosCopasstEntity>buscarCandidatos = candidatosCopasstRepository.findAllByIdcrp(idcrp);
        if (!buscarCandidatos.isEmpty()){
            return buscarCandidatos;
        } else {
            throw new RuntimeException("No se encontraron votaciones con ese código");
        }
    }
}
