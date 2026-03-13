class SistemaDeControlVersiones {
    public void fusionar(Rama r1, Rama r2) {
        System.out.println("Fusionando ramas: " + r1.getNombre() + " con " + r2.getNombre());
    }

    public void revertir(Commit c) {
        System.out.println("Revirtiendo commit: " + c.getHash());
    }

    public void restaurar(Commit c) {
        System.out.println("Restaurando commit: " + c.getHash());
    }
}
