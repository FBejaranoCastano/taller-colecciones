package biblioteca;

public class Libro extends Material {

    private  String autor;
    private final String SBN;

    public Libro (String codigo, String titulo, int anio, String autor, String SBN, boolean disponible) {
        super(codigo, titulo, anio, disponible);
        this.autor = autor;
        this.SBN = SBN;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }

}
