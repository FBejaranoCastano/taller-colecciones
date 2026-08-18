package biblioteca;

public abstract class Material implements Catalogable {

    private final String codigo;
    private final String titulo;
    private final int anio;
    private final boolean disponible;

    public Material (String codigo, String titulo, int anio, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = disponible;
    }

    @Override
    public String getCodigo () {
        return this.codigo;
    }

    public String getTitulo () {
        return this.titulo;
    }

    public int getAnio () {
        return this.anio;
    }

    public boolean isDisponible () {
        return this.disponible;
    }

    public abstract String getTipo();

    public void mostrarInformacion(){
        String estado = disponible ? "disponible" : "prestado";
        System.out.println("[" + getTipo() + "] " + titulo + " (" + anio + ") — " + estado);
    }
}
