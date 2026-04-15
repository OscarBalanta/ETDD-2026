import java.util.*;
class ContenedorBuque {
    private String nombre;
    private String codigo;
    private String origen;

    public ContenedorBuque(String nombre, String codigo, String origen) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.origen = origen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public String toString() {
        return "Buque{ nombre=" + nombre + ", codigo=" + codigo + ", origen=" + origen + " }";
    }
}

class Contenedor {
    private String codigo;
    private double peso;
    private String origen;
    private int prioridad;

    public Contenedor(String codigo, double peso, String origen, int prioridad) {
        this.codigo = codigo;
        this.peso = peso;
        this.origen = origen;
        this.prioridad = prioridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getOrigen() {
        return origen;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Contenedor{ codigo=" + codigo + ", peso=" + peso + ", origen=" + origen + ", prioridad=" + prioridad + " }";
    }
}

