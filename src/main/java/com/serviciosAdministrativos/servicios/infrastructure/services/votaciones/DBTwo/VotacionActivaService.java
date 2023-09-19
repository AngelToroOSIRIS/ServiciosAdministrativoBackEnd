package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotacionActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionActivaService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VotacionActivaService implements IVotacionActivaService {
    private final VotacionActivaRepository votacionActivaRepository;
    private final VotanteRepository votanteRepository;
    private final PersonaActivaRepository personaActivaRepository;

    public VotacionActivaService(VotanteRepository votanteRepository, VotacionActivaRepository votacionActivaRepository, PersonaActivaRepository personaActivaRepository) {
        this.votacionActivaRepository = votacionActivaRepository;
        this.personaActivaRepository = personaActivaRepository;
        this.votanteRepository = votanteRepository;
    }

    public ArrayList<VotacionActivaEntity> buscarVotaciones(Integer estado, String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);
        if (personaActivaFind.isPresent()) {
            Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(personaActivaFind.get().getNroDocumento());
            if (votanteFind.isPresent()) {
                ArrayList<VotacionActivaEntity> votacionesActivas = votacionActivaRepository.findAllByEstado(estado);
                if (!votacionesActivas.isEmpty()) {
                    ArrayList votacionesPersona = new ArrayList<>();
                    for (VotacionActivaEntity votacion : votacionesActivas){
                         Map<String, String> nuevaVotacion = new HashMap<>();
                        nuevaVotacion.put("id", votacion.getId().toString());
                        nuevaVotacion.put("nombre", votacion.getNombre());
                        if (votacion.getId() == 1) {
                           nuevaVotacion.put("estado_voto", votanteFind.get().getCopasst().toString());
                        }if (votacion.getId() == 3) {
                            nuevaVotacion.put("estado_voto", votanteFind.get().getCcl().toString());
                        }else {
                            nuevaVotacion.put("estado_voto", "0");
                        }
                        votacionesPersona.add(nuevaVotacion);
                    }
                    return votacionesPersona;
                } else {
                    throw new RuntimeException("No se han encontrado Votaciones");
                }
            }

            throw new RuntimeException("No existe en votante");
        } else {
            throw new RuntimeException("email no encontrado");
        }

    }

}