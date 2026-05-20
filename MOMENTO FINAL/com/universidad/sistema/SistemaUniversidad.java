package com.universidad.sistema;

import java.util.HashMap;

import com.universidad.modelo.*;
import com.universidad.estructuras.GestorDeshacer;
import com.universidad.procesos.ProcesadorInscripciones;

public class SistemaUniversidad {

    
    private HashMap<String, Estudiante> estudiantes;

    private HashMap<String, Materia> materias;

    
    private GestorDeshacer gestor;

    private ProcesadorInscripciones procesador;

    public SistemaUniversidad() {

        estudiantes = new HashMap<>();

        materias = new HashMap<>();

        gestor = new GestorDeshacer();

        procesador =
                new ProcesadorInscripciones(this);
    }

    
    public void registrarEstudiante(
            Estudiante estudiante) {

        estudiantes.put(
                estudiante.getId(),
                estudiante);
    }

    
    public void registrarMateria(
            Materia materia) {

        materias.put(
                materia.getCodigo(),
                materia);
    }

    
    public Estudiante buscarEstudiante(
            String id) {

        return estudiantes.get(id);
    }

  
    public Materia buscarMateria(
            String codigo) {

        return materias.get(codigo);
    }

    
    public ProcesadorInscripciones
    getProcesador() {

        return procesador;
    }

    public GestorDeshacer
    getGestor() {

        return gestor;
    }


   public HashMap<String, Estudiante>
getEstudiantes() {

    return estudiantes;
}

public HashMap<String, Materia>
getMaterias() {

    return materias;
}
}
