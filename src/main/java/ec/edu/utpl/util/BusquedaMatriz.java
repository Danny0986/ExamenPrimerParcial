package ec.edu.utpl.util;

public class BusquedaMatriz extends Thread {

    private String[] fila;
    private String palabra;
    private static int total = 0;

    public BusquedaMatriz(String[] fila, String palabra) {
        this.fila = fila;
        this.palabra = palabra;
    }

    @Override
    public void run() {

        int coincidencias = 0;

        try {

            for (int i = 0; i < fila.length; i++) {

                if (fila[i].equalsIgnoreCase(palabra)) {
                    coincidencias++;
                }
            }

            synchronized (BusquedaMatriz.class) {
                total += coincidencias;
            }

            System.out.println(getName()
                    + " finalizó su búsqueda. Coincidencias encontradas: "
                    + coincidencias);

        } catch (Exception e) {

            System.out.println("Error durante la búsqueda en el hilo: "
                    + getName());
        }
    }

    public static int getTotal() {
        return total;
    }
}