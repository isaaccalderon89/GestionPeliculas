package com.neoris.peliculas.infrastructure.repository.jpa;

import com.neoris.peliculas.infrastructure.domain.entity.InMemoryPeliculaRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repositorio JPA para la entidad Evento.
 * Proporciona métodos para acceder y gestionar los datos de las peliculas en la base de datos.
 */
@Repository
public interface PeliculaJpaRepository extends JpaRepository<InMemoryPeliculaRepositoryEntity,Integer> {

    @Query("SELECT t FROM InMemoryPeliculaRepositoryEntity t WHERE t.titulo = :title")
    InMemoryPeliculaRepositoryEntity findBytitle(String title);

    @Query("SELECT g FROM InMemoryPeliculaRepositoryEntity g WHERE g.genero = :genre")
    List<InMemoryPeliculaRepositoryEntity> findByGenre(String genre);

    @Query("SELECT a FROM InMemoryPeliculaRepositoryEntity a WHERE a.anio = :anio")
    List<InMemoryPeliculaRepositoryEntity> findByAnio(String anio);

}
