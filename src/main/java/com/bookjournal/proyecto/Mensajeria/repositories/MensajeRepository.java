package com.bookjournal.proyecto.Mensajeria.repositories;

import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    // Consulta los mensajes de un remitente o destinatario por sus ID
    List<Mensaje> findByRemitente_IdOrDestinatario_Id(Long remitenteId, Long destinatarioId);
}
