package com.neoris.peliculas.usecases;

import com.neoris.peliculas.entities.Pelicula;

public interface FindByTitleUseCase {

    Pelicula findByTitle(String titulo);
}
