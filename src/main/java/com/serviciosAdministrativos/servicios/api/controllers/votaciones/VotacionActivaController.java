package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionActivaService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vot_act")

public class VotacionActivaController {

    private final IVotacionActivaService iVotacionActivaService;

    public VotacionActivaController(IVotacionActivaService iVotacionActivaService) {
        this.iVotacionActivaService = iVotacionActivaService;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam Integer estado, @RequestParam String email) {
        try {
        return ResponseEntity.ok(iVotacionActivaService.buscarVotaciones(estado, email));
    } catch (IllegalArgumentException e) {
            System.out.println(e);
        return ValidationErrorHandler.handleValidation(e);
    }   catch (RuntimeException e) {
            System.out.println(e);
            return ValidationErrorHandler.handleException(e);
        }
    }

}