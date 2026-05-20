import com.universidad.sistema.SistemaUniversidad;
import com.universidad.util.CargadorDatos;
import com.universidad.reportes.GeneradorReportes;

public class Main {

    public static void main(String[] args) {

        System.out.println("INICIANDO MAIN");

        // PROBAR SI EL ARCHIVO EXISTE
        java.io.File archivo =
                new java.io.File(
                        "/workspaces/ETDD-2026/MOMENTO FINAL/datos/estudiantes.csv");

        System.out.println(
                "¿Existe archivo?: "
                        + archivo.exists());

        // CREAR SISTEMA
        SistemaUniversidad sistema =
                new SistemaUniversidad();

        // CARGAR ESTUDIANTES
        CargadorDatos.cargarEstudiantes(
                "/workspaces/ETDD-2026/MOMENTO FINAL/datos/estudiantes.csv",
                sistema);

        // CARGAR MATERIAS
        CargadorDatos.cargarMaterias(
                "/workspaces/ETDD-2026/MOMENTO FINAL/datos/materias.csv",
                sistema);

        // CARGAR SOLICITUDES
        CargadorDatos.cargarSolicitudes(
                "/workspaces/ETDD-2026/MOMENTO FINAL/datos/solicitudes.csv",
                sistema);

        // PROCESAR SOLICITUDES
        sistema.getProcesador()
                .procesarSolicitudes();

        // REPORTES
        System.out.println(
                "\n=== ESTUDIANTES ===");

        GeneradorReportes
                .mostrarEstudiantes(
                        sistema.getEstudiantes());

        System.out.println(
                "\n=== MATERIAS ===");

        GeneradorReportes
                .mostrarMaterias(
                        sistema.getMaterias());

        // DESHACER
        System.out.println(
                "\n=== DESHACER ===");

        sistema.getGestor()
                .deshacer();
    }
}