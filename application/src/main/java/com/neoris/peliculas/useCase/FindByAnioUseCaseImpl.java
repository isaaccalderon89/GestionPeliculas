package com.neoris.peliculas.useCase;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.FindByAnioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByAnioUseCaseImpl implements FindByAnioUseCase {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public List<Pelicula> findByAnio(String anio) {
        return peliculaRepository.findByAnio(anio);
    }
}
