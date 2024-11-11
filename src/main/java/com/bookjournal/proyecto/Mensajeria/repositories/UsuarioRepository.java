package com.bookjournal.proyecto.Mensajeria.repositories;

import com.bookjournal.proyecto.Mensajeria.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByIdIn(List<Long> ids);

    @Query("SELECT u FROM Usuario u WHERE u.nombre=:nombre")
    Usuario findUsuario(@Param("nombre") String nombre);
    List<Usuario> findAll();

}
