package TrabalhoLP2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comentario {

    private Usuario autor;
    private String texto;
    private String dataComentario;


    public Comentario(Usuario autor, String texto){
        LocalDateTime tempoAtual = LocalDateTime.now();
        DateTimeFormatter formatadorString = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.autor = autor;
        this.texto = texto;
        this.dataComentario = tempoAtual.format(formatadorString);

    }




}
