package com.universidad.reportes;

import java.util.TreeMap;

import com.universidad.modelo.Estudiante;

public class GestorReportes {

    private TreeMap<String, Estudiante>
            estudiantesOrdenados;


    public GestorReportes() {

        estudiantesOrdenados =
                new TreeMap<>();
    }

    
    public void agregarEstudiante(
            Estudiante estudiante) {

        estudiantesOrdenados.put(
                estudiante.getId(),
                estudiante);
    }

     // Ordenador de los EStudiantes por su IDD UniVersitaria
    public void mostrarEstudiantes() {

        for (String id :
                estudiantesOrdenados.keySet()) {

            Estudiante e =
                    estudiantesOrdenados.get(id);

            System.out.println(
                    id + " - " +
                    e.getNombre());
        }
    }
}
