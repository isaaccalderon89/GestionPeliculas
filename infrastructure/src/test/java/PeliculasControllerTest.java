import com.neoris.peliculas.entities.Pelicula;
import com.neoris.peliculas.infrastructure.controller.PeliculaController;
import com.neoris.peliculas.usecases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PeliculasControllerTest {

    @Mock
    FindAllPeliculasUseCase findAllPeliculasUseCase;
    @Mock
    CreatePeliculaUseCase createPeliculaUseCase;
    @Mock
    UpdatePeliculaUseCase updatePeliculaUseCase;
    @Mock
    DeletePeliculaUseCase deletePeliculaUseCase;
    @Mock
    FindByTitleUseCase findByTitleUseCase;
    @Mock
    FindByGenreUseCase findByGenreUseCase;
    @Mock
    FindByAnioUseCase findByAnioUseCase;

    @InjectMocks
    PeliculaController peliculaController;

    List<Pelicula> peliculas;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAlTest(){
        when(findAllPeliculasUseCase.findAllPeliculas()).thenReturn(peliculas);
        ResponseEntity<List<Pelicula>> result = peliculaController.getAllPeliculas();
        assertEquals(peliculas,result.getBody());
    }

    @Test
    void createPeliculaTest(){
        Pelicula pelicula = new Pelicula(9,"tituloPrueba","directorPrueba","generoPrueba",120,1989);
        when(createPeliculaUseCase.createPelicula(pelicula)).thenReturn(pelicula);
        ResponseEntity<Pelicula> newPelicula = peliculaController.createPelicula(pelicula);
        assertEquals(HttpStatus.CREATED, newPelicula.getStatusCode());
        assertEquals(pelicula, newPelicula.getBody());
    }

    @Test
    void updatePeliculaTest(){
        Pelicula pelicula = new Pelicula(9,"tituloPrueba","directorPrueba","generoPrueba",120,1989);
        when(updatePeliculaUseCase.updatePelicula(pelicula)).thenReturn(pelicula);
        ResponseEntity<Pelicula> newPelicula = peliculaController.updatePelicula(pelicula);
        assertEquals(HttpStatus.CREATED, newPelicula.getStatusCode());
        assertEquals(pelicula, newPelicula.getBody());
    }

    @Test
    void deletePeliculaTest(){
        Integer idPelicula = 9;
        when(deletePeliculaUseCase.deletePelicula(idPelicula)).thenReturn(false);
        ResponseEntity<Void> response = peliculaController.deletePelicula(idPelicula);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    void findByTitleTest(){
        Pelicula pelicula = new Pelicula();
        String title = "Interstellar";
        pelicula.setTitulo(title);
        when(findByTitleUseCase.findByTitle(title)).thenReturn(pelicula);
        ResponseEntity<Pelicula> response = peliculaController.findByTitulo(title);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pelicula, response.getBody());
    }

    @Test
    void findByTitleNotFoundTest(){
        String title = "NotFoundTitle";
        when(findByTitleUseCase.findByTitle(title)).thenReturn(null);
        ResponseEntity<Pelicula> response = peliculaController.findByTitulo(title);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    void findByTitleException(){
        String title = "ExceptionTitle";
        when(findByTitleUseCase.findByTitle(title)).thenThrow(new RuntimeException());
        ResponseEntity<Pelicula> response = peliculaController.findByTitulo(title);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    @Test
    void findByGenreTest(){
        String genre = "Drama";
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Pelicula 1");
        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Pelicula 2");
        List<Pelicula> peliculas = Arrays.asList(pelicula1, pelicula2);
        when(findByGenreUseCase.findByGenre(genre)).thenReturn(peliculas);
        ResponseEntity<List<Pelicula>> response = peliculaController.findByGenero(genre);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(peliculas, response.getBody());
    }
    @Test
    void findByGenreNotFoundTest(){
        String genre = "NonExistingGenre";
        when(findByGenreUseCase.findByGenre(genre)).thenReturn(null);
        ResponseEntity<List<Pelicula>> response = peliculaController.findByGenero(genre);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    void findByGenreExceptionTest(){
        String genre = "GenreWithException";
        when(findByGenreUseCase.findByGenre(genre)).thenThrow(new RuntimeException());
        ResponseEntity<List<Pelicula>> response = peliculaController.findByGenero(genre);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    @Test
    void findByAnioTest(){
        String anio = "2014";
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Pelicula 1");
        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Pelicula 2");
        List<Pelicula> peliculas = Arrays.asList(pelicula1, pelicula2);
        when(findByAnioUseCase.findByAnio(anio)).thenReturn(peliculas);
        ResponseEntity<List<Pelicula>> response = peliculaController.findByAnio(anio);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(peliculas, response.getBody());
    }

    @Test
    void findByAnioExceptionTest(){
        String anio = "YearWithException";
        when(findByAnioUseCase.findByAnio(anio)).thenThrow(new RuntimeException());
        ResponseEntity<List<Pelicula>> response = peliculaController.findByAnio(anio);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
