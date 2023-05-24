package com.neoris.peliculas.infrastructure.domain.entity;

import jakarta.persistence.*;
/**
 * Esta es la clase de base de datos, con las anotaciones Spring estamos indicando el nombre de la tabla
 * en la base de datos, así como las columnas y la clase primaria y la estrategia que esta va a seguir.
 */
@Entity
@Table(name="PELICULAS")
public class InMemoryPeliculaRepositoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PELICULA")
    private Integer id;
    @Column(name="TITULO")
    private String titulo;
    @Column(name="DIRECTOR")
    private String director;
    @Column(name="GENERO")
    private String genero;
    @Column(name="DURACION")
    private Integer duracion;
    @Column(name="ANIO")
    private Integer anio;

    public InMemoryPeliculaRepositoryEntity(Integer id, String titulo, String director, String genero, Integer duracion, Integer anio) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.anio = anio;
    }

    public InMemoryPeliculaRepositoryEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
