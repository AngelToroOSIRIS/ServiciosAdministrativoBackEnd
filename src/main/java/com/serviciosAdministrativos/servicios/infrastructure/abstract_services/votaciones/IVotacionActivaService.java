package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionActivaEntity;

import java.util.ArrayList;

public interface IVotacionActivaService {
     ArrayList<VotacionActivaEntity> buscarVotaciones(Integer estado, String email);
}
