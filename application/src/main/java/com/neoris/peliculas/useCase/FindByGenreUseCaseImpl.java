package com.neoris.peliculas.useCase;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.FindByGenreUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByGenreUseCaseImpl implements FindByGenreUseCase {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> findByGenre(String genre) {
        return peliculaRepository.findByGenre(genre);
    }
}
