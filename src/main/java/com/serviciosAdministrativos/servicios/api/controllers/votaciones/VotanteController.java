package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotanteService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/infovotante")

public class VotanteController {
    private final IVotanteService iVotanteService;

    public VotanteController(IVotanteService iVotanteService) {
        this.iVotanteService = iVotanteService;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
            Map<String, String> result = new HashMap<>();
        result.put("estado_voto", iVotanteService.buscarVotaciones(email));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (IllegalArgumentException e) {
        return ValidationErrorHandler.handleValidation(e);
    }   catch (RuntimeException e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}

