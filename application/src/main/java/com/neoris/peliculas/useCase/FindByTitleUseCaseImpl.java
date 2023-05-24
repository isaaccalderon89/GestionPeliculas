package com.neoris.peliculas.useCase;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.FindByTitleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindByTitleUseCaseImpl implements FindByTitleUseCase {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public Pelicula findByTitle(String titulo) {
        return peliculaRepository.findByTitle(titulo);
    }
}
