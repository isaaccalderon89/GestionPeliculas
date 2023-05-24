package com.neoris.peliculas.usecases;

import com.neoris.peliculas.entities.Pelicula;

import java.util.List;

public interface FindByAnioUseCase {
    List<Pelicula> findByAnio(String anio);
}
