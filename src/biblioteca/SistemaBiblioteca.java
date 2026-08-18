package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaBiblioteca {

    private final Map<String, Material> catalogo = new HashMap<> ();
    private final Map<String, List<String>> listaEspera = new HashMap<> ();

    public void registrarMaterial (Material material) {
        catalogo.put (material.getCodigo (), material);
    }

    public Material buscarMaterial (String codigo) {
        return catalogo.get (codigo);
    }

    public void mostrarCatalogo () {
        for ( Map.Entry<String, Material> entry : catalogo.entrySet () ) {
            entry.getValue ().mostrarInformacion ();
        }
    }

    public void agregarEspera (String codigoMaterial, String usuario) {
        if ( ! listaEspera.containsKey (codigoMaterial) ) {
            listaEspera.put (codigoMaterial, new ArrayList<> ());
        }
        listaEspera.get (codigoMaterial).add (usuario);
    }

    // Retorna y remueve al primer usuario en la fila (FIFO)
    public String siguienteEnEspera (String codigoMaterial) {
        List<String> espera = listaEspera.get (codigoMaterial);

        if ( espera != null && ! espera.isEmpty () ) {
            return espera.remove (0);
        }
        return null;
    }
}
