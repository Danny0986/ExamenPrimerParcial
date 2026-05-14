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
        int contador = 0;
        for (String elemento : fila) {
            if (elemento.equals(palabra)) {
                contador++;
            }
        }
        synchronized (BusquedaMatriz.class) {
            total += contador;
        }
        System.out.println(Thread.currentThread().getName() + " finalizado - Encontrados: " + contador);
    }

    public static int getTotal() {
        return total;
    }
}
