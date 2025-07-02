package TrabalhoLP2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Post {
    private String autorPost;
    private String tituloPost;
    private String conteudoPost;
    private String dataPost;
    private int idpost;
    private List<Comentario> comentarios;

    public Post(String autorPost, String tituloPost, String conteudoPost){
        LocalDateTime tempoAtual = LocalDateTime.now();
        DateTimeFormatter  formatadorString = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.autorPost = autorPost;
        this.tituloPost = tituloPost;
        this.conteudoPost = conteudoPost;
        this.dataPost = tempoAtual.format(formatadorString);
    }

    public String getAutorPost(){
        return autorPost;
    }
    public  String getTituloPost(){
        return tituloPost;
    }
    public String getConteudoPost(){
        return conteudoPost;
    }
    public String getDataPost(){
        return dataPost;
    }

}

