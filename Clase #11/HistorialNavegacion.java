import java.util.LinkedList;

public class HistorialNavegacion {
    
    LinkedList<String> historial;

    public HistorialNavegacion() {
      historial = new LinkedList<>();
      historial.add("github.com");
      historial.add("google.com");
      historial.add("youtube.com");
      historial.add("facebook.com");
    
      

    }

    

    public void removeLast() {
        if (!historial.isEmpty()) {
            System.out.println("Pagina eliminada: " + historial.removeLast());
        } else {
            System.out.println("El historial esta vacio.");
        }
    }

            public void mostrarhistorial() {
        System.out.println("HISTORIAL DE NAVEGACION:");
        for (String url : historial) {
            System.out.println(url);
        }
    }


    public static void main(String[] args) {
        
        HistorialNavegacion historialNavegacion = new HistorialNavegacion();
      
      
        historialNavegacion.mostrarhistorial();
        
        
        historialNavegacion.removeLast();
        





    
    }
}
