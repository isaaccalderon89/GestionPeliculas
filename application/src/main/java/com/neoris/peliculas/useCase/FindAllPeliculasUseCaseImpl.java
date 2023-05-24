package com.neoris.peliculas.useCase;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.FindAllPeliculasUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPeliculasUseCaseImpl implements FindAllPeliculasUseCase {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public List<Pelicula> findAllPeliculas() {
        return peliculaRepository.findAllPeliculas();
    }
}
