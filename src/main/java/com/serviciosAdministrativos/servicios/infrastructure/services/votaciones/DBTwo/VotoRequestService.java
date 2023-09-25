package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionesEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotacionesRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotoRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class VotoRequestService implements IVotoRequestService {

    @Autowired
    private VotanteRepository votanteRepository;
    @Autowired
    private VotacionesRepository votacionesRepository;
    @Autowired
    private PersonaActivaRepository personaActivaRepository;

    @Override
    public Map<String, String> votacionesRequest(String email) {
        return null;
    }

    @Override
    public VotacionesEntity save(VotoRequest votoRequest, String email) {
        Optional<PersonaActivaEntity> votanteFindEmail = personaActivaRepository.findByEmail(email);
        if (votanteFindEmail.isPresent()) {
            Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(votanteFindEmail.get().getNroDocumento());
            if (votanteFind.isPresent()) {
                for (Integer nroton : votoRequest.getCandidatos()) {
                    VotacionesEntity saveVotaciones = new VotacionesEntity();
                    saveVotaciones.setIdcrp(votoRequest.getIdcrp());
                    saveVotaciones.setPeriodo(votoRequest.getPeriodo());
                    saveVotaciones.setFecha(LocalDateTime.now());
                    saveVotaciones.setNroton(nroton);
                    votacionesRepository.saveAndFlush(saveVotaciones);
                    if (((votanteFind.get().getCcl() != null && votanteFind.get().getCcl() == 0 && votoRequest.getIdcrp() == 121))) {
                        votanteFind.get().setCcl(1);
                        votanteFind.get().setFecha_ccl(LocalDate.now());
                    } else if ((votanteFind.get().getCopasst() != null && votanteFind.get().getCopasst() == 0) && votoRequest.getIdcrp() == 120) {
                        votanteFind.get().setCopasst(1);
                        votanteFind.get().setFecha_copasst(LocalDate.now());

                    } else {
                        return null;
                    }
                    votanteRepository.saveAndFlush(votanteFind.get());
                }
            } else {
                throw new RuntimeException("No existe en votante");
            }

        } else {
            throw new RuntimeException("No existe en personas activas");
        }

        return null;
    }
}
