package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;




class TorneoTest {

    @Test
    void testRegistrarEquipoCorrectamente(String nombre, String categoria, String modalidad) {
        Torneo torneo = new Torneo("Liga Juvenil",EDeporte.Futbol, ECategoriaEquipo.Juvenil, "Masculino", "Liga");

        Entrenador entrenador = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
        ECategoriaEquipo categoriaEquipo=ECategoriaEquipo.valueOf(categoria);
        Equipo equipo = new Equipo(nombre, categoriaEquipo, modalidad, entrenador);

        torneo.registrarEquipo(equipo);

        assertEquals(1, torneo.getEquipos().size());
    }

    @ParameterizedTest
    @CsvSource({
            "Tigres, Juvenil, Masculino",
            
    })
    void testNoRegistrarEquipoDeDiferenteCategoria(String nombre, String categoria, String modalidad) {
        Torneo torneo = new Torneo("Liga Juvenil", EDeporte.Futbol, ECategoriaEquipo.Cadete, "Masculino", "Liga");
         ECategoriaEquipo categoriaEquipo=ECategoriaEquipo.valueOf(categoria);
        Entrenador entrenador = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
        EGenero modalidadEquipo=EGenero.valueOf(modalidad);
        Equipo equipo = new Equipo(nombre,categoriaEquipo, modalidadEquipo.toString(), entrenador);

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipo));
    }

    @ParameterizedTest
    @CsvSource({
            "Leonas, Juvenil, Femenino",
            
    })
    void testNoRegistrarEquipoDeDiferenteModalidad(String nombre, String categoria, String modalidad) {
        Torneo torneo = new Torneo("Liga Juvenil", EDeporte.Futbol,ECategoriaEquipo.Juvenil, "Masculino", "Liga");

        Entrenador entrenador = new Entrenador("Carlos", EGenero.Masculino, LocalDate.of(1980, 3, 10));
       ECategoriaEquipo categoriaEquipo=ECategoriaEquipo.valueOf(categoria);
       EGenero modalidadEquipo=EGenero.valueOf(modalidad);
        Equipo equipo = new Equipo(nombre, categoriaEquipo, modalidadEquipo.toString(), entrenador);

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipo));
    }
}
