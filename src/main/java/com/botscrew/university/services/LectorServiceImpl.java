package com.botscrew.university.services;

import com.botscrew.university.models.Lector;
import com.botscrew.university.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String globalSearchBy(String template) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterable<Lector> result = findByNameContainingIgnoreCase(template);
        if (result == null) return "Found nothing";
        result.forEach(a -> stringBuilder.append(a.getName()).append(", "));
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(", "));
    }

    private Iterable<Lector> findByNameContainingIgnoreCase(String template) {
        return lectorRepository.findByNameContainingIgnoreCase(template);
    }
}
