public class Commit {
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
