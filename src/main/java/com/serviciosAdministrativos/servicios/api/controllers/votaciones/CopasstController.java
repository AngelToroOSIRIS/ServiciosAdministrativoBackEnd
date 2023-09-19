package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICopasstService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/copasst")

public class CopasstController {

    private final ICopasstService iCopasstService;

    public CopasstController(ICopasstService iCopasstService) {
        this.iCopasstService = iCopasstService;
    }

    @GetMapping("/estado_voto")
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
        return ResponseEntity.ok(iCopasstService.verificarEstadoVoto(email));
    } catch (IllegalArgumentException e) {
            System.out.println(e);
        return ValidationErrorHandler.handleValidation(e);
    }   catch (RuntimeException e) {
            System.out.println(e);
            return ValidationErrorHandler.handleException(e);
        }
    }

}