package com.neoris.peliculas.useCase;

import com.neoris.peliculas.repository.PeliculaRepository;
import com.neoris.peliculas.usecases.DeletePeliculaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePeliculaUseCaseImpl implements DeletePeliculaUseCase {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public Boolean deletePelicula(Integer id) {
        return peliculaRepository.deletePelicula(id);
    }
}
