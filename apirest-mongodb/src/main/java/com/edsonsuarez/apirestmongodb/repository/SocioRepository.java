package com.edsonsuarez.apirestmongodb.repository;

import com.edsonsuarez.apirestmongodb.model.Socio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocioRepository extends MongoRepository<Socio, String> {
    boolean existsByDni(String dni);
}
