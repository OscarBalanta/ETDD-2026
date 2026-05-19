package com.universidad.modelo;

import java.util.LinkedList;

public class Estudiante extends Persona {

    private int semestre;
    private Double[][] notas;
    private LinkedList<Materia> historialMaterias;

    public Estudiante(String nombre, String id, String email, int semestre) {

        
        super(nombre, id, email);

        this.semestre = semestre;

       
        this.notas = new Double[10][20];

      
        this.historialMaterias = new LinkedList<>();
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public LinkedList<Materia> getHistorialMaterias() {
        return historialMaterias;
    }

    
    public void registrarNota(int semestre, int materia, double nota) {
        notas[semestre][materia] = nota;
    }

    
    public double calcularPromedio() {

        double suma = 0;
        int contador = 0;

        for (int i = 0; i < notas.length; i++) {

            for (int j = 0; j < notas[i].length; j++) {

                if (notas[i][j] != null) {

                    suma += notas[i][j];
                    contador++;
                }
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }

   
    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Semestre: " + getSemestre());
        System.out.println("Promedio: " + calcularPromedio());
    }
}