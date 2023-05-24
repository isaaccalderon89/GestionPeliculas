package com.neoris.peliculas.repository;

import com.neoris.peliculas.entities.Pelicula;

import java.util.List;

public interface PeliculaRepository {
    /**
     * Metodo que devuelve una lista con todas las peliculas
     * @return
     */
    List<Pelicula> findAllPeliculas();

    /**
     * Metodo que permite crear una pelicula
     * @param pelicula
     * @return la pelicula creada
     */
    Pelicula createPelicula(Pelicula pelicula);

    /**
     * Metodo que permite modificar una pelicua
     * @param pelicula
     * @return la pelicula modificada
     */
    Pelicula updatePelicula(Pelicula pelicula);

    /**
     * Metodo para eliminar una pelicula
     * @param id le pasamos el id de un evento que exita y queramos eliminar
     * @return un <b>true</b> si el evento ha sido elimado, <b>false</b> si el evento no ha sido elimando
     */
    Boolean deletePelicula(Integer id);

    /**
     * Metodo que permite buscar una pelicula por su titulo
     * @param titulo de la pelicula
     * @return pelicula que coincida con el titulo
     */
    Pelicula findByTitle(String titulo);

    /**
     * Metodo que devuelve una lista filtrada por el genero
     * @param genre genero de la pelicula
     * @return lista de peliculas filtrada por el genero
     */
    List<Pelicula> findByGenre(String genre);

    /**
     * Metodo que devuelve una lista filtrada por el año
     * @param anio de estreno de la pelicula
     * @return listado de peliculas filtradas por el año
     */
    List<Pelicula> findByAnio(String anio);

}
