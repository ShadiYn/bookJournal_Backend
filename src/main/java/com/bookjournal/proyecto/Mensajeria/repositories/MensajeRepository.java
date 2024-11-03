package com.bookjournal.proyecto.Mensajeria.repositories;

import com.bookjournal.proyecto.Mensajeria.Entities.Mensaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MensajeRepository extends CrudRepository<Mensaje, Integer> {


    List<Mensaje> findAll();

    @Query("SELECT m FROM Mensaje m WHERE m.destinatario.id=:id")
    List<Mensaje> findMensajesFromIdRemitente(@Param("id")int id);

}
