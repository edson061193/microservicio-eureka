package com.edsonsuarez.apirestmysql.repository;

import com.edsonsuarez.apirestmysql.entity.SocioHistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SocioHistorialRepository extends JpaRepository<SocioHistorialEntity, Serializable> {
}
