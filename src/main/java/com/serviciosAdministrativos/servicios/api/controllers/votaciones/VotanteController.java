package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotanteService;
import com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo.VotantesService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")

public class VotanteController {
    private final IVotanteService iVotanteService;

    public VotanteController(IVotanteService iVotanteService) {
        this.iVotanteService = iVotanteService;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
            Map<String, String> result = new HashMap<>();
        result.put("estado_Voto", iVotanteService.buscarVotaciones(email));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (IllegalArgumentException e) {
        return ValidationErrorHandler.handleValidation(e);
    }   catch (RuntimeException e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
public  ResponseEntity<?> put(@RequestBody Map<String, String> body) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        } catch (IllegalArgumentException e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (RuntimeException e) {
            return ValidationErrorHandler.handleException(e);
        }
    }


}

