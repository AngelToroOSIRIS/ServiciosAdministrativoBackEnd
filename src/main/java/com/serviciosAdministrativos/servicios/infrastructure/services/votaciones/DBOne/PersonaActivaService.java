package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBOne;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IPersonaActivaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaActivaService implements IPersonaActivaService {
    private final PersonaActivaRepository personaActivaRepository;

    public PersonaActivaService(PersonaActivaRepository personaActivaRepository) {
        this.personaActivaRepository = personaActivaRepository;
    }

    @Override
    public Optional<PersonaActivaEntity> findByEmail(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);
        if (personaActivaFind.isPresent()) {
        return personaActivaFind;
    } else {
        throw new RuntimeException("Persona no encontrada");
    }
    }
}
