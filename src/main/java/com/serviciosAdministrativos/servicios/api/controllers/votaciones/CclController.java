package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCclService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICclService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionesSecurity;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotoRequestService;
import com.serviciosAdministrativos.servicios.util.votaciones.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ccl")

public class CclController {

    private final ICclService iCclService;
    private final IVotacionesSecurity iVotacionesSecurity;
    private final IVotoRequestService iVotoRequestService;
    private final ICandidatosCclService iCandidatosCclService;

    public CclController(ICclService iCclService, IVotacionesSecurity iVotacionesSecurity, IVotoRequestService iVotoRequestService, ICandidatosCclService iCandidatosCclService) {
        this.iCclService = iCclService;
        this.iVotacionesSecurity = iVotacionesSecurity;
        this.iVotoRequestService = iVotoRequestService;
        this.iCandidatosCclService = iCandidatosCclService;
    }

    @GetMapping("/estado_voto")
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
        return ResponseEntity.ok(iCclService.VerificarVotoCcl(email));
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
            return ResponseEntity.ok(iCandidatosCclService.buscarCandidatosCcl(121));
        } catch (IllegalArgumentException e){
            return ValidationErrorHandler.handleValidation(e);
        }catch (RuntimeException e){
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping("/votar")
    public ResponseEntity<?> post(@RequestBody VotoRequest votacionesRequest, @RequestParam String email) throws Exception {
        try {
            iVotacionesSecurity.userAuthorized(email);
            return ResponseEntity.ok(iVotoRequestService.save(votacionesRequest, email));
        } catch (IllegalArgumentException e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (RuntimeException e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}