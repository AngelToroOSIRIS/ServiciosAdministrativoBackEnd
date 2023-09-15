package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;

import java.util.Optional;

public interface IPersonaActivaService {
    Optional<PersonaActivaEntity> findByEmail(String email);
}
