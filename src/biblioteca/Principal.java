package biblioteca;

public class Principal {

    static void main (String[] args) {

        SistemaBiblioteca biblioteca = new SistemaBiblioteca ();

        // Objetos Libro
        Material libro1 = new Libro ("L001", "Cien Años de Soledad", 1967, "Gabriel García Márquez", "978-0307474728", true);
        Material libro2 = new Libro ("L002", "1984", 1949, "George Orwell", "978-0451524935", true);
        Material libro3 = new Libro ("L003", "Correo Lola Corre", 2000, "Desconocido", "978-0307474749", true);

        // Objetos Revista
        Material revista1 = new Revista ("R001", "National Geographic", 2023, 150, "Ciencia y Naturaleza", true);
        Material revista2 = new Revista ("R002", "Scientific American", 2024, 85, "Tecnología", true);

        biblioteca.registrarMaterial (libro1);
        biblioteca.registrarMaterial (libro2);
        biblioteca.registrarMaterial (libro3);
        biblioteca.registrarMaterial (revista1);
        biblioteca.registrarMaterial (revista2);

        IO.println ("***** Probando Buscar Material *****");
        biblioteca.buscarYMostrar ("l002");
        IO.println ("\n");
        IO.println ("***** Prueba Lista De Espera *****");
        String codigo = "r002";
        Material material = biblioteca.buscarMaterial (codigo);
        if ( material != null ) {
            material.setDisponible (false);
            IO.println ("El estado de " + material.getTitulo () + " ha sido cambiado a 'prestado'.");
        }

        biblioteca.agregarEspera (codigo, "usuario1");
        biblioteca.agregarEspera (codigo, "usuario2");
        biblioteca.agregarEspera (codigo, "usuario3");

        System.out.println ("1.ª persona en salir de espera: " + biblioteca.siguienteEnEspera (codigo));
        System.out.println ("2.ª persona en salir de espera: " + biblioteca.siguienteEnEspera (codigo));

        System.out.println ("***** PRUEBA DE MEMBRESIAS  *****");

        boolean reg1 = biblioteca.registrarMiembro ("Carlos");
        boolean reg2 = biblioteca.registrarMiembro ("Ana");
        boolean reg3 = biblioteca.registrarMiembro ("Sofía");

        System.out.println ("Registro 'Carlos' exitoso?: " + reg1);
        System.out.println ("Registro 'Ana' exitoso?: " + reg2);
        System.out.println ("Registro 'Sofía' exitoso?: " + reg3);

// Intentar registrar el mismo usuario dos veces
        boolean regDuplicado = biblioteca.registrarMiembro ("Carlos");
        System.out.println ("Registro 'Carlos' de nuevo exitoso?: " + regDuplicado);

//  Verificar membresía de un usuario REGISTRADO y uno QUE NO EXISTE
        boolean existeAna = biblioteca.tieneMembresia ("Ana");
        boolean existePedro = biblioteca.tieneMembresia ("Pedro");

        System.out.println ("¿'Ana' tiene membresía?: " + existeAna);
        System.out.println ("¿'Pedro' tiene membresía?: " + existePedro);
        IO.println ("\n");
        IO.println ("***** MOSTRANDO CATALOGO COMPLETO *****");
        biblioteca.mostrarCatalogo ();

    }

}
