import java.security.InvalidParameterException;

public class Estoque {
	Produto[] listaProduto;
	int tamanho;

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

	public void adicionar(Produto produto) throws Exception {
		if (estaCheio()) {
			throw new Exception("Erro ao adicionar produto: O estoque está cheio!");
		}
		listaProduto[tamanho] = produto;
		tamanho++;
	}
}
