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
