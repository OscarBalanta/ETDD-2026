package com.universidad.acciones;

import com.universidad.modelo.Estudiante;
import com.universidad.modelo.Materia;

public class AccionInscribir extends Accion {

    private Estudiante estudiante;
    private Materia materia;

    
    public AccionInscribir(Estudiante estudiante,
                           Materia materia) {

        super("Inscripción de estudiante");

        this.estudiante = estudiante;
        this.materia = materia;
    }

    
    @Override
    public void ejecutar() {

        materia.inscribirEstudiante();
    }

    
    @Override
    public void deshacer() {

        materia.liberarCupo();
    }
}
