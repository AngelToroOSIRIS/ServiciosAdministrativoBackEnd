package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotanteService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class VotantesService implements IVotanteService {

    private  final VotanteRepository votanteRepository;
    private final PersonaActivaRepository personaActivaRepository;

    public VotantesService(VotanteRepository votanteRepository, PersonaActivaRepository personaActivaRepository) {
        this.votanteRepository = votanteRepository;
        this.personaActivaRepository = personaActivaRepository;
    }


    @Override
    public String buscarVotaciones(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);
        if (personaActivaFind.isPresent()) {
            Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(personaActivaFind.get().getNroDocumento());
            if(votanteFind.isPresent()) return votanteFind.get().getCopasst().toString();
            throw new RuntimeException("No existe en votante");
        } else {
              return email;
        }
    }

}
