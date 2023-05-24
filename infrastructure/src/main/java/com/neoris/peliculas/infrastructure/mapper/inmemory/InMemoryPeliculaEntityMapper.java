package com.neoris.peliculas.infrastructure.mapper.inmemory;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.infrastructure.domain.entity.InMemoryPeliculaRepositoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
/**
 * Interfaz de mapeo en memoria para la entidad de Evento.
 * Extiende {@Link InMemoryEntityMapper} para porporcionar métodos de mapeo especificos para la entidad del evento
 */
@Mapper
public interface InMemoryPeliculaEntityMapper extends InMemoryEntityMapper<Pelicula, InMemoryPeliculaRepositoryEntity>{
    /**
     * Instancia del mapeador de entidades InMemoryEventoEntityMapper.
     */
    InMemoryPeliculaEntityMapper INSTANCE = Mappers.getMapper(InMemoryPeliculaEntityMapper.class);
    /**
     * Convierte una entidad en memoria de tipo InMemoryEventoRepositoryEntity en una entidad de dominio de tipo Evento.
     *
     * @param inmemoryEntity La entidad en memoria que se va a convertir.
     * @return La entidad de dominio de tipo Evento correspondiente.
     */
    @Override
    @Mapping(source="id", target= "id")
    Pelicula toDomainEntity(InMemoryPeliculaRepositoryEntity inmemoryEntity);
}
