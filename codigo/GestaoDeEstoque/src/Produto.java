import java.security.InvalidParameterException;

public class Produto {
	private static int proximoId = 0;
	public static float PERCENTUAL_IMPOSTOS = 18;
	private String descricao;
	private float precoCusto;
	private float margemLucro;
	private float precoVenda;
	private float valorLucro;
	private float valorImpostos;
	private int id;

	/**
	 * Representa um objeto de produto com propriedades de vendas e descrição
	 *
	 * @param descricao
	 * @param precoCusto
	 * @param margemLucro
	 * @throws InvalidParameterException
	 */
	public Produto(String descricao, float precoCusto, float margemLucro) throws InvalidParameterException {
		if (descricao.length() < 3) {
			throw new InvalidParameterException(
					"Erro ao cadastrar o produto: A descrição deve conter pelo menos três caracteres");
		}
		if (precoCusto <= 0) {
			throw new InvalidParameterException(
					"Erro ao cadastrar o produto: O preço de custo deve ser maior do que zero");
		}
		if (margemLucro < 30 || margemLucro > 80) {
			throw new InvalidParameterException("Erro ao cadastrar o produto: A margem deve ser entre 30% e 80%");
		}
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.margemLucro = margemLucro;
		this.id = Produto.proximoId++;
		calcularValoresDeVenda();
	}

	public void calcularValoresDeVenda() {
		this.valorLucro = ((float) this.margemLucro / 100) * this.precoCusto;
		this.valorImpostos = (this.precoCusto + this.valorLucro) * (Produto.PERCENTUAL_IMPOSTOS / 100);
		this.precoVenda = (float) Math.floor(this.precoCusto + this.valorImpostos + this.valorLucro);
	}

	public String getDescricao() {
		return descricao;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public float getMargemLucro() {
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

	public int getId() {
		return this.id;
	}
}
