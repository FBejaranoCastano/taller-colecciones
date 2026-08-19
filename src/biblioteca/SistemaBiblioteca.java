package biblioteca;

import java.util.*;

public class SistemaBiblioteca {

    private final Map<String, Material> catalogo = new HashMap<> ();
    private final Map<String, List<String>> listaEspera = new HashMap<> ();
    private final Set<String> miembros = new HashSet<> ();

    public void registrarMaterial (Material m) {
        if ( m != null && m.getCodigo () != null ) {
            catalogo.put (m.getCodigo ().toUpperCase (), m);
        }
    }

    public Material buscarMaterial (String codigo) {
        if ( codigo == null || codigo.trim ().isEmpty () ) {
            return null;
        }
        return catalogo.get (codigo.toUpperCase ());
    }

    public void buscarYMostrar (String codigo) {
        if ( codigo == null || codigo.trim ().isEmpty () ) {
            System.out.println ("Error: Debes ingresar un código válido (no se permiten búsquedas en blanco).");
            return;
        }

        Material material = buscarMaterial (codigo);

        if ( material != null ) {
            material.mostrarInformacion ();
        } else {
            System.out.println ("El material con el código '" + codigo + "' no existe en el catálogo.");
        }
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

    // Registra un miembro. Retorna true si era nuevo y false si ya existía
    public boolean registrarMiembro (String usuario) {
        return miembros.add (usuario);
    }

    // Verifica si un usuario pertenece al conjunto de miembros
    public boolean tieneMembresia (String usuario) {
        return miembros.contains (usuario);
    }
}
