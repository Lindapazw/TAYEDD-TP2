import java.util.LinkedList;

public class TablaHash {
    private static final int SIZE = 10;
    private Integer[] tablaLineal;
    private Integer[] tablaCuadratica;
    private LinkedList<Integer>[] tablaAbierta;

    // Constructor para inicializar las estructuras de la tabla hash
    public TablaHash() {
        tablaLineal = new Integer[SIZE];
        tablaCuadratica = new Integer[SIZE];
        tablaAbierta = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tablaAbierta[i] = new LinkedList<>(); // Inicialización de listas enlazadas para hashing abierto
        }
    }

    // Función hash H(x) = x mod SIZE
    public int hash(int key) {
        return key % SIZE;
    }

    // Método para insertar un elemento utilizando el método de colisión especificado
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

    // Método para buscar un elemento utilizando el método de colisión especificado
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

    // Método para eliminar un elemento utilizando el método de colisión especificado
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
    public void insertarLineal(int key) {
        int index = hash(key);
        while (tablaLineal[index] != null) {
            index = (index + 1) % SIZE;
        }
        tablaLineal[index] = key;
    }

    // Inserción con Sondeo Cuadrático
    public void insertarCuadratico(int key) {
        int index = hash(key);
        int i = 1;
        while (tablaCuadratica[index] != null) {
            index = (index + i * i) % SIZE;
            i++;
        }
        tablaCuadratica[index] = key;
    }

    // Inserción con Hashing Abierto (Lista Enlazada)
    public void insertarAbierto(int key) {
        int index = hash(key);
        // Verificar si el elemento ya existe para evitar duplicados
        if (!tablaAbierta[index].contains(key)) {
            tablaAbierta[index].add(key);
        }
    }

    // Búsqueda con Sondeo Lineal
    public Integer buscarLineal(int key) {
        int index = hash(key);
        int startIndex = index;
        while (tablaLineal[index] != null) {
            if (tablaLineal[index].equals(key)) {
                return tablaLineal[index];
            }
            index = (index + 1) % SIZE;
            if (index == startIndex) {
                break; // Evita bucles infinitos
            }
        }
        return null;
    }

    // Búsqueda con Sondeo Cuadrático
    public Integer buscarCuadratico(int key) {
        int index = hash(key);
        int i = 1;
        int startIndex = index;
        while (tablaCuadratica[index] != null) {
            if (tablaCuadratica[index].equals(key)) {
                return tablaCuadratica[index];
            }
            index = (startIndex + i * i) % SIZE;
            i++;
            if (index == startIndex) {
                break; // Evita bucles infinitos
            }
        }
        return null;
    }

    // Búsqueda con Hashing Abierto
    public Integer buscarAbierto(int key) {
        int index = hash(key);
        for (Integer value : tablaAbierta[index]) {
            if (value.equals(key)) {
                return value;
            }
        }
        return null;
    }

    // Eliminación con Sondeo Lineal
    public void eliminarLineal(int key) {
        int index = hash(key);
        int startIndex = index;
        while (tablaLineal[index] != null) {
            if (tablaLineal[index].equals(key)) {
                tablaLineal[index] = null;
                return;
            }
            index = (index + 1) % SIZE;
            if (index == startIndex) {
                break;
            }
        }
    }

    // Eliminación con Sondeo Cuadrático
    public void eliminarCuadratico(int key) {
        int index = hash(key);
        int i = 1;
        int startIndex = index;
        while (tablaCuadratica[index] != null) {
            if (tablaCuadratica[index].equals(key)) {
                tablaCuadratica[index] = null;
                return;
            }
            index = (startIndex + i * i) % SIZE;
            i++;
            if (index == startIndex) {
                break;
            }
        }
    }

    // Eliminación con Hashing Abierto
    public void eliminarAbierto(int key) {
        int index = hash(key);
        tablaAbierta[index].removeIf(value -> value.equals(key));
    }

    // Método adicional para imprimir la tabla hash completa
    public void imprimirTabla() {
        System.out.println("Tabla Hash con Sondeo Lineal:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + ": " + (tablaLineal[i] == null ? "vacío" : tablaLineal[i]));
        }

        System.out.println("\nTabla Hash con Sondeo Cuadrático:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + ": " + (tablaCuadratica[i] == null ? "vacío" : tablaCuadratica[i]));
        }

        System.out.println("\nTabla Hash con Hashing Abierto:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + ": " + tablaAbierta[i]);
        }
    }
}
