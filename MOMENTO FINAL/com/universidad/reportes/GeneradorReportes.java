package com.universidad.reportes;

import com.universidad.modelo.Estudiante;
import com.universidad.modelo.Materia;

import java.util.HashMap;

public class GeneradorReportes {

     // Reporde de los estudiantes x sus materias tecnicas
    public static void mostrarEstudiantes(
            HashMap<String, Estudiante>
                    estudiantes) {

        var listaEstudiantes =
                new java.util.ArrayList<>(
                        estudiantes.values());

        listaEstudiantes.sort(
                java.util.Comparator.comparing(
                        Estudiante::getId));

        for (Estudiante e :
                listaEstudiantes) {

            System.out.println(
                    e.getId() +
                    " - " +
                    e.getNombre() +
                    " | Semestre: " +
                    e.getSemestre() +
                    " | Promedio: " +
                    String.format("%.2f", e.calcularPromedio()));
        }
    }

    // Reporte de las materias x su codigo & nombre
    public static void mostrarMaterias(
            HashMap<String, Materia>
                    materias) {

        var materiaList =
                new java.util.ArrayList<>(
                        materias.values());

        materiaList.sort(
                java.util.Comparator.comparing(
                        Materia::getCodigo));

        for (Materia m :
                materiaList) {

            System.out.println(
                    m.getCodigo() +
                    " - " +
                    m.getNombre());
        }
    }

    public static void mostrarMaterias(
            HashMap<String, Materia> materias,
            HashMap<String, Estudiante> estudiantes) {

        var materiaList =
                new java.util.ArrayList<>(
                        materias.values());

        for (int i = 0;
             i < materiaList.size();
             i++) {

            Materia m = materiaList.get(i);

            System.out.println(
                    m.getCodigo() +
                    " - " +
                    m.getNombre() +
                    " | Cupos: " +
                    m.getCupos() +
                    " | Inscritos: " +
                    m.getInscritos());

            double sumaNotas = 0;
            int contadorNotas = 0;

            for (Estudiante e : estudiantes.values()) {

                Double[][] notas = e.getNotas();
                int semestre = e.getSemestre();

                if (semestre >= 0 && semestre < notas.length &&
                        i < notas[semestre].length) {

                    Double nota = notas[semestre][i];
                    if (nota != null) {
                        sumaNotas += nota;
                        contadorNotas++;
                    }
                }
            }

            if (contadorNotas > 0) {
                System.out.println(
                        "  Promedio notas materia: " +
                                String.format("%.2f", sumaNotas / contadorNotas));
            } else {
                System.out.println(
                        "  Promedio notas materia: N/A");
            }
        }
    }
}
