package TrabalhoLP2;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
	   Scanner scanner = new Scanner(System.in);
       SistemaComunidade sistemaComunidade = new SistemaComunidade();
       SistemaPosts sistemaPosts = new SistemaPosts();

       Usuario.menuUsuario();
       sistemaComunidade.carregarPostsDeArquivo("src/TrabalhoLP2/teste.txt");

       sistemaComunidade.menuComunidades();
       int escolhaComunidade = scanner.nextInt();
       scanner.nextLine(); // consumir quebra de linha

       // Pega a comunidade escolhida
       Comunidade comunidadeEscolhida = sistemaComunidade.getComunidadePorIndice(escolhaComunidade);
       if (comunidadeEscolhida == null) {
           System.out.println("Comunidade inválida.");
           scanner.close();
           return;
       }

       // Permite o usuário interagir com a comunidade
       sistemaComunidade.gerenciarComunidade(escolhaComunidade, Usuario.usuarioLogado);

       // Agora o usuário escolhe um post pelo ID para comentar/ver
       System.out.println("\nDigite o ID do post que deseja comentar ou ver comentários:");
       int escolhaPost = scanner.nextInt();
       scanner.nextLine(); // consumir quebra de linha

       Post postSelecionado = comunidadeEscolhida.getPostPorId(escolhaPost);
       if (postSelecionado == null) {
           System.out.println("Post não encontrado.");
           scanner.close();
           return;
       }

       sistemaPosts.gerenciarPost(postSelecionado, Usuario.usuarioLogado);
       scanner.close();
   }
}
