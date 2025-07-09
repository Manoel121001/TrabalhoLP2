package TrabalhoLP2;

import java.util.ArrayList;
import java.util.List;

public class Post extends Conteudo implements Exibivel {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private String tituloPost;
    private int idPost;
    private int proximoIdComentario = 1;
    private List<Comentario> comentarios;

    public Post(String autor, String tituloPost, String conteudo, int idPost) {
        super(conteudo, autor, idPost);
        this.tituloPost = tituloPost;
        this.comentarios = new ArrayList<>();
    }

    public String getTituloPost() {
        return tituloPost;
    }



    public void criarEAdicionarComentario(String autor, String conteudo) {
        Comentario novoComentario = new Comentario(autor, conteudo, proximoIdComentario++);
        comentarios.add(novoComentario);
        exibir();
    }

    public void exibir() {
        System.out.println("\nComentários do Post: " + ANSI_RED + this.tituloPost + ANSI_RESET);
        if (comentarios.isEmpty()) {
            System.out.println("Este post ainda não possui comentários.");
        } else {
            for (Comentario comentario : comentarios) {
                System.out.print("[" + comentario.getId() + "] - ");
                System.out.print(ANSI_RED + comentario.getAutor() + ANSI_RESET + "\t");
                System.out.println(comentario.getDataPublicacao());
                System.out.println(comentario.getConteudo());
                System.out.println("---------------------------------------");
            }
        }
    }

    public int getQntdComentarios() {
        return comentarios.size();
    }

    public void exibirResumoDeComentarios() {
        System.out.println("Total de comentários: " + getQntdComentarios());
    }
}
