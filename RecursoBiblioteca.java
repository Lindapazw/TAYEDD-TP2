public class RecursoBiblioteca implements IHashable {
    public enum Tipo {
        AUDIO, VIDEO, IMAGEN, PAPER, REVISTA, OTRO
    }

    private Integer codigo;
    private String titulo;
    private Tipo tipo;

    public RecursoBiblioteca(Integer codigo, String titulo, Tipo tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public int hash(int tableSize) {
        return this.codigo % tableSize;
    }

    @Override
    public String toString() {
        return titulo + " (" + tipo + ")";
    }
}
