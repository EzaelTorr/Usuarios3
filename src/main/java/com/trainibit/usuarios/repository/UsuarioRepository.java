package com.trainibit.usuarios.repository;

import com.trainibit.usuarios.entity.Usuario;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends AuditableRepository<Usuario, Long> {
    @Override
    default void borrarByIdActive(Long id){
        Usuario entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        entity.setActive(false);
        save(entity);
  }


    Optional<Usuario> findByUuid(UUID uuid);

    @Override
    default Usuario actualizarAudit(Usuario entity){
        entity.setUpdatedat(new Timestamp(System.currentTimeMillis()));
        return save(entity);
  }

}
