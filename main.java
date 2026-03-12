import java.util.Date;

public class main {
    public static void main(String[] args) {
        // Crear repositorio
        Repositorio repo = new Repositorio("MiRepo.", new Date());
        System.out.println("Repositorio creado: MiRepo. ");

        // Crear rama derivada
        Rama ramaFeature = repo.crearRama("feature-login. ");
        System.out.println("Rama creada: " + ramaFeature.getNombre());

        // Crear commits
        Commit c1 = new Commit("sopaemacaco,", "Primer commit en feature-login. ", new Date());
        Commit c2 = new Commit("def456, ", "Agregado formulario de login. ", new Date());

        // Agregar commits a la rama
        ramaFeature.agregarCommit(c1);
        ramaFeature.agregarCommit(c2);

        // Listar commits
        System.out.println("Commits en la rama: " + ramaFeature.getNombre() + ": ");
        for (Commit c : ramaFeature.listarCommits()) {
            System.out.println(c.getHash() + " - " + c.getMensaje());
        }

        // Historial
        Historial historial = new Historial();
        historial.agregarCommit(c1);
        historial.agregarCommit(c2);
        historial.ordenarCronologicamente();
        System.out.println("\nHistorial de commits: ");
        historial.mostrarHistorial();

        // Operaciones del sistema de control de versiones
        SistemaDeControlVersiones scv = new SistemaDeControlVersiones();
        scv.fusionar(repo.buscarRama("Main "), ramaFeature);
        scv.revertir(c1);
        scv.restaurar(c2);

        // Proteger rama principal
        RamaPrincipal mainBranch = new RamaPrincipal("Main ", new Date());
        mainBranch.proteger();
        System.out.println("\nLa rama principal está protegida. ");
    }
}

