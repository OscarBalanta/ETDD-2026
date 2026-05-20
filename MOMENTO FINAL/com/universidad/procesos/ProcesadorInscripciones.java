package com.universidad.procesos;

import com.universidad.modelo.*;
import com.universidad.validacion.ValidadorInscripcion;
import com.universidad.sistema.SistemaUniversidad;
import com.universidad.acciones.AccionInscribir;


import java.util.Queue;
import java.util.ArrayDeque;

public class ProcesadorInscripciones {

    
    private Queue<SolicitudInscripcion> colaSolicitudes;

    
    private SistemaUniversidad sistema;

    
    public ProcesadorInscripciones(SistemaUniversidad sistema) {

        this.sistema = sistema;

        colaSolicitudes = new ArrayDeque<>();
    }

    
    public void agregarSolicitud(SolicitudInscripcion solicitud) {

        colaSolicitudes.offer(solicitud);
    }

    
    public void procesarSolicitudes() {

        while (!colaSolicitudes.isEmpty()) {

            
            SolicitudInscripcion solicitud =
                    colaSolicitudes.poll();

            
            Estudiante estudiante =
                    sistema.buscarEstudiante(
                            solicitud.getIdEstudiante());

            Materia materia =
                    sistema.buscarMateria(
                            solicitud.getCodigoMateria());

                        if (ValidadorInscripcion.validar(
                            estudiante,
                            materia)) {

                            materia.inscribirEstudiante();

                             //accion Guardadita para el deshacer
                            AccionInscribir accion =
                                    new AccionInscribir(
                                            estudiante,
                                            materia);

                            sistema.getGestor()
                                    .guardarAccion(accion);

                            System.out.println("Inscripción realizada");
                        }
                     

            else {

                materia.agregarACola(estudiante);

                System.out.println(
                        "Estudiante enviado a cola");
            }
        }
    }
}
