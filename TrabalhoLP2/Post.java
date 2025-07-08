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
  
    public Post(String autor, String tituloPost, String subtexto) {
		super(autor, subtexto);
		this.tituloPost = tituloPost;
		this.idPost = proximoId++;
		// Aqui o post recebe o proximoID (Sendo o primeiro 1 e itera em proximo id +1 o proximo já recebe 2)
	}

	public String getTituloPost() {
		return tituloPost;
	}


	public int getIdPost() {
		return idPost;
	}

	//Podemos fazer algo com o ID POST para comentar no post que desejamos

//	public static ArrayList<Post> getPosts() {
//		return posts;
//	}
	
//	public static boolean criarPost() {
//
//		System.out.println("Digite um título para o seu post:");
//		String novoTitulo = scanner.nextLine();
//		System.out.println("Digite um subtexto para o seu post:");
//		String novoSubtexto = scanner.nextLine();
//
//		int novoIdPost = posts.size() + 1;
//		LocalDateTime tempoAtual = LocalDateTime.now();
//        DateTimeFormatter  formatadorString = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        String novaData = tempoAtual.format(formatadorString);
//		String novoAutor = Usuario.usuarioLogado.getNome();
//		Post novoPost = new Post(novoIdPost, novoTitulo, novoSubtexto, novoAutor, novaData);
//        posts.add(novoPost);
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Post.txt", true))) {
//            writer.write(novoIdPost + "|" + novoTitulo + "|" + novoSubtexto + "|" + novoAutor + "|" + novaData + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Post criado com sucesso.");
//        return true;
//	}
//
//	public static void exibirPosts() {
//
//    	posts.clear();
//		try (BufferedReader reader = new BufferedReader(new FileReader("Post.txt"))) {
//		    String linha;
//		    while ((linha = reader.readLine()) != null) {
//		        String[] partes = linha.split("\\|");
//		        int idPostExistente = Integer.parseInt(partes[0]);
//		        String tituloExistente = partes[1];
//		        String subtextoExistente = partes[2];
//		        String autorExistente = partes[3];
//		        String dataPostExistente = partes[4];
//		        Post postExistente = new Post(idPostExistente, tituloExistente, subtextoExistente, autorExistente, dataPostExistente);
//		        posts.add(postExistente);
//		        System.out.println("[" + idPostExistente + "]" + tituloExistente + "\n" + subtextoExistente + "\n" + autorExistente + " - " + dataPostExistente + "\n");
//		    }
//		} catch (IOException e) {
//
//		}
    }


	