package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionActivaEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotacionActivaRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionActivaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VotacionActivaService implements IVotacionActivaService {
    private final VotacionActivaRepository votacionActivaRepository;

    public VotacionActivaService(VotacionActivaRepository votacionActivaRepository) {
        this.votacionActivaRepository =  votacionActivaRepository;
    }

    public ArrayList<VotacionActivaEntity> buscarVotaciones(Integer estado) {
        ArrayList<VotacionActivaEntity>votacionesActivas = votacionActivaRepository.findAllByEstado(estado);
        if (!votacionesActivas.isEmpty()){
            return votacionesActivas;
        } else {
            throw new RuntimeException("No se han encontrado Votaciones");
        }
    }

}