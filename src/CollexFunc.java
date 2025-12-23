import java.util.ArrayList;

public class CollexFunc {

    private ArrayList<Categoria> categorias;
    private ArrayList<Movimento> movimentos;
    private ArrayList<Contacto> contactos;

    public CollexFunc() {
        categorias = new ArrayList<>();
        movimentos = new ArrayList<>();
        contactos = new ArrayList<>();
    }

    public void adicionarCategoria(Categoria c) {
        categorias.add(c);
    }

    public void adicionarMovimento(Movimento m) {
        movimentos.add(m);
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Movimento> getMovimentos() {
        return movimentos;
    }
}
