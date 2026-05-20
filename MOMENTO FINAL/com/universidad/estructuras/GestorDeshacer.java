package com.universidad.estructuras;

import com.universidad.acciones.Accion;
import com.universidad.acciones.AccionInscribir;

import java.util.Stack;

public class GestorDeshacer {

    
    private Stack<Accion> pilaDeshacer;
    private Stack<Accion> pilaRehacer;

    
    public GestorDeshacer() {

        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();
    }

    
    public void ejecutarAccion(Accion accion) {

        accion.ejecutar();

        pilaDeshacer.push(accion);

        pilaRehacer.clear();
    }

    
    public void deshacer() {

        if (!pilaDeshacer.isEmpty()) {

            Accion accion = pilaDeshacer.pop();

            accion.deshacer();

            pilaRehacer.push(accion);
        }
    }

   
    public void rehacer() {

        if (!pilaRehacer.isEmpty()) {

            Accion accion = pilaRehacer.pop();

            accion.ejecutar();

            pilaDeshacer.push(accion);
        }
    }


    public void guardarAccion(AccionInscribir accion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarAccion'");
    }
}
