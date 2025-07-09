package TrabalhoLP2;
import java.util.ArrayList;
import java.util.List;

public class Comunidade {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final CategoriasComunidade categoria;
    private int proximoIdPost = 1;
    private List<Post> posts;


    public Comunidade (CategoriasComunidade categoria){
        this.categoria = categoria;
        this.posts = new ArrayList<>();
    }

    public CategoriasComunidade getCategoria(){
        return categoria;
    }

    public void criarEAdicionarPost(String autor, String titulo, String conteudo) {
        Post novoPost = new Post(autor, titulo, conteudo, proximoIdPost++);
        posts.add(novoPost);
    }

    public void exibir(){
        System.out.println("\n Posts na Comunidade " + this.categoria.name());
        if (posts.isEmpty()){
            System.out.println("Não há posts nessa comunidade até o momento");
        }
        else{
            for (Post post : this.posts){
                System.out.print("["+post.getIdPost()+"] - ");
                System.out.print(ANSI_RED + post.getAutor()+ANSI_RESET+"\t");
                System.out.println(post.getDataPublicacao());
                System.out.println(ANSI_RED+post.getTituloPost()+ANSI_RESET);
                System.out.println(post.getConteudo());
                System.out.println("Quantidade de comentários: " + post.getQntdComentarios());
            }
        }
    }
    
    public Post getPostPorId(int id) {
        for (Post post : posts) {
            if (post.getIdPost() == id) {
                return post;
            }
        }
        return null;
    }


   public int getQntdPosts(){
        return posts.size();
   }
    public void exibirResumo(){
        System.out.println("Comunidade: "+ categoria.name());
        System.out.println("Descrição: " + categoria.getDescricao());
        System.out.println("Quantidade de Posts: " + getQntdPosts());
    }

}