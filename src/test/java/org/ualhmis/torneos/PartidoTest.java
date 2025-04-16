package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

// Registro de equipos en torneos con validación de categoría y modalidad

class PartidoTest {


    @ParameterizedTest
    @CsvSource({
            "Tigres, Juvenil, Masculino",
            "Leones, Cadete, Femenino",
           
    })
    void testRegistrarResultado(String nombre, String categoria, String modalidad) {
        Entrenador entrenador1 = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", EGenero.Femenino, LocalDate.of(1985, 6, 20));
        ECategoriaEquipo categoriaEquipo=ECategoriaEquipo.valueOf(categoria);
        Equipo equipo1 = new Equipo(nombre, categoriaEquipo, "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", ECategoriaEquipo.Juvenil, "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        partido.registrarResultado(2, 1);

        assertEquals(2, partido.getGolesEquipo1());
        assertEquals(1, partido.getGolesEquipo2());
    }
}
