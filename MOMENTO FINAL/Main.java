import com.universidad.sistema.SistemaUniversidad;
import com.universidad.util.CargadorDatos;
import com.universidad.reportes.GeneradorReportes;

public class Main {

    public static void main(String[] args) {

          // CREador del sistema universitario GENERALL
        SistemaUniversidad sistema =
                new SistemaUniversidad();

         // CaRgador del Datos desde Csv a University sistem
        CargadorDatos.cargarEstudiantes(
                "datos/estudiantes.csv",
                sistema);

        CargadorDatos.cargarMaterias(
                "datos/materias.csv",
                sistema);

                 // SOLicitudes de Inscripcion desde CSV
        CargadorDatos.cargarSolicitudes(
                "datos/solicitudes.csv",
                sistema);

        // PROCESAMIENTO de las solicitudes de inscripcion
        sistema.getProcesador()
                .procesarSolicitudes();

        
        System.out.println(
                "\n=== ESTUDIANTES ===");

        GeneradorReportes.mostrarEstudiantes(
                sistema.getEstudiantes());

        System.out.println(
                "\n=== MATERIAS ===");

        GeneradorReportes.mostrarMaterias(
                sistema.getMaterias());
                 
                    System.out.println(
                    "\n=== DESHACER ===");

            sistema.getGestor()
                    .deshacer();
    }
}
