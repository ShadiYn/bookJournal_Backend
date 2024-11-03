package com.bookjournal.proyecto.Mensajeria.repositories;

import com.bookjournal.proyecto.Mensajeria.Entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.nombre=:nombre")
    Usuario findUsuario(@Param("nombre")String nombre);

    List<Usuario> findAll();

}
