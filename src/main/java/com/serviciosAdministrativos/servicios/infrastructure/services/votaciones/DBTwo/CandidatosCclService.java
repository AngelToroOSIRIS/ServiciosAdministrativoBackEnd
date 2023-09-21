package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.CandidatosCclRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCclService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CandidatosCclService implements ICandidatosCclService {
    private final CandidatosCclRepository candidatosCclRepository;

    public CandidatosCclService(CandidatosCclRepository candidatosCclRepository) {
        this.candidatosCclRepository = candidatosCclRepository;
    }

    public ArrayList<CandidatosEntity>buscarCandidatosCcl(Integer idcrp){
        ArrayList<CandidatosEntity>buscarCandidatosCcl = candidatosCclRepository.findByIdcrp(idcrp);
        if (!buscarCandidatosCcl.isEmpty()){
            return  buscarCandidatosCcl;
        }else {
            throw new RuntimeException("No se encontraron votaciones con ese código");
        }
    }
}
