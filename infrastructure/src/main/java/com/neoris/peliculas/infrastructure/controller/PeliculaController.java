package com.neoris.peliculas.infrastructure.controller;

import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador REST para la gestión de eventos
 */
@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    private FindAllPeliculasUseCase findAllPeliculasUseCase;
    private CreatePeliculaUseCase createPeliculaUseCase;
    private UpdatePeliculaUseCase updatePeliculaUseCase;
    private DeletePeliculaUseCase deletePeliculaUseCase;
    private FindByTitleUseCase findByTitleUseCase;
    private FindByGenreUseCase findByGenreUseCase;
    private FindByAnioUseCase findByAnioUseCase;

    /**
     * Constructor de la clase PeliculaController.
     *
     * @param findAllPeliculasUseCase El caso de uso para encontrar todas las películas.
     * @param createPeliculaUseCase   El caso de uso para crear una nueva película.
     * @param updatePeliculaUseCase   El caso de uso para actualizar una película existente.
     * @param deletePeliculaUseCase   El caso de uso para eliminar una película existente.
     * @param findByTitleUseCase      El caso de uso para encontrar películas por título.
     * @param findByGenreUseCase      El caso de uso para encontrar películas por género.
     * @param findByAnioUseCase       El caso de uso para encontrar películas por año.
     */
    public PeliculaController(FindAllPeliculasUseCase findAllPeliculasUseCase, CreatePeliculaUseCase createPeliculaUseCase, UpdatePeliculaUseCase updatePeliculaUseCase, DeletePeliculaUseCase deletePeliculaUseCase, FindByTitleUseCase findByTitleUseCase, FindByGenreUseCase findByGenreUseCase, FindByAnioUseCase findByAnioUseCase) {
        this.findAllPeliculasUseCase = findAllPeliculasUseCase;
        this.createPeliculaUseCase = createPeliculaUseCase;
        this.updatePeliculaUseCase = updatePeliculaUseCase;
        this.deletePeliculaUseCase = deletePeliculaUseCase;
        this.findByTitleUseCase = findByTitleUseCase;
        this.findByGenreUseCase = findByGenreUseCase;
        this.findByAnioUseCase = findByAnioUseCase;
    }
    /**
     * Recupera todas las películas.
     *
     * @return ResponseEntity con la lista de películas en formato JSON.
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        return ResponseEntity.ok(findAllPeliculasUseCase.findAllPeliculas());
    }
    /**
     * Crea una nueva película.
     *
     * @param pelicula La película a crear, proporcionada en el cuerpo de la solicitud.
     * @return ResponseEntity con la película creada en formato JSON si se crea exitosamente,
     *         o una respuesta de error con código 500 si ocurre una excepción.
     */
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        try {
            Pelicula newPelicula = createPeliculaUseCase.createPelicula(pelicula);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPelicula);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Actualiza una película existente.
     *
     * @param pelicula La película actualizada, proporcionada en el cuerpo de la solicitud.
     * @return ResponseEntity con la película actualizada en formato JSON si se actualiza exitosamente,
     *         o una respuesta de error con código 500 si ocurre una excepción.
     */
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pelicula> updatePelicula(@RequestBody Pelicula pelicula) {
        try {
            Pelicula newPelicula = updatePeliculaUseCase.updatePelicula(pelicula);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPelicula);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Elimina una película por su ID.
     *
     * @param id El ID de la película a eliminar.
     * @return ResponseEntity sin contenido (código 204) si se elimina exitosamente,
     *         o ResponseEntity con código 404 si no se encuentra la película.
     */
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePelicula(@PathVariable Integer id) {
        if (deletePeliculaUseCase.deletePelicula(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Busca una película por título.
     *
     * @param title El título de la película a buscar.
     * @return ResponseEntity con la película encontrada en formato JSON si se encuentra,
     *         o una respuesta de error con código 404 si no se encuentra la película,
     *         o una respuesta de error con código 500 si ocurre una excepción.
     */
    @GetMapping(value = "/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pelicula> findByTitulo(@PathVariable String title) {
        try {
            Pelicula pelicula = findByTitleUseCase.findByTitle(title);
            if (pelicula != null) {
                return ResponseEntity.ok(pelicula);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Busca películas por género.
     *
     * @param genre El género de las películas a buscar.
     * @return ResponseEntity con la lista de películas encontradas en formato JSON si se encuentran,
     *         o una respuesta de error con código 404 si no se encuentran películas,
     *         o una respuesta de error con código 500 si ocurre una excepción.
     */
    @GetMapping(value = "/genre/{genre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pelicula>> findByGenero(@PathVariable String genre) {
        try {
            List<Pelicula> peliculas = findByGenreUseCase.findByGenre(genre);
            if (peliculas != null) {
                return ResponseEntity.ok(peliculas);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Busca películas por año.
     *
     * @param anio El año de las películas a buscar.
     * @return ResponseEntity con la lista de películas encontradas en formato JSON si se encuentran,
     *         o una respuesta de error con código 500 si ocurre una excepción.
     */
    @GetMapping(value = "/anio/{anio}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pelicula>> findByAnio(@PathVariable String anio) {
        try {
            List<Pelicula> peliculas = findByAnioUseCase.findByAnio(anio);
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
