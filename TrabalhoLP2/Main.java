package TrabalhoLP2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaComunidade sistemaComunidade = new SistemaComunidade();
        SistemaPosts sistemaPosts = new SistemaPosts(); // Embora o menu esteja em SistemaPosts, podemos precisar dele

        // --- SETUP INICIAL (Acontece apenas uma vez) ---
        Usuario.menuUsuario();
        System.out.println("Bem-vindo(a), " + Usuario.usuarioLogado.getNome() + "!");
        sistemaComunidade.carregarPostsDeArquivo("src/TrabalhoLP2/post.txt");

        // --- LOOP PRINCIPAL DO APLICATIVO ---
        while (true) {
            // NÍVEL 0: MENU DE COMUNIDADES
            sistemaComunidade.menuComunidades();
            System.out.println("Digite o número da comunidade para entrar ou 'deslogar' para sair do programa:");
            String entradaUsuario = scanner.nextLine();

            // Condição de saída do programa
            if (entradaUsuario.equalsIgnoreCase("deslogar")) {
                System.out.println("Deslogando... Até a próxima!");
                break; // Sai do loop principal e encerra o programa
            }

            try {
                int escolhaComunidade = Integer.parseInt(entradaUsuario); // Ajuste para índice 0
                Comunidade comunidadeEscolhida = sistemaComunidade.getComunidadePorIndice(escolhaComunidade);

                if (comunidadeEscolhida == null) {
                    System.out.println("Comunidade inválida. Tente novamente.");
                    continue; // Volta para o início do loop principal
                }

                // --- LOOP DA COMUNIDADE ESCOLHIDA ---
                while (true) {
                    // NÍVEL 1: DENTRO DE UMA COMUNIDADE
                    System.out.println("\n--- Você está na comunidade: " + comunidadeEscolhida.getCategoria().name() + " ---");
                    comunidadeEscolhida.exibir(); // Exibe os posts da comunidade

                    sistemaComunidade.gerenciarComunidade(escolhaComunidade, Usuario.usuarioLogado);
                    System.out.println("\nDigite o ID do post para interagir ou 'voltar' para escolher outra comunidade:");
                    String entradaComunidade = scanner.nextLine();

                    if (entradaComunidade.equalsIgnoreCase("voltar")) {
                        break; // Sai do loop da comunidade e volta para a seleção de comunidades
                    }

                    try {
                        int escolhaPostId = Integer.parseInt(entradaComunidade);
                        Post postSelecionado = comunidadeEscolhida.getPostPorId(escolhaPostId);

                        if (postSelecionado == null) {
                            System.out.println("Post não encontrado nesta comunidade. Tente novamente.");
                            continue; // Volta para o início do loop da comunidade
                        }

                        // NÍVEL 2: DENTRO DE UM POST (chama o menu de comentários)
                        sistemaPosts.menuComentario(postSelecionado, Usuario.usuarioLogado);

                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, digite um ID de post ou 'voltar'.");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número ou 'deslogar'.");
            }
        }

        scanner.close(); // Fecha o scanner apenas quando sair do programa
    }
}