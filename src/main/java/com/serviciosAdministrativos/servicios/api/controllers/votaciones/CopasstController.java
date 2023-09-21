package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCopasstService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICopasstService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/copasst")

public class CopasstController {

    private final ICopasstService iCopasstService;
     private final ICandidatosCopasstService iCandidatosCopasstService;

    public CopasstController(ICopasstService iCopasstService, ICandidatosCopasstService iCandidatosCopasstService) {
        this.iCopasstService = iCopasstService;
        this.iCandidatosCopasstService = iCandidatosCopasstService;
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

    @GetMapping("/candidatos")
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