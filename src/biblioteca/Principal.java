package biblioteca;

public class Principal {

    static void main (String[] args) {

        Material libro1 = new Libro ("123", "Cien años de soledad", 2015, "Gabriel Garcia Marquez", "978-84-8484-8484",
                true);
        libro1.mostrarInformacion ();
        System.out.println ("****************************************************");
        Material libro2 = new Libro ("456", "El prisionero de Azkaban", 2002, "J.R.R. Tolkien", "978-84-8484-8484",
                false);
        libro2.mostrarInformacion ();
        System.out.println ("****************************************************");
        Material libro3 = new Libro ("789", "La piedra filosofal", 1998, "Jorge Luis Borges", "978-84-8484-8484",
                true);
        libro3.mostrarInformacion ();
        IO.println ("\n");

        Material revista = new Revista ("321", "FoxSports", 2025, 2, "Deportes", true);
        revista.mostrarInformacion ();
        System.out.println ("****************************************************");
        Material revista2 = new Revista ("654", "El mundo", 2025, 2, "Ciencia", false);
        revista2.mostrarInformacion ();
        System.out.println ("****************************************************");
        Material revista3 = new Revista ("987", "Discovery", 2025, 2, "Ciencia", true);
        revista3.mostrarInformacion ();

    }

}
