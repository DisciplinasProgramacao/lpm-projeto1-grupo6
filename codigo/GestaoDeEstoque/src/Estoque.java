public class Estoque {
	private Produto[] listaProduto;
	private int tamanho;
	private int[] listaQuantidade;

	public Estoque(int tamanho) {
		if (tamanho < 1)
			return;

		listaProduto = new Produto[tamanho];
		listaQuantidade = new int[tamanho];
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

	public int quantidade(Produto produto) {
		return listaQuantidade[indexProduto(produto)];
	}

	public void cadastrar(Produto produto) {
		if (estaCheio())
			return;

		if (indexProduto(produto) >= 0)
			return;

		listaProduto[tamanho] = produto;
		tamanho++;
	}

	public void repor(Produto produto, int quantidade) {
		int aux = indexProduto(produto);

		if (aux < 0)
			return;

		listaQuantidade[aux] += quantidade;
	}

	public void retirar(Produto produto, int quantidade) {
		int aux = indexProduto(produto);

		if (aux < 0)
			return;

		if (quantidade > quantidade(produto))
			return;

		listaQuantidade[aux] -= quantidade;
	}

	public int quantidade() {
		if (estaVazio())
			return -1;

		int aux = 0;
		for (int quantidade : listaQuantidade)
			aux += quantidade;

		return aux;
	}
}
