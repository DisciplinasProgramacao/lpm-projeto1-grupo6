public class Estoque {
	private static int QUANTIDADE_MINIMA = 20;
	private int tamanho;
	private Produto[] listaProduto;
	private int[] listaQuantidade;
	private int[] listaUnidadesCompradas;
	private float[] listaCustoAquisicaoHistorico;
	private int[] listaUnidadesVendidasHistorico;
	private float[] listaFaturamentoHistorico;

	public Estoque(int tamanho) {
		if (tamanho < 1)
			tamanho = 1;

		listaProduto = new Produto[tamanho];
		listaQuantidade = new int[tamanho];
		listaUnidadesCompradas = new int[tamanho];
		listaCustoAquisicaoHistorico = new float[tamanho];
		listaUnidadesVendidasHistorico = new int[tamanho];
		listaFaturamentoHistorico = new float[tamanho];
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

		if (estaVazio())
			return;

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

	public boolean abaixoDoMinimo(Produto produto) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return false;

		if (aux < 0)
			return false;

		return listaQuantidade[indexProduto(produto)] < QUANTIDADE_MINIMA;
	}

	public String produtosQuantidadeAbaixoMinimo() {
		if (estaVazio())
			return "";

		String aux = "";
		for (Produto produto : listaProduto)
			if (abaixoDoMinimo(produto))
				aux += produto.getDescricao() + "\n";

		return aux;
	}

	public void registrarCompra(Produto produto, int quantidade) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return;

		if (aux < 0)
			return;

		repor(produto, quantidade);
		listaUnidadesCompradas[aux] += quantidade;
		listaCustoAquisicaoHistorico[aux] += quantidade * listaProduto[aux].getPrecoCusto();
	}

	public int unidadesCompradas(Produto produto) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return -1;

		if (aux < 0)
			return -1;

		return listaUnidadesCompradas[aux];
	}

	public float custoAquisicaoHistorico(Produto produto) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return -1;

		if (aux < 0)
			return -1;

		return listaCustoAquisicaoHistorico[aux];
	}

	public void registrarVenda(Produto produto, int quantidade) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return;

		if (aux < 0)
			return;

		retirar(produto, quantidade);
		listaUnidadesVendidasHistorico[aux] += quantidade;
		listaFaturamentoHistorico[aux] += quantidade * listaProduto[aux].getPrecoVenda();
	}

	public int unidadesVendidas(Produto produto) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return -1;

		if (aux < 0)
			return -1;

		return listaUnidadesVendidasHistorico[aux];
	}

	public float faturamentoHistorico(Produto produto) {
		int aux = indexProduto(produto);

		if (estaVazio())
			return -1;

		if (aux < 0)
			return -1;

		return listaFaturamentoHistorico[aux];
	}

}
