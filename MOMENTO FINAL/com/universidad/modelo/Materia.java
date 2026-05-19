package com.universidad.modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Materia {

    
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int creditos;

    
    private LinkedList<Materia> prerequisitos;

    
    private Queue<Estudiante> colaEspera;

    public Materia(String codigo, String nombre,
                   int cuposMaximos, int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.creditos = creditos;

        
        this.prerequisitos = new LinkedList<>();
        this.colaEspera = new ArrayDeque<>();
    }

    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public int getCreditos() {
        return creditos;
    }

    public LinkedList<Materia> getPrerequisitos() {
        return prerequisitos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    
    public void agregarPrerequisito(Materia materia) {
        prerequisitos.add(materia);
    }

    
    public boolean hayCupo() {
        return cuposDisponibles > 0;
    }

    
    public void inscribirEstudiante() {

        if (cuposDisponibles > 0) {
            cuposDisponibles--;
        }
    }

    
    public void liberarCupo() {

        if (cuposDisponibles < cuposMaximos) {
            cuposDisponibles++;
        }
    }

    
    public void agregarACola(Estudiante estudiante) {
        colaEspera.offer(estudiante);
    }
}