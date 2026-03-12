import java.util.*;

class Repositorio {
    private String nombre;
    private Date fechaCreacion;
    private Rama ramaPrincipal;

    public Repositorio(String nombre, Date fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.ramaPrincipal = new RamaPrincipal("Main ", fechaCreacion);
    }

    public Rama crearRama(String nombre) {
        return new RamaDerivada(nombre, new Date(), ramaPrincipal);
    }

    public Rama buscarRama(String nombre) {
        if (ramaPrincipal.getNombre().equals(nombre)) {
            return ramaPrincipal;
        }
        return null; // Aquí podrías extender para buscar en una lista de ramas
    }
}

class Rama {
    protected String nombre;
    protected Date fechaCreacion;
    protected List<Commit> commits;

    public Rama(String nombre, Date fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.commits = new ArrayList<>();
    }

    public void agregarCommit(Commit c) {
        commits.add(c);
    }

    public List<Commit> listarCommits() {
        return commits;
    }

    public String getNombre() {
        return nombre;
    }
}

class Commit {
    private String hash;
    private String mensaje;
    private Date fecha;

    public Commit(String hash, String mensaje, Date fecha) {
        this.hash = hash;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getHash() { return hash; }
    public String getMensaje() { return mensaje; }
    public Date getFecha() { return fecha; }
}

class Historial {
    private List<Commit> listaCommits = new ArrayList<>();

    public void agregarCommit(Commit c) {
        listaCommits.add(c);
    }

    public void ordenarCronologicamente() {
        listaCommits.sort(Comparator.comparing(Commit::getFecha));
    }

    public void mostrarHistorial() {
        for (Commit c : listaCommits) {
            System.out.println(c.getFecha() + " - " + c.getMensaje());
        }
    }
}

interface OperacionVersion {
    void fusion(Rama rama);
    void reversion(String id);
}

class SistemaDeControlVersiones {
    public void fusionar(Rama r1, Rama r2) {
        System.out.println("Fusionando ramas: " + r1.getNombre() + " con: " + r2.getNombre());
    }

    public void revertir(Commit c) {
        System.out.println("Revirtiendo commit: " + c.getHash());
    }

    public void restaurar(Commit c) {
        System.out.println("Restaurando commit: " + c.getHash());
    }
}

class RamaPrincipal extends Rama {
    private boolean esProtegida;

    public RamaPrincipal(String nombre, Date fechaCreacion) {
        super(nombre, fechaCreacion);
        this.esProtegida = false;
    }

    public void proteger() {
        esProtegida = true;
    }
}

class RamaDerivada extends Rama implements OperacionVersion {
    private Rama ramaOrigen;

    public RamaDerivada(String nombre, Date fechaCreacion, Rama ramaOrigen) {
        super(nombre, fechaCreacion);
        this.ramaOrigen = ramaOrigen;
    }

    @Override
    public void fusion(Rama rama) {
        System.out.println("Fusionando con rama: " + rama.getNombre());
    }

    @Override
    public void reversion(String id) {
        System.out.println("Revirtiendo commit con id: " + id);
    }
}

