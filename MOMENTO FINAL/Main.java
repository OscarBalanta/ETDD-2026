import com.universidad.sistema.SistemaUniversidad;
import com.universidad.util.CargadorDatos;
import com.universidad.reportes.GeneradorReportes;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("INICIANDO MAIN");

        System.out.println("\n=== CARGA DE DATOS ===");

        java.io.File archivo =
                new java.io.File(
                        "/workspaces/ETDD-2026/MOMENTO FINAL/datos/estudiantes.csv");

        System.out.println(
                "Archivo estudiantes encontrado: "
                        + archivo.exists());

        SistemaUniversidad sistema =
                new SistemaUniversidad();

        CargadorDatos.cargarEstudiantes(
                "/workspaces/ETDD-2026/MOMENTO FINAL/datos/estudiantes.csv",
                sistema);

        CargadorDatos.cargarMaterias(
                "/workspaces/ETDD-2026/MOMENTO FINAL/datos/materias.csv",
                sistema);

        CargadorDatos.cargarSolicitudes(
                "/workspaces/ETDD-2026/MOMENTO FINAL/datos/solicitudes.csv",
                sistema);

        System.out.println(
                "Estudiantes cargados: " +
                        sistema.getEstudiantes().size());
        System.out.println(
                "Materias cargadas: " +
                        sistema.getMaterias().size());

        System.out.println("\n=== PROCESAR SOLICITUDES ===");

        sistema.getProcesador()
                .procesarSolicitudes();

        System.out.println("Procesamiento finalizado.");

        // AGREGAR A LAS MATERIAS
        asignarNotasEjemplo(sistema);

        System.out.println("\n=== REPORTES ===");

        System.out.println("\n--- ESTUDIANTES ---");

        GeneradorReportes
                .mostrarEstudiantes(
                        sistema.getEstudiantes());

        System.out.println("\n--- MATERIAS ---");

        GeneradorReportes
                .mostrarMaterias(
                        sistema.getMaterias(),
                        sistema.getEstudiantes());

        System.out.println("\n--- PROMEDIO DE SEMESTRE ---");

        System.out.printf(
                "Promedio de semestre estudiantes: %.2f%n",
                calcularPromedioSemestre(
                        sistema.getEstudiantes()));

        System.out.println("\n=== DESHACER ===");

        sistema.getGestor()
                .deshacer();
    }

    private static void asignarNotasEjemplo(
            SistemaUniversidad sistema) {

        List<String> codigos =
                new ArrayList<>(
                        sistema.getMaterias().keySet());

        for (String id : sistema.getEstudiantes().keySet()) {

            var estudiante =
                    sistema.getEstudiantes().get(id);

            for (int i = 0;
                 i < codigos.size();
                 i++) {

                double nota = 60 + (i * 10) +
                        estudiante.getSemestre();

                estudiante.registrarNota(
                        estudiante.getSemestre(),
                        i,
                        nota);
            }
        }
    }

    private static double calcularPromedioSemestre(
            java.util.HashMap<String, com.universidad.modelo.Estudiante> estudiantes) {

        if (estudiantes.isEmpty()) {
            return 0;
        }

        double suma = 0;
        for (com.universidad.modelo.Estudiante estudiante : estudiantes.values()) {
            suma += estudiante.getSemestre();
        }

        return suma / estudiantes.size();
    }
}