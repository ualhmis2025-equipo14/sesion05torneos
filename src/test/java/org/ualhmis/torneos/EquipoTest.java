package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

// Creación de jugadores y cálculo automático de categoría

class EquipoTest {

    @ParameterizedTest
    @CsvSource({
            "Luis, Masculino, 2006-07-15", // Juvenil
            "Ana, Femenino, 2010-05-20", // Infantil
            "Carlos, Masculino, 2003-08-30" // Junior
    })
    void testAgregarJugadorCorrectamente(String nombre, String genero, String fechaNacimiento) {
        Entrenador entrenador = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", ECategoriaEquipo.Juvenil, "Masculino", entrenador);
        EGenero generoJugador= EGenero.valueOf(genero);
        LocalDate fechaNacimientoDate= LocalDate.parse(fechaNacimiento);
        Jugador jugador = new Jugador(nombre, generoJugador, fechaNacimientoDate);
        equipo.agregarJugador(jugador);

        assertEquals(1, equipo.getJugadores().size());
    }

    @ParameterizedTest
    @CsvSource({
            "Luis, Masculino, 2015-05-10", // Infantil
    })
    void testNoAgregarJugadorDeDiferenteCategoria(String nombre, String genero, String fechaNacimiento) {
        Entrenador entrenador = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", ECategoriaEquipo.Juvenil, "Masculino", entrenador);

        EGenero generoJugador= EGenero.valueOf(genero);
        LocalDate fechaNacimientoDate= LocalDate.parse(fechaNacimiento);
        Jugador jugador = new Jugador(nombre, generoJugador, fechaNacimientoDate);

        equipo.agregarJugador(jugador);

        assertEquals(0, equipo.getJugadores().size()); // No debe agregarse
    }

    @ParameterizedTest
    @CsvSource({
            "Ana, Femenino, 1985-06-20",
    })
    void testAsignarSegundoEntrenador(String nombre, String genero, String fechaNacimiento) {
        EGenero generoEntrenador= EGenero.valueOf(genero);
        LocalDate fechaNacimientoDate= LocalDate.parse(fechaNacimiento);
        Entrenador entrenador = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador(nombre, generoEntrenador, fechaNacimientoDate);

        Equipo equipo = new Equipo("Tigres",ECategoriaEquipo.Juvenil, "Masculino", entrenador);
        equipo.asignarSegundoEntrenador(entrenador2);

        assertNotNull(equipo.getSegundoEntrenador());
        assertEquals("Ana", equipo.getSegundoEntrenador().getNombre());
    }
}
