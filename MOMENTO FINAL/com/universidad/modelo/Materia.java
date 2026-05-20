package com.universidad.modelo;

import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    private String codigo;
    private String nombre;

    private int cupos;
    private int creditos;

    private int inscritos;

   
    private Queue<Estudiante> colaEspera;

    // CONSTRUCTOR
    public Materia(
            String codigo,
            String nombre,
            int cupos,
            int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;

        this.cupos = cupos;
        this.creditos = creditos;

        inscritos = 0;

        colaEspera =
                new LinkedList<>();
    }

    
    public void inscribirEstudiante() {

        if (hayCupo()) {

            inscritos++;
        }
    }

   
    public void cancelarInscripcion() {

        if (inscritos > 0) {

            inscritos--;
        }
    }

   
    public boolean hayCupo() {

        return inscritos < cupos;
    }

    
    public void agregarACola(
            Estudiante estudiante) {

        colaEspera.offer(estudiante);
    }

    
    public String getCodigo() {

        return codigo;
    }

    public String getNombre() {

        return nombre;
    }

    public int getCupos() {

        return cupos;
    }

    public int getCreditos() {

        return creditos;
    }

    public int getInscritos() {

        return inscritos;
    }
}