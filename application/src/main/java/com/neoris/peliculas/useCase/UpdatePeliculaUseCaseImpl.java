package com.neoris.peliculas.useCase;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.UpdatePeliculaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePeliculaUseCaseImpl implements UpdatePeliculaUseCase {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Pelicula updatePelicula(Pelicula pelicula) {
        return peliculaRepository.updatePelicula(pelicula);
    }
}
