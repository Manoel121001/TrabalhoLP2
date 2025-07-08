package TrabalhoLP2;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SistemaComunidade {
    private static Scanner scanner = new Scanner(System.in);

    List<Comunidade> comunidades = new ArrayList<>();

    {
        //Inicio a lista de Comunidades
        for (CategoriasComunidade cat : CategoriasComunidade.values()) {
            comunidades.add(new Comunidade(cat));
        }
        //Ordena as comunidades em ordem alfábetica (USO DO SORT)
        comunidades.sort(Comparator.comparing(c -> c.getCategoria().name()));
    }

    public void menuComunidades() {
        System.out.println("===========ESCOLHA UMA COMUNIDADE PARA ENTRAR===============");
        for (int i = 0; i < comunidades.size(); i++) {
            // Após o sort faço um print do resumo de cada Comunidade em ordem afalbetica provando que o sort funcionou
            System.out.print((i + 1)+"-");
            comunidades.get(i).exibirResumo();
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("==========================================================\n");
    }
    public void carregarPostsDeArquivo(String nomeDoArquivo) {
        System.out.println("Iniciando carregamento de posts do arquivo: " + nomeDoArquivo);
        Path caminhoDoArquivo = Paths.get(nomeDoArquivo);

        // Usamos try-with-resources para garantir que o leitor de arquivo seja fechado automaticamente.
        try (BufferedReader leitor = Files.newBufferedReader(caminhoDoArquivo)) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Primeira linha: Categoria
                String categoriaNome = linha.trim();
                Comunidade comunidadeAlvo = encontrarComunidadePorNome(categoriaNome);

                if (comunidadeAlvo == null) {
                    System.err.println("AVISO: Comunidade '" + categoriaNome + "' não encontrada. Pulando este post.");
                    // Pula as linhas do post inválido até encontrar o delimitador
                    while ((linha = leitor.readLine()) != null && !linha.equals("---FIMPOST---")) {}
                    continue;
                }

                // Acho que aqui podemos criar uma verificação se o usuário está logado ou está dentre nosso "banco de usuarios"  isso

                // Segunda linha Autor
                String autor = leitor.readLine();
                // Terceira linha Título
                String titulo = leitor.readLine();

                // Lê o conteúdo até encontrar o delimitador
                StringBuilder conteudoBuilder = new StringBuilder();
                while ((linha = leitor.readLine()) != null && !linha.equals("---FIMPOST---")) {
                    conteudoBuilder.append(linha).append("\n"); // Adiciona a linha e uma quebra de linha
                }

                // Cria o post e adiciona na comunidade encontrada
                comunidadeAlvo.criarEAdicionarPost(autor, titulo, conteudoBuilder.toString().trim());

            }
            System.out.println("Carregamento de posts concluído com sucesso!");
        } catch (IOException e) {
            System.err.println("ERRO AO LER O ARQUIVO: Não foi possível encontrar ou ler o arquivo '" + nomeDoArquivo + "'. Verifique se ele está na pasta raiz do projeto.");
             e.printStackTrace();
        }
    }
    private Comunidade encontrarComunidadePorNome(String nome) {
        for (Comunidade comunidade : this.comunidades) {
            if (comunidade.getCategoria().name().equalsIgnoreCase(nome)) {
                return comunidade;
            }
        }
        return null;
    }

    public void gerenciarComunidade (int opcao, Usuario usuario){
        while (opcao<1 || opcao>comunidades.size()){
            System.out.println("Opção inválida! Escolha um número presente na lista.");

        }

        Comunidade comunidadeEscolhida = comunidades.get(opcao - 1);
        System.out.printf("\nOlá %s bem vindo a Comunidade %s\n", usuario.getNome(), comunidadeEscolhida.getCategoria().name());

        System.out.println("O que você deseja fazer?");
        System.out.println("Para adicionar um novo post escreva 'adicionar' ");
        System.out.println("Para ver todos os posts escreva 'ver' ");
        String acao = scanner.nextLine();
        //Utilização do EQUALS
        if (acao.toLowerCase().equals("adicionar")){
            System.out.print("Digite o título do post: ");
            String titulo = scanner.nextLine();

            System.out.println("Digite o conteúdo do Post");
            String conteudo = scanner.nextLine();

            comunidadeEscolhida.criarEAdicionarPost( usuario.getNome(),titulo, conteudo);

        }
        if(acao.toLowerCase().equals("ver")){
            comunidadeEscolhida.exibirPosts();
        }

    }
}







