package org.ualhmis.torneos;

import java.time.LocalDate;

class Entrenador extends Persona {
    public Entrenador(String nombre, EGenero genero, LocalDate fechaNacimiento) {
        super(nombre, genero, fechaNacimiento);
    }
}