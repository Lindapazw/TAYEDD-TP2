// TablaHash.java

import java.util.LinkedList;

public class TablaHash {
    private static final int SIZE = 10;
    private Integer[] tablaLineal;
    private Integer[] tablaCuadratica;
    private LinkedList<Integer>[] tablaAbierta;

    public TablaHash() {
        tablaLineal = new Integer[SIZE];
        tablaCuadratica = new Integer[SIZE];
        tablaAbierta = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tablaAbierta[i] = new LinkedList<>();
        }
    }

    public int hash(int key) {
        return key % SIZE;
    }

    // Método para insertar eligiendo el método de colisión
    public void insertar(int key, String metodoColision) {
        switch (metodoColision.toLowerCase()) {
            case "lineal":
                insertarLineal(key);
                break;
            case "cuadratico":
                insertarCuadratico(key);
                break;
            case "abierto":
                insertarAbierto(key);
                break;
            default:
                throw new IllegalArgumentException("Método de colisión no válido: " + metodoColision);
        }
    }

    // Método para buscar eligiendo el método de colisión
    public Integer buscar(int key, String metodoColision) {
        switch (metodoColision.toLowerCase()) {
            case "lineal":
                return buscarLineal(key);
            case "cuadratico":
                return buscarCuadratico(key);
            case "abierto":
                return buscarAbierto(key);
            default:
                throw new IllegalArgumentException("Método de colisión no válido: " + metodoColision);
        }
    }

    // Método para eliminar eligiendo el método de colisión
    public void eliminar(int key, String metodoColision) {
        switch (metodoColision.toLowerCase()) {
            case "lineal":
                eliminarLineal(key);
                break;
            case "cuadratico":
                eliminarCuadratico(key);
                break;
            case "abierto":
                eliminarAbierto(key);
                break;
            default:
                throw new IllegalArgumentException("Método de colisión no válido: " + metodoColision);
        }
    }

    // Inserción con Sondeo Lineal
    public void insertarLineal(int key) { /* ... */ }

    // Inserción con Sondeo Cuadrático
    public void insertarCuadratico(int key) { /* ... */ }

    // Inserción con Hashing Abierto (Lista Enlazada)
    public void insertarAbierto(int key) { /* ... */ }

    // Métodos de búsqueda y eliminación también están implementados, como ya tienes en tu código
}
