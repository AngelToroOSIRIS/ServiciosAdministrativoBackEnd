package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;

import java.util.Map;

public interface IVotoRequestService {
    Map<String,String> votacionesRequest(String email);
    Object save(VotoRequest votacionesRequest) throws Exception;
}
