
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