import java.security.InvalidParameterException;

public class Estoque {
	private Produto[] listaProduto;
	private int tamanho;
	private int[] listaQuantidade;

	public Estoque(int tamanho) {
		if (tamanho < 1)
			throw new InvalidParameterException("Erro ao criar estoque: O estoque deve ter pelo menos 1 produto");

		listaProduto = new Produto[tamanho];
		this.tamanho = 0;
	}

	public boolean estaVazio() {
		return tamanho == 0;
	}

	public boolean estaCheio() {
		return tamanho >= listaProduto.length;
	}

	public int indexProduto(Produto produto) {
		if (!estaVazio())
			for (int i = 0; i < tamanho; i++)
				if (produto.getId() == listaProduto[i].getId())
					return i;
		return -1;
	}

	public void adicionar(Produto produto, int quantidade) throws Exception {
		if (quantidade < 0) {
			throw new InvalidParameterException("Erro ao adicionar produto: A quantidade deve ser um número positivo!");
		}
		if (estaCheio()) {
			throw new Exception("Erro ao adicionar produto: O estoque está cheio!");
		}
		listaProduto[tamanho] = produto;
		listaQuantidade[tamanho] = quantidade;
		tamanho++;
	}
}
