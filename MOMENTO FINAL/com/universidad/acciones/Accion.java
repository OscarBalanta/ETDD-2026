package com.universidad.acciones;

public abstract class Accion {

    
    protected String descripcion;

    
    public Accion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    
    public abstract void ejecutar();

    public abstract void deshacer();
}
