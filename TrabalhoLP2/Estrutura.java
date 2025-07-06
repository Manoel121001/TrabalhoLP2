package module;

public class Estrutura {
	
	protected String autor;
	protected String subtexto;
	protected String dataPost;
	
	public Estrutura(String autor, String subtexto, String dataPost) {
		super();
		this.autor = autor;
		this.subtexto = subtexto;
		this.dataPost = dataPost;
	}

	public String getAutor() {
		return autor;
	}

	public String getSubtexto() {
		return subtexto;
	}

	public String getDataPost() {
		return dataPost;
	}

	
}
