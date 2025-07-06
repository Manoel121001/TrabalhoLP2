package module;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Usuario {
	
    private int id;
    private String nome;
    public static Usuario usuarioLogado = null;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	
	public Usuario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static boolean login() {
	    System.out.println("Login - digite seu nome de usuário:");
	    String nomeLogin = scanner.nextLine();

	    try (BufferedReader reader = new BufferedReader(new FileReader("Usuario.txt"))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	            String[] partes = linha.split("\\|");
	            if (partes.length == 2) {
	                String nomeExistente = partes[1];
	                if (nomeExistente.equalsIgnoreCase(nomeLogin)) {
	                	usuarioLogado = new Usuario(Integer.parseInt(partes[0]), nomeExistente);
	                    System.out.println("Login realizado com sucesso.");
	                    return true;
	                }
	            }
	        }
	    } catch (IOException e) {
	    	
	    }
	    System.out.println("Usuário não encontrado.");
	    return false;
	}
	
	public static boolean criarConta() {
		
		System.out.println("Digite um nome de usuário para criar a conta:");
		String novoNome = scanner.nextLine();

		usuarios.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader("Usuario.txt"))) {
		    String linha;
		    while ((linha = reader.readLine()) != null) {
		        String[] partes = linha.split("\\|");
		        int idExistente = Integer.parseInt(partes[0]);
		        String nomeExistente = partes[1];
		        usuarioLogado = new Usuario(Integer.parseInt(partes[0]), nomeExistente);
		        usuarios.add(new Usuario(idExistente, nomeExistente));
		    }
		} catch (IOException e) {
			
		}
		
		for (int i = 0; i < usuarios.size(); i++) {
		    if (usuarios.get(i).getNome().equalsIgnoreCase(novoNome)) {
		        System.out.println("Nome de usuário já existe.");
		        return false;
		    }
		}
		 
		int novoId = usuarios.size() + 1;
		Usuario novoUsuario = new Usuario(novoId, novoNome);
        usuarios.add(novoUsuario);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuario.txt", true))) {
            writer.write(novoId + "|" + novoNome + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Conta criada com sucesso.");
        return true;
        
	}

}
