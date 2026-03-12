public class repositorio {
    private string nombre;
    private date fechaCreacion;
    private rama ramaPrincipal;

    public repositorio(string nombre, date fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.ramaPrincipal = new ramaPrincipal("main", fechaCreacion);
    }

    public rama crearRama(String nombre) {
        return new ramaDerivada(nombre, new date(), ramaPrincipal);
    }

    public rama buscarRama(String nombre) {
        if (ramaPrincipal.getNombre().equals(nombre)) {
            return ramaPrincipal;
        }
        return null; // Aquí podrías extender para buscar en una lista de ramas
    }   
}

