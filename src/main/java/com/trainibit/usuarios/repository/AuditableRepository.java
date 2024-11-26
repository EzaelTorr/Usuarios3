package com.trainibit.usuarios.repository;


import com.trainibit.usuarios.entity.Usuario;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AuditableRepository <T, Id> extends JpaRepository<T, Id>{

   void borrarByIdActive(Id id);

   T actualizarAudit(T entity);


}
