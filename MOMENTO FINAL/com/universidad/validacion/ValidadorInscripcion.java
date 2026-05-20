package com.universidad.validacion;

import com.universidad.modelo.Estudiante;
import com.universidad.modelo.Materia;

public class ValidadorInscripcion {

    // VaalidaciOn de la isncripcion de un estudiante a la materiaa
    public static boolean validar(
            Estudiante estudiante,
            Materia materia) {

        if (estudiante == null ||
            materia == null) {

            return false;
        }

        if (!materia.hayCupo()) {

            return false;
        }

        return true;
    }
}