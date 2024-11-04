package com.bookjournal.proyecto.Mensajeria.repositories;

import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// MensajeRepository.java
@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
    List<Mensaje> findByRemitenteIdOrDestinatario_Id(Long remitenteId, Long destinatarioId);







    List<Mensaje> findAll();

    @Query("SELECT m FROM Mensaje m WHERE m.destinatario.id=:id")
    List<Mensaje> findMensajesFromIdRemitente(@Param("id")int id);

}
