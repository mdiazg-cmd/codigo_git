import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Historial {
    private List<Commit> listaCommits = new ArrayList<>();

    public void agregarCommit(Commit c) {
        listaCommits.add(c);
    }

    public void ordenarCronologicamente() {
        listaCommits.sort(Comparator.comparing(Commit::getFecha));
    }

    public void mostrarHistorial() {
        for (Commit c : listaCommits) {
            System.out.println(c.getFecha() + ", Usuario: " + c.getAutor() + " - " + c.getMensaje());
        }
    }
}
