package TrabalhoLP2;

import java.util.Scanner;

public class SistemaPosts {
    private Scanner scanner = new Scanner(System.in);

    public void gerenciarPost(Post post, Usuario usuario) {
        System.out.printf("[%d] %s (%s)\n", post.getIdPost(), post.getTituloPost(), post.getAutor());
        System.out.println("Digite 'comentar' para adicionar um comentário ou 'ver' para ver todos os comentários:");
        String acao = scanner.nextLine().toLowerCase();

        if (acao.equals("comentar")) {
            System.out.print("Digite o conteúdo do comentário: ");
            String conteudo = scanner.nextLine();
            post.criarEAdicionarComentario(usuario.getNome(), conteudo);
        } else if (acao.equals("ver")) {
            post.exibirComentarios();
        } else {
            System.out.println("Comando inválido.");
        }
    }
}
