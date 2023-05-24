package com.neoris.peliculas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * Aqui tenemos la clase de negocio con anotaciones lombok para obtener el constructor con parametros,
 * constructor sin parametros, getters and setters.
 * @Author Isaac Calderón
 *
 */
public class Pelicula {

    private Integer id;
    private String titulo;
    private String director;
    private String genero;
    private Integer duracion;
    private Integer anio;
}
