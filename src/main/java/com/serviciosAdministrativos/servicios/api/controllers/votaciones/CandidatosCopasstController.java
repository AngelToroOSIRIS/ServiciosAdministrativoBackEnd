package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCopasstService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/candidatos")

public class CandidatosCopasstController {

    private final ICandidatosCopasstService iCandidatosCopasstService;

    public CandidatosCopasstController(ICandidatosCopasstService iCandidatosCopasstService) {
        this.iCandidatosCopasstService = iCandidatosCopasstService;
    }

    @GetMapping
    public ResponseEntity<?> get(){
        try {
            return ResponseEntity.ok(iCandidatosCopasstService.buscarCandidatos(120));
        } catch (IllegalArgumentException e){
            return ValidationErrorHandler.handleValidation(e);
        }catch (RuntimeException e){
            return ValidationErrorHandler.handleException(e);
        }
    }
}
