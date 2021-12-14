package ribeiro.luis.discsom.loja.model;

public class InfoProduto {
	private Long id;

	private String nome;

	private String imagem;

	private String descricao;

	private int quantidade;

	private InfoCategoria categoria;

	public Long getId() {
		return id;
	}

	public InfoCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(InfoCategoria categoria) {
		this.categoria = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
