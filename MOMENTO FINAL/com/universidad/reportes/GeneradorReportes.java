package com.universidad.reportes;

import com.universidad.modelo.Estudiante;
import com.universidad.modelo.Materia;

import java.util.HashMap;

public class GeneradorReportes {

     // Reporde de los estudiantes x sus materias tecnicas
    public static void mostrarEstudiantes(
            HashMap<String, Estudiante>
                    estudiantes) {

        for (Estudiante e :
                estudiantes.values()) {

            System.out.println(
                    e.getId() +
                    " - " +
                    e.getNombre());
        }
    }

        // Reporte de las materias x su codigo & nombre
    public static void mostrarMaterias(
            HashMap<String, Materia>
                    materias) {

        for (Materia m :
                materias.values()) {

            System.out.println(
                    m.getCodigo() +
                    " - " +
                    m.getNombre());
        }
    }
}
