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

       // Pruebas con Sondeo Lineal
       System.out.println("\n--- Pruebas con Sondeo Lineal ---");
       System.out.println("Insertando 115269 usando sondeo lineal.");
       tabla.insertar(115269, "lineal");
       System.out.println("Insertando 111254 usando sondeo lineal.");
       tabla.insertar(111254, "lineal");
       System.out.println("Insertando 222333 usando sondeo lineal.");
       tabla.insertar(222333, "lineal");

       System.out.println("\n--- Búsqueda con Sondeo Lineal ---");
       System.out.println("Buscar 115269 (debería estar en la tabla): " + tabla.buscar(115269, "lineal"));
       System.out.println("Buscar 111254 (debería estar en la tabla): " + tabla.buscar(111254, "lineal"));
       System.out.println("Buscar 333444 (no fue insertado, no debería estar en la tabla): " + tabla.buscar(333444, "lineal"));

       System.out.println("\n--- Eliminación con Sondeo Lineal ---");
       System.out.println("Eliminando 115269 usando sondeo lineal.");
       tabla.eliminar(115269, "lineal");
       System.out.println("Buscar 115269 después de eliminar (debería estar eliminado): " + tabla.buscar(115269, "lineal"));

       // Pruebas con Sondeo Cuadrático
       System.out.println("\n--- Pruebas con Sondeo Cuadrático ---");
       System.out.println("Insertando 115269 usando sondeo cuadrático.");
       tabla.insertar(115269, "cuadratico");
       System.out.println("Insertando 111254 usando sondeo cuadrático.");
       tabla.insertar(111254, "cuadratico");
       System.out.println("Insertando 222333 usando sondeo cuadrático.");
       tabla.insertar(222333, "cuadratico");

       System.out.println("\n--- Búsqueda con Sondeo Cuadrático ---");
       System.out.println("Buscar 115269 (debería estar en la tabla): " + tabla.buscar(115269, "cuadratico"));
       System.out.println("Buscar 111254 (debería estar en la tabla): " + tabla.buscar(111254, "cuadratico"));
       System.out.println("Buscar 333444 (no fue insertado, no debería estar en la tabla): " + tabla.buscar(333444, "cuadratico"));

       System.out.println("\n--- Eliminación con Sondeo Cuadrático ---");
       System.out.println("Eliminando 115269 usando sondeo cuadrático.");
       tabla.eliminar(115269, "cuadratico");
       System.out.println("Buscar 115269 después de eliminar (debería estar eliminado): " + tabla.buscar(115269, "cuadratico"));

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
