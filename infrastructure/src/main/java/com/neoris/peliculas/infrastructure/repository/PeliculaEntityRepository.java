package com.neoris.peliculas.infrastructure.repository;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.infrastructure.domain.entity.InMemoryPeliculaRepositoryEntity;
import com.neoris.peliculas.infrastructure.mapper.inmemory.InMemoryPeliculaEntityMapper;
import com.neoris.peliculas.infrastructure.repository.jpa.PeliculaJpaRepository;
import com.neoris.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaEntityRepository implements PeliculaRepository {

    @Autowired
    private PeliculaJpaRepository peliculaJpaRepository;

    @Override
    public List<Pelicula> findAllPeliculas() {
        List<InMemoryPeliculaRepositoryEntity> result = peliculaJpaRepository.findAll();
        return InMemoryPeliculaEntityMapper.INSTANCE.toDomainEntityList(result);
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        InMemoryPeliculaRepositoryEntity createPelicula = peliculaJpaRepository.save(InMemoryPeliculaEntityMapper.INSTANCE.fromDomainEntity(pelicula));
        return InMemoryPeliculaEntityMapper.INSTANCE.toDomainEntity(createPelicula);
    }

    @Override
    public Pelicula updatePelicula(Pelicula pelicula) {
        InMemoryPeliculaRepositoryEntity updatePelicula= peliculaJpaRepository.save(InMemoryPeliculaEntityMapper.INSTANCE.fromDomainEntity(pelicula));
        return InMemoryPeliculaEntityMapper.INSTANCE.toDomainEntity(updatePelicula);
    }

    @Override
    public Boolean deletePelicula(Integer id) {
        if(peliculaJpaRepository.existsById(id)){
            peliculaJpaRepository.deleteById(id);
            return true;
        }
        return null;
    }

    @Override
    public Pelicula findByTitle(String titulo) {
        InMemoryPeliculaRepositoryEntity result = peliculaJpaRepository.findBytitle(titulo);
        return InMemoryPeliculaEntityMapper.INSTANCE.toDomainEntity(result);
    }

    @Override
    public List<Pelicula> findByGenre(String genre) {
        List<InMemoryPeliculaRepositoryEntity> result = peliculaJpaRepository.findByGenre(genre);
        return InMemoryPeliculaEntityMapper.INSTANCE.toDomainEntityList(result);
    }


    @Override
    public List<Pelicula> findByAnio(String anio) {
        List<InMemoryPeliculaRepositoryEntity> result = peliculaJpaRepository.findByAnio(anio);
        return InMemoryPeliculaEntityMapper.INSTANCE.toDomainEntityList(result);
    }
}
