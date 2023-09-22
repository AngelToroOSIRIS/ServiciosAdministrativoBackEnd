package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionesEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
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

    @Override
    public Map<String, String> votacionesRequest(String email) {
        return null;
    }

    @Override
    public VotacionesEntity save(VotoRequest votoRequest) throws Exception {
        try {
            Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(votoRequest.getIdentificacion());
            if (votanteFind.isPresent()) {
                VotacionesEntity saveVotaciones = new VotacionesEntity();
                saveVotaciones.setIdcrp(votoRequest.getIdcrp());
                saveVotaciones.setFecha(LocalDateTime.now());
                saveVotaciones.setNroton(votoRequest.getNroton());
                votacionesRepository.save(saveVotaciones);
            }
            if (((votanteFind.get().getCcl() == null && votanteFind.get().getCcl() == 0 && votoRequest.getIdcrp() == 121))) {
                votanteFind.get().setCcl(1);
                votanteFind.get().setFecha_ccl(LocalDate.now());
            } else if ((votanteFind.get().getCopasst() == null && votanteFind.get().getCopasst() == 0) && votoRequest.getIdcrp() == 120) {
                votanteFind.get().setCopasst(1);
                votanteFind.get().setFecha_copasst(LocalDate.now());
            } else {
                return null;
            }
            throw new RuntimeException("No existe en votante");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}