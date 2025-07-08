package TrabalhoLP2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Usuario {

    private String nome;
    public static Usuario usuarioLogado = null;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void menuUsuario() {
        System.out.println("Seja bem-vindo ao LP2Reddit!");
        System.out.println("Para criar uma conta digite 'criar'");
        System.out.println("Já tem uma conta? Então digite 'login'");
        String resposta = scanner.nextLine().toLowerCase();

        if (resposta.equals("login")) {
            login();
        } else if (resposta.equals("criar")) {
            criarConta();
        } else {
            System.out.println("Opção inválida.");
            menuUsuario();
            return;
        }
    }

    public static void login() {
        System.out.println("Digite seu nome de usuário:");
        String nomeLogin = scanner.nextLine().trim();

        try (BufferedReader leitor = new BufferedReader(new FileReader("Usuario.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String nome = linha.trim();
                if (nome.equalsIgnoreCase(nomeLogin)) {
                	usuarioLogado = new Usuario(nome);
                    System.out.println("Login realizado com sucesso.");
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de usuários.");
            login();
            return;
        }

        System.out.println("Usuário não encontrado.");
        login();
        return;
    }

    public static void criarConta() {
        System.out.println("Digite um nome de usuário para criar a conta:");
        String novoNome = scanner.nextLine().trim();

        // Recarrega os usuários do arquivo para verificar duplicatas
        usuarios.clear();
        try (BufferedReader leitor = new BufferedReader(new FileReader("Usuario.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                usuarios.add(new Usuario(linha.trim()));
            }
        } catch (IOException e) {

        }

        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(novoNome)) {
                System.out.println("Nome de usuário já existe.");
                criarConta();
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuario.txt", true))) {
            writer.write(novoNome + "\n");
            usuarioLogado = new Usuario(novoNome);
            System.out.println("Conta criada com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de usuários.");
            criarConta();
            return;
        }          
    }
}
