package com.neoris.peliculas.usecases;

import com.neoris.peliculas.entities.Pelicula;

import java.util.List;

public interface FindAllPeliculasUseCase {
    List<Pelicula> findAllPeliculas();
}
