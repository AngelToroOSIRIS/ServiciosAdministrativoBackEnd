package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICopasstService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CopasstService implements ICopasstService {

    private final VotanteRepository votanteRepository;
    private final PersonaActivaRepository personaActivaRepository;


    public CopasstService(VotanteRepository votanteRepository, PersonaActivaRepository personaActivaRepository) {
        this.personaActivaRepository = personaActivaRepository;
        this.votanteRepository = votanteRepository;
    }

    public Map <String, String> verificarEstadoVoto(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);
        if (personaActivaFind.isPresent()) {
            Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(personaActivaFind.get().getNroDocumento());
            if (votanteFind.isPresent()) {
                Map<String, String> estado = new HashMap<>();
                estado.put("estado", votanteFind.get().getCopasst().toString());
                return estado;
            } else {
                throw new RuntimeException("No se han encontrado Votaciones");
            }
        } else {
            throw new RuntimeException("Email no encontrado");
        }
    }
}