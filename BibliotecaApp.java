public class BibliotecaApp {
    public static void main(String[] args) {
       TablaHash tabla = new TablaHash();
 
       // Consigna a): Implementar la función hash H(x) = X mod 10
       System.out.println("Consigna a): Implementar la función hash H(x) = X mod 10");
       System.out.println("Prueba de función hash H(x) = X mod 10:");
       int[] keys = new int[]{115269, 111254, 222333};  // Ejemplos de códigos únicos
 
       for (int key : keys) {
          int index = tabla.hash(key);
          System.out.println("Hash de " + key + " es: " + index);
       }
 
       // Consigna b): Manejo de colisiones mediante sondeo lineal y cuadrático
       System.out.println("\nConsigna b): Manejo de colisiones mediante Sondeo Lineal y Sondeo Cuadrático");
       
       System.out.println("\nPruebas con Sondeo Lineal:");
       tabla.insertar(115269, "lineal");
       tabla.insertar(111254, "lineal");
       tabla.insertar(222333, "lineal");
       System.out.println("Buscar 115269 (debería estar): " + tabla.buscar(115269, "lineal"));
       System.out.println("Buscar 111254 (debería estar): " + tabla.buscar(111254, "lineal"));
       System.out.println("Buscar 333444 (no debería estar): " + tabla.buscar(333444, "lineal"));
       tabla.eliminar(115269, "lineal");
       System.out.println("Buscar 115269 (debería estar eliminado): " + tabla.buscar(115269, "lineal"));
 
       System.out.println("\nPruebas con Sondeo Cuadrático:");
       tabla.insertar(115269, "cuadratico");
       tabla.insertar(111254, "cuadratico");
       tabla.insertar(222333, "cuadratico");
       System.out.println("Buscar 115269 (debería estar): " + tabla.buscar(115269, "cuadratico"));
       System.out.println("Buscar 111254 (debería estar): " + tabla.buscar(111254, "cuadratico"));
       System.out.println("Buscar 333444 (no debería estar): " + tabla.buscar(333444, "cuadratico"));
       tabla.eliminar(115269, "cuadratico");
       System.out.println("Buscar 115269 (debería estar eliminado): " + tabla.buscar(115269, "cuadratico"));
 
       // Consigna c): Implementar el método de colisión basado en hashing abierto
       System.out.println("\nConsigna c): Manejo de colisiones mediante Hashing Abierto");
       tabla.insertar(115269, "abierto");
       tabla.insertar(111254, "abierto");
       tabla.insertar(222333, "abierto");
       System.out.println("Buscar 115269 (debería estar): " + tabla.buscar(115269, "abierto"));
       System.out.println("Buscar 111254 (debería estar): " + tabla.buscar(111254, "abierto"));
       System.out.println("Buscar 333444 (no debería estar): " + tabla.buscar(333444, "abierto"));
       tabla.eliminar(115269, "abierto");
       System.out.println("Buscar 115269 (debería estar eliminado): " + tabla.buscar(115269, "abierto"));
 
       // Consigna d): Usar métodos de insertar, buscar y eliminar con elección del método de colisión
       System.out.println("\nConsigna d): Prueba del método de elección de colisión en insertar, buscar, y eliminar");
       System.out.println("Insertar y buscar elementos con diferentes métodos de colisión utilizando parámetros.");
       System.out.println("Las pruebas anteriores confirman que se pueden elegir y usar los métodos de colisión.");
    }
 }
 