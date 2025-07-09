package TrabalhoLP2;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post extends Conteudo implements Exibivel {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private String tituloPost;
    private int idPost;
    private String dataPublicacao;
    private int proximoIdComentario = 1;
    private List<Comentario> comentarios;

    public Post(String autor, String tituloPost, String conteudo, int idPost) {
        super(conteudo, autor);
        this.tituloPost = tituloPost;
        this.idPost = idPost;
        this.dataPublicacao = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.comentarios = new ArrayList<>();
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String getTituloPost() {
        return tituloPost;
    }

    public int getIdPost() {
        return idPost;
    }

    public void criarEAdicionarComentario(String autor, String conteudo) {
        Comentario novoComentario = new Comentario(autor, conteudo, proximoIdComentario++);
        comentarios.add(novoComentario);
        exibir();
    }

    public void exibir() {
        System.out.println("\n=========== COMENTÁRIOS ===========");
        if (comentarios.isEmpty()) {
            System.out.println("Este post ainda não possui comentários.");
        } else {
            for (Comentario comentario : comentarios) {
                System.out.print("[" + comentario.getIdComentario() + "] - ");
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
}
