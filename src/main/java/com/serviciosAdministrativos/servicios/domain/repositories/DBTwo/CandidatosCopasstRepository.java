package com.serviciosAdministrativos.servicios.domain.repositories.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosCopasstEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CandidatosCopasstRepository extends JpaRepository<CandidatosCopasstEntity, Integer> {
    @Query("SELECT e FROM CandidatosCopasstEntity e WHERE e.idcrp = 120")
    ArrayList<CandidatosCopasstEntity> findAllByIdcrp(@Param("idcrp") Integer idcrp);
}
