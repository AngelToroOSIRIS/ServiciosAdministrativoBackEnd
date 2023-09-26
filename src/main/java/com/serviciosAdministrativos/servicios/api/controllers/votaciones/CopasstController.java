package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCopasstService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICopasstService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionesSecurity;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotoRequestService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/copasst")

public class CopasstController {

    private final ICopasstService iCopasstService;
    private final ICandidatosCopasstService iCandidatosCopasstService;
    private final IVotacionesSecurity iVotacionesSecurity;
    private final IVotoRequestService iVotoRequestService;

    public CopasstController(ICopasstService iCopasstService, ICandidatosCopasstService iCandidatosCopasstService, IVotacionesSecurity iVotacionesSecurity, IVotoRequestService iVotoRequestService) {
        this.iCopasstService = iCopasstService;
        this.iCandidatosCopasstService = iCandidatosCopasstService;
        this.iVotacionesSecurity = iVotacionesSecurity;
        this.iVotoRequestService = iVotoRequestService;
    }

    @GetMapping("/estado_voto")
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
            return ResponseEntity.ok(iCopasstService.verificarEstadoVoto(email));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return ValidationErrorHandler.handleValidation(e);
        } catch (RuntimeException e) {
            System.out.println(e);
            return ValidationErrorHandler.handleException(e);
        }
    }

    @GetMapping("/candidatos")
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.ok(iCandidatosCopasstService.buscarCandidatos(120));
        } catch (IllegalArgumentException e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (RuntimeException e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping("/votar")
    public ResponseEntity<?> post(@RequestBody VotoRequest votacionesRequest, @RequestParam String email) throws Exception {
        try {
            iVotacionesSecurity.userAuthorized(email);
            iVotoRequestService.save(votacionesRequest, email);
            Map<String, String> result = new HashMap<>();
            result.put("Mensaje", "Correcto");
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (RuntimeException e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

}