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

	public int quantidadeAtual(Produto produto) {
		return listaQuantidade[indexProduto(produto)];
	}

	public int quantidadeAtual() {
		if (estaVazio())
			return -1;

		int aux = 0;
		for (int quantidade : listaQuantidade)
			aux += quantidade;

		return aux;
	}

	public void retirar(Produto produto, int quantidade) {
		int aux = indexProduto(produto);

		if (aux < 0)
			return;

		if (quantidade > quantidadeAtual(produto))
			return;

		listaQuantidade[aux] -= quantidade;
	}

	public float precoCustoAtual(Produto produto) {
		int aux = indexProduto(produto);

		if (aux < 0)
			return -1;

		return listaProduto[aux].getPrecoCusto();
	}

	public float precoCustoAtual() {
		if (estaVazio())
			return -1;

		float precoCustoAtual = 0;
		for (int i = 0; i < tamanho; i++)
			precoCustoAtual += precoCustoAtual(listaProduto[i]) * quantidadeAtual(listaProduto[i]);

		return precoCustoAtual;
	}

}
