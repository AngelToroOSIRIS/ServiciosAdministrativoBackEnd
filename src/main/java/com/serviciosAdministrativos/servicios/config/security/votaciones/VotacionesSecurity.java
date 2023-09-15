package com.serviciosAdministrativos.servicios.config.security.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionesSecurity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotacionesSecurity implements IVotacionesSecurity {
    private final PersonaActivaRepository personaActivaRepository;

    public VotacionesSecurity(PersonaActivaRepository personaActivaRepository) {
        this.personaActivaRepository = personaActivaRepository;
    }

    public Boolean userAuthorized(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository
                .findByEmail(email);

        if (personaActivaFind.isPresent()) {
            return true;
        } else {
            throw new IllegalArgumentException("No tienes permisos para continuar");
        }
    }
}
