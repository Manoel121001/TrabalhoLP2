package TrabalhoLP2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conteudo {
    protected String autor;
    protected String conteudo;
    protected String dataPublicacao;

    public Conteudo(String conteudo, String autor) {
        this.autor = autor;
        this.conteudo = conteudo;

        // Lógica da DATA para não ficar criando sempre a data tudo que for conteudo herda
        // da class conteudo esse sistema de data para data da publicação
        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataPublicacao = hora.format(formatador);
    }

    public String getConteudo(){return conteudo;}
    public String getAutor(){return autor;}
    public String getDataPublicacao(){return dataPublicacao;}
    public void setDataPublicacao(String dataPublicacao) {this.dataPublicacao = dataPublicacao;}
}