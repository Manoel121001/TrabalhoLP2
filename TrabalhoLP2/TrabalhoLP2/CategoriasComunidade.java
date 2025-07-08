package TrabalhoLP2;

public enum CategoriasComunidade {

    TECNOLOGIA("Trata sobre as inovações, gadgets, softwares e o impacto da tecnologia no dia a dia."),

    ESPORTES("Discussões sobre campeonatos, times, atletas e a prática de diversas modalidades esportivas."),

    POLITICA("Debates sobre o cenário político, políticas públicas, eleições e questões sociais relevantes."),

    ARTE("Abrange as mais diversas formas de expressão criativa, como cinema, música, pintura e literatura."),

    VIAGENS("Dicas de destinos, roteiros, culturas e compartilhamento de experiências de viagens pelo mundo."),

    GASTRONOMIA("Tudo sobre o universo da culinária, incluindo receitas, restaurantes, vinhos e cultura alimentar."),

    OUTROS("Assuntos diversos e variados que não se enquadram nas categorias principais.");
    private String descricao;
    private CategoriasComunidade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){

        return descricao;
    }
}
