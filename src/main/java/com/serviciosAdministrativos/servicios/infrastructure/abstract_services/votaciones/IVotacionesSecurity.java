package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

public interface IVotacionesSecurity {
    Boolean userAuthorized(String email);
}
