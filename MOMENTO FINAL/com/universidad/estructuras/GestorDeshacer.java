package com.universidad.estructuras;

import com.universidad.acciones.Accion;

import java.util.Stack;

public class GestorDeshacer {

    private Stack<Accion> acciones;

    // CONSTRUCTOR
    public GestorDeshacer() {

        acciones = new Stack<>();
    }

    // GUARDAR ACCION
    public void guardarAccion(
            Accion accion) {

        acciones.push(accion);
    }

    // DESHACER
    public void deshacer() {

        if (!acciones.isEmpty()) {

            Accion accion =
                    acciones.pop();

            accion.deshacer();
        }
    }
}