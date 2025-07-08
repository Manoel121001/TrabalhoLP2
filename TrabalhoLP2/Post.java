package TrabalhoLP2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Post extends Conteudo{
	// O primeiro post inicia com id 1
	private static int proximoId = 1;
	private String tituloPost;
    private int idPost;
//    private static ArrayList<Comentarios> comentarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
  
    public Post(String autor, String tituloPost, String subtexto, int idPost) {
		super(autor, subtexto);
		this.tituloPost = tituloPost;
		this.idPost = idPost;
		// Aqui o post recebe o proximoID (Sendo o primeiro 1 e itera em proximo id +1 o proximo já recebe 2)
	}

	public String getTituloPost() {
		return tituloPost;
	}


	public int getIdPost() {
		return idPost;
	}
   // CADA POST DENTRO DA COMUNIDADE TEM SEU ID PRÓPRIO NAQUELA COMUNIDADE
	
    }


	