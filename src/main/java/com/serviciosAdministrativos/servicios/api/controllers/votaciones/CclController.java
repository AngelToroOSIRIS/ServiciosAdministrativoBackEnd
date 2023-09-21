package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCclService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICclService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ccl")

public class CclController {

    private final ICclService iCclService;
    private final ICandidatosCclService iCandidatosCclService;

    public CclController(ICclService iCclService, ICandidatosCclService iCandidatosCclService) {
        this.iCclService = iCclService;
        this.iCandidatosCclService = iCandidatosCclService;
    }


}
