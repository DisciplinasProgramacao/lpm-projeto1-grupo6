import java.security.InvalidParameterException;

public class Estoque {
	Produto[] produtos;
	int tamanho;

	public Estoque(int tamanho) {
		if (tamanho < 1)
			throw new InvalidParameterException("Erro ao criar estoque: O estoque deve ter pelo menos 1 produto");

		produtos = new Produto[tamanho];
		tamanho = 0;
	}

	public boolean estaVazio() {
		return tamanho == 0;
	}

	public boolean estaCheio() {
		return tamanho > produtos.length;
	}

	public int indexProduto(Produto produto) {
		if (!estaVazio())
			for (int i = 0; i < tamanho; i++)
				if (produto.getId() == produtos[i].getId())
					return i;
		return -1;
	}

	public void repor(Produto produto, int quantidade) throws Exception {
		if (estaVazio()) {
			produtos[0] = produto;
		}
		tamanho++;
	}
}
