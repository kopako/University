package com.botscrew.university.repositories;

import com.botscrew.university.models.Lector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<Lector, Long> {
    Iterable<Lector> findByNameContainingIgnoreCase(String template);
}
