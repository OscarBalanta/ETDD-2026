package com.universidad.util;

import com.universidad.modelo.*;
import com.universidad.sistema.SistemaUniversidad;

import java.util.ArrayList;

public class CargadorDatos {

    // Carga de estudiasntes desde CSV a mi sistema universitario
    public static void cargarEstudiantes(
            String ruta,
            SistemaUniversidad sistema) {

        ArrayList<String[]> datos =
                LectorCSV.leer(ruta);

        for (String[] fila : datos) {

            String id = fila[0];
            String nombre = fila[1];
            String email = fila[2];

            int semestre =
                    Integer.parseInt(fila[3]);

            Estudiante estudiante =
                    new Estudiante(
                            nombre,
                            id,
                            email,
                            semestre);

            sistema.registrarEstudiante(estudiante);
        }
    }

    // CArga de materias desde CSV para estudiantes de la U
    public static void cargarMaterias(
            String ruta,
            SistemaUniversidad sistema) {

        ArrayList<String[]> datos =
                LectorCSV.leer(ruta);

        for (String[] fila : datos) {

            String codigo = fila[0];
            String nombre = fila[1];

            int cupos =
                    Integer.parseInt(fila[2]);

            int creditos =
                    Integer.parseInt(fila[3]);

            Materia materia =
                    new Materia(
                            codigo,
                            nombre,
                            cupos,
                            creditos);

            sistema.registrarMateria(materia);
        }
    }

    // Carga de solicitudes de inscripción desde CSV
    public static void cargarSolicitudes(
            String ruta,
            SistemaUniversidad sistema) {

        ArrayList<String[]> datos =
                LectorCSV.leer(ruta);

        for (String[] fila : datos) {

            String id = fila[0];

            String codigo = fila[1];

            SolicitudInscripcion solicitud =
                    new SolicitudInscripcion(
                            id,
                            codigo);

            sistema.getProcesador()
                    .agregarSolicitud(solicitud);
        }
    }
}
