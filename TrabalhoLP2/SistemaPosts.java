package TrabalhoLP2;

import java.util.Scanner;

public class SistemaPosts {
    private static Scanner scanner = new Scanner(System.in);

    
    public void menuComentario(Post post, Usuario usuario) {
        while (true) {
            System.out.printf("Post [%d]: %s\n", post.getIdPost(), post.getTituloPost());
            System.out.println("Autor: " + post.getAutor());
            System.out.println("-------------------------------");
            System.out.println("Digite 'comentar' para adicionar um comentário.");
            System.out.println("Digite 'ver' para visualizar todos os comentários.");
            System.out.println("Digite 'sair' para voltar.");

            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("comentar")) {
                System.out.print("Digite o conteúdo do comentário: ");
                String conteudo = scanner.nextLine();
                post.criarEAdicionarComentario(usuario.getNome(), conteudo);
                
            } else if (resposta.equals("ver")) {
                post.exibir();
            } else if (resposta.equals("sair")) {
                System.out.println("Saindo do menu de comentários...");
                return;
            } else {
                System.out.println("Comando inválido. Tente novamente.");
                menuComentario(post, usuario);
                return;
            }
        }
    }

    
    public void gerenciarPost(Post post, Usuario usuario) {
        System.out.printf("[%d] %s (%s)\n", post.getIdPost(), post.getTituloPost(), post.getAutor());
        System.out.println("Digite 'comentar' para adicionar um comentário ou 'ver' para ver todos os comentários:");
        
        String acao = scanner.nextLine().toLowerCase();

        if (acao.equals("comentar")) {
            System.out.print("Digite o conteúdo do comentário: ");
            String conteudo = scanner.nextLine();
            post.criarEAdicionarComentario(usuario.getNome(), conteudo);
        } else if (acao.equals("ver")) {
            post.exibir();
        } else {
            System.out.println("Comando inválido.");
        }
    }
}
