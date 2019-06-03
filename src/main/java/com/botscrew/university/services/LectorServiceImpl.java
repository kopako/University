package com.botscrew.university.services;

import com.botscrew.university.models.Lector;
import com.botscrew.university.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String globalSearchBy(String template) {
        StringBuilder stringBuilder = new StringBuilder();
        findByNameContainingIgnoreCase(template).forEach(a -> stringBuilder.append(a.getName()).append(", "));
        return stringBuilder.substring(stringBuilder.lastIndexOf(", "));
    }

    private Iterable<Lector> findByNameContainingIgnoreCase(String template) {
        return lectorRepository.findByNameContainingIgnoreCase(template);
    }
}
