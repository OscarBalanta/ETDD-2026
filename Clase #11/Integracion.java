import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Integracion {
    private Map<String, LinkedList<String>> pedidos;

    public Integracion() {
        pedidos = new HashMap<>();
        pedidos.put("Ana", new LinkedList<>());
        pedidos.get("Ana").add("Camisa");
        pedidos.get("Ana").add("Pantalon");
        pedidos.put("Luis", new LinkedList<>());
        pedidos.get("Luis").add("Zapatos");
    } 





    public static void main(String[] args) {
        Integracion integracion = new Integracion();
        System.out.println(integracion.pedidos.get("Ana").size() + " pedidos de Ana");
        System.out.println(integracion.pedidos.get("Luis").size() + " pedidos de Luis");
        
    }

    

}
