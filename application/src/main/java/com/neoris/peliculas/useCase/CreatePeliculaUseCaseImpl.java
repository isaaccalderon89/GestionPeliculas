package com.neoris.peliculas.useCase;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.CreatePeliculaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePeliculaUseCaseImpl implements CreatePeliculaUseCase {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.createPelicula(pelicula);
    }
}
