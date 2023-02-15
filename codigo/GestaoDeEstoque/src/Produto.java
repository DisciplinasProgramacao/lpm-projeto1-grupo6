public class Produto {
	private String descricao;
	private float precoCusto;
	private int margemLucro;
	private float precoVenda;
	private float valorLucro;
	private float valorImpostos;

	public Produto(String descricao, float precoCusto, int margemLucro) throws Exception {
		if (descricao.length() < 3) {
			throw new Exception("Erro ao cadastrar o produto: A descrição deve conter pelo menos três caracteres");
		}
		if (precoCusto <= 0) {
			throw new Exception("Erro ao cadastrar o produto: O preço de custo deve ser maior do que zero");
		}
		if (margemLucro < 30 || margemLucro > 80) {
			throw new Exception("Erro ao cadastrar o produto: A margem deve ser entre 30% e 80%");
		}
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.margemLucro = margemLucro;
		calcularValores();
	}

	private void calcularValores() {
		this.valorLucro = (this.margemLucro / 100) * this.precoCusto;
		this.valorImpostos = (this.precoCusto + this.valorLucro) * (18 / 100);
		this.precoVenda = this.precoCusto + this.valorImpostos + this.valorLucro;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public int getMargemLucro() {
		return margemLucro;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public float getValorLucro() {
		return valorLucro;
	}

	public float getValorImpostos() {
		return valorImpostos;
	}

}
