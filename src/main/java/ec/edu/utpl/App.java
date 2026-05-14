package ec.edu.utpl;

import ec.edu.utpl.util.BusquedaMatriz;

public class App {

    public static void main(String[] args) {

        try {

            String[][] matriz = {
                    {"Java", "Python", "Java"},
                    {"C++", "Java", "Go"},
                    {"Java", "Rust", "Java"}
            };

            String palabraBuscar = "Java";

            System.out.println("========================================");
            System.out.println("BÚSQUEDA CONCURRENTE EN MATRIZ");
            System.out.println("Palabra objetivo: " + palabraBuscar);
            System.out.println("========================================");

            BusquedaMatriz hilo1 =
                    new BusquedaMatriz(matriz[0], palabraBuscar);

            BusquedaMatriz hilo2 =
                    new BusquedaMatriz(matriz[1], palabraBuscar);

            BusquedaMatriz hilo3 =
                    new BusquedaMatriz(matriz[2], palabraBuscar);

            hilo1.start();
            hilo2.start();
            hilo3.start();

            hilo1.join();
            hilo2.join();
            hilo3.join();

            System.out.println("----------------------------------------");
            System.out.println("RESULTADO TOTAL");
            System.out.println("La palabra \"" + palabraBuscar
                    + "\" aparece "
                    + BusquedaMatriz.getTotal()
                    + " veces en la matriz.");

        } catch (InterruptedException e) {

            System.out.println("La ejecución de los hilos fue interrumpida.");
        }
    }
}