package ec.edu.utpl;

import ec.edu.utpl.util.BusquedaMatriz;

public class App {

    public static void main(String[] args) throws InterruptedException {

        String[][] matriz = {
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        String palabraBuscar = "Java";

        System.out.println("Iniciando Busqueda concurrente del termino: "+palabraBuscar);

        BusquedaMatriz hilo1 = new BusquedaMatriz(matriz[0], palabraBuscar);
        BusquedaMatriz hilo2 = new BusquedaMatriz(matriz[1], palabraBuscar);
        BusquedaMatriz hilo3 = new BusquedaMatriz(matriz[2], palabraBuscar);


        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        System.out.println("Resultado Total: La palabra " + palabraBuscar +" aparece " + BusquedaMatriz.getTotal() + " veces");
    }
}