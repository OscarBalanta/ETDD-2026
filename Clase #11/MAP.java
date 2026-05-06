import java.util.HashMap;

public class MAP {

     HashMap<String, String> mapa;
    
    public  MAP() {

       mapa = new HashMap<>();
        mapa.put("101", "Laptop");
        mapa.put("102", "Mouse");
        mapa.put("103", "Teclado");
         mapa.put("101", "PC");

    }

    public void verificarClave(String clave) {
        if (mapa.containsKey(clave)) {
            System.out.println("La clave " + clave + " Existe en el mapa.");
        } else {
            System.out.println("La clave " + clave + " No existe  en el mapa.");
        }
    }

    public static void main(String[] args) {
        MAP mapa = new MAP();
        mapa.verificarClave("103");
        mapa.verificarClave("104");
        
    } 

    


}
