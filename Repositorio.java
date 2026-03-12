public class Repositorio {
    private String nombre;
    private Date fechaCreacion;
    private Rama ramaPrincipal;

    public Repositorio(String nombre, Date fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.ramaPrincipal = new RamaPrincipal("main", fechaCreacion);
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
