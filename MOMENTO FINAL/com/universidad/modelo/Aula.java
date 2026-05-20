package com.universidad.modelo;

public class Aula {

    
    private String nombre;
    private boolean[][] horario;

    
    public Aula(String nombre) {

        this.nombre = nombre;  

        
        this.horario = new boolean[7][24];
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public boolean consultarDisponibilidad(int dia, int hora) {

        return !horario[dia][hora];
    }

    
    public boolean reservar(int dia, int hora, int duracion) {

        // VERIFICAR DISPONIBILIDAD
        for (int i = hora; i < hora + duracion; i++) {

            if (horario[dia][i]) {
                return false;
            }
        }

        
        for (int i = hora; i < hora + duracion; i++) {

            horario[dia][i] = true;
        }

        return true;
    }

    
    public void liberar(int dia, int hora, int duracion) {

        for (int i = hora; i < hora + duracion; i++) {

            horario[dia][i] = false;
        }
    }
}
