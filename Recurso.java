// Recurso.java
public class Recurso {
    // Enumeración para los tipos de recursos de la biblioteca
    public enum Tipo {
        AUDIO, VIDEO, IMAGEN, PAPER, REVISTA, OTRO
    }

    private Integer codigo;   // Código único del recurso
    private String titulo;    // Título del recurso
    private Tipo tipo;        // Tipo de recurso (Audio, Video, etc.)

    // Constructor para inicializar los atributos del recurso
    public Recurso(Integer codigo, String titulo, Tipo tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.tipo = tipo;
    }

    // Getter para el código
    public Integer getCodigo() {
        return codigo;
    }

    // Método para calcular el índice en la tabla hash usando H(x) = X mod 10
    public int calcularHash(int tableSize) {
        return this.codigo % tableSize;
    }

    // Método toString para representar el recurso en formato de texto
    @Override
    public String toString() {
        return titulo + " (" + tipo + ")";
    }
}
