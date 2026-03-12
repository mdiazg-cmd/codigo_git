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