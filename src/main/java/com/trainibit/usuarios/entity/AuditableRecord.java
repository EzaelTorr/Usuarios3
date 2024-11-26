package com.trainibit.usuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;
import java.time.LocalDate;


@MappedSuperclass
@Data
public class AuditableRecord  {
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdat;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedat;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active;


}



