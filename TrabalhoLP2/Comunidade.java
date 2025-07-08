package TrabalhoLP2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comunidade {
    private final CategoriasComunidade categoria;
    private List<Usuario> MembrosDaComunidade;
    private List<Post> posts;
    private static Scanner scanner = new Scanner(System.in);


    public Comunidade (CategoriasComunidade categoria){
        this.categoria = categoria;
        this.MembrosDaComunidade = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public CategoriasComunidade getCategoria(){
        return categoria;
    }
    public void adicionarMembro(Usuario membro){
        this.MembrosDaComunidade.add(membro);

    }
    public int getQntdMembros(){
        return MembrosDaComunidade.size();
    }
    public void adicionarPost(Post novoPost){

        this.posts.add(novoPost);
    }
    public void exibirPosts(){
        System.out.println("\n Posts na Comunidade " + this.categoria.name());
        if (posts.isEmpty()){
            System.out.println("Não há posts nessa comunidade até o momento");
        }
        else{
            for (Post post : this.posts){
                System.out.println(post);
            }
        }
    }

   public int getQntdPosts(){
        return posts.size();
   }
    public void exibirResumo(){
        System.out.println("Comunidade: "+ categoria.name());
        System.out.println("Descrição: " + categoria.getDescricao());
        System.out.println("Membros: " + getQntdMembros());
        System.out.println("Quantidade atual de Posts: " + getQntdPosts());
    }

}
