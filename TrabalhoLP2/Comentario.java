package TrabalhoLP2;

public class Comentario extends Conteudo {
    private int idComentario;

    public Comentario(String autor, String conteudo, int idComentario) {
        super(conteudo, autor);
        this.idComentario = idComentario;
    }

    public int getIdComentario() {
        return idComentario;
    }
}
