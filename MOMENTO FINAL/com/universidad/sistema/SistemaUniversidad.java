package com.universidad.sistema;

import java.util.HashMap;
import java.util.TreeMap;

import com.universidad.modelo.Aula;
import com.universidad.modelo.Estudiante;
import com.universidad.modelo.Materia;

public class SistemaUniversidad {

    
    private HashMap<String, Estudiante> estudiantes;
    private HashMap<String, Materia> materias;
    private TreeMap<String, Aula> aulas;

    
    public SistemaUniversidad() {

        estudiantes = new HashMap<>();
        materias = new HashMap<>();
        aulas = new TreeMap<>();
    }

    
    public void registrarEstudiante(Estudiante estudiante) {

        estudiantes.put(estudiante.getId(), estudiante);
    }

    
    public Estudiante buscarEstudiante(String id) {

        return estudiantes.get(id);
    }

    
    public void registrarMateria(Materia materia) {

        materias.put(materia.getCodigo(), materia);
    }

    
    public Materia buscarMateria(String codigo) {

        return materias.get(codigo);
    }

    
    public void registrarAula(Aula aula) {

        aulas.put(aula.getNombre(), aula);
    }

    
    public Aula buscarAula(String nombre) {

        return aulas.get(nombre);
    }
}
