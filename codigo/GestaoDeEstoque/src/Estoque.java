import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia um estoque de Produtos. É possível fazer operações como cadastrar e
 * buscar produtos, fazer reposição/retirada no estoque, registrar
 * compras/vendas, verificar as quantidades atuais em estoque, faturamento,
 * gastos.
 */
class Estoque {
	private static int QUANTIDADE_MINIMA = 20;
	private Produto[] listaProdutos;
	private ItemEstoque[] itens;

	/**
	 * Registra uma venda realizada. Atualiza os valores de quantidade atuais e
	 * valores de faturamento histórico.
	 *
	 * @param produto    não nulo
	 * @param quantidade maior que 0
	 */
	void registrarRetirada(Produto produto, int quantidade, boolean venda) throws IllegalArgumentException {

		ItemEstoque item = retornaItem(produto.getId());
		if (item.getQuantidade() < QUANTIDADE_MINIMA) {
			throw new IllegalArgumentException("QUANTIDADE MÍNIMA EXCEDIDA");
		} else {
			item.retirarItem(quantidade, venda);
		}
	}

	void registrarCompra(Produto produto, int quantidade) throws IllegalArgumentException {

		ItemEstoque item = retornaItem(produto.getId());
		item.compraDeItem(quantidade);
	}

	public ItemEstoque retornaItem(int produtoId) {
		for (ItemEstoque item : this.itens) {
			if (item.getProduto().getId() == produtoId) {
				return item;
			}
		}

		return null;
	}

	public int quantidadeTotalProdutos(){
		int quantidade = 0;

		for (ItemEstoque item : this.itens) {
			quantidade += item.getQuantidade();
		}

		return quantidade;
	}

	public double valorTotalEstoque(){
		int valorEstoque = 0;

		for (ItemEstoque item : this.itens) {
			valorEstoque += item.getTotalCustoCompra();
		}

		return valorEstoque;
	}

	public List<Produto> produtosMinimos(){
		List<Produto> produtos = new ArrayList<Produto>();

		for (ItemEstoque item : this.itens) {
			if (item.getQuantidade() < QUANTIDADE_MINIMA){

				produtos.add(item.getProduto());
			}
		}

		return produtos;
	}
}
//	/**
//	 * Cria um estoque com um tamanho fixo.
//	 *
//	 * @param tamanho Se o valor informado for menor que zero, será criado um
//	 *                estoque de tamanho 1
//	 */
//	Estoque(int tamanho) {
//		if (tamanho < 1)
//			tamanho = 1;
//
//		listaProdutos = new Produto[tamanho];
//		listaQuantidadeAtual = new int[tamanho];
//		listaTotalUnidadesCompradas = new int[tamanho];
//		listaTotalCustoCompra = new float[tamanho];
//		listaTotalUnidadesVendidas = new int[tamanho];
//		listaTotalFaturamento = new float[tamanho];
//		this.tamanhoEstoque = 0;
//	}
//
//	/**
//	 * Verifica se o estoque está vazio.
//	 *
//	 * @return true se o estoque não possui nenhum produto.
//	 */
//	boolean estaVazio() {
//		return tamanhoEstoque == 0;
//	}
//
//	/**
//	 * Verifica se o estoque está cheio.
//	 *
//	 * @return true se o estoque possui todas as posições ocupadas.
//	 */
//	boolean estaCheio() {
//		return tamanhoEstoque >= listaProdutos.length;
//	}
//
//	/**
//	 * Realiza uma busca sequencial no estoque e retorna a posição do produto.
//	 *
//	 * @param produto Produto a ser pesquisado no estoque, não nulo
//	 * @return -1 se o produto não for encontrado ou se o estoque está vazio ou se o
//	 *         produto é nulo.
//	 */
//	int posicao(Produto produto) {
//		if (estaVazio())
//			return -1;
//
//		if (produto == null)
//			return -1;
//
//		for (int i = 0; i < tamanhoEstoque; i++)
//			if (produto.getId() == listaProdutos[i].getId())
//				return i;
//		return -1;
//	}
//
//	/**
//	 * Adiciona um novo produto ao estoque.
//	 *
//	 * Esse método não faz nada se: o produto é nulo, ou o estoque está cheio, ou o
//	 * produto já está cadastrado.
//	 *
//	 * @param produto Produto a ser cadastrado no estoque, não nulo
//	 */
//	void cadastrar(Produto produto) {
//		if (produto == null)
//			return;
//
//		if (estaCheio())
//			return;
//
//		if (posicao(produto) >= 0)
//			return;
//
//		listaProdutos[tamanhoEstoque] = produto;
//		tamanhoEstoque++;
//	}
//
//	/**
//	 * Realiza a reposição do estoque. Esse método atualiza apenas a quantidade
//	 * atual do produto.
//	 *
//	 * Não atualiza valores totais de compra/venda ou quantidades totais
//	 * compradas/vendidas
//	 *
//	 * O método não faz nada se: o produto é nulo, ou a quantidade não é maior que
//	 * zero, ou o estoque está vazio, ou o produto ainda não foi cadastrado.
//	 *
//	 * @param produto    Produto a ser reposto no estoque, não nulo
//	 * @param quantidade Quantidade a ser acrescida, maior que zero
//	 */
//	void repor(Produto produto, int quantidade) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return;
//
//		if (!(quantidade > 0))
//			return;
//
//		if (estaVazio())
//			return;
//
//		if (aux < 0)
//			return;
//
//		listaQuantidadeAtual[aux] += quantidade;
//	}
//
//	/**
//	 * Quantidade atual de um produto no estoque.
//	 *
//	 *
//	 * @param produto Produto a ser verificado, não nulo.
//	 * @return -1 se: o produto é nulo, ou o estoque está vazio, ou se o produto não
//	 *         está cadastrado.
//	 */
//	int quantidadeAtual(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return -1;
//
//		if (estaVazio())
//			return -1;
//
//		if (aux < 0)
//			return -1;
//
//		return listaQuantidadeAtual[aux];
//	}
//
//	/**
//	 * Soma total da quantidade de produtos no estoque.
//	 *
//	 * @return -1 se o estoque está vazio.
//	 */
//	int quantidadeAtual() {
//		if (estaVazio())
//			return -1;
//
//		int aux = 0;
//
//		for (int quantidade : listaQuantidadeAtual)
//			aux += quantidade;
//
//		return aux;
//	}
//
//	/**
//	 * * Realiza a retirada do estoque. Esse método atualiza apenas a quantidade
//	 * atual do produto.
//	 *
//	 * Não atualiza valores totais de compra/venda ou quantidades totais
//	 * compradas/vendidas
//	 *
//	 * @param produto    Produto a ser feita uma retirada do estoque, não nulo.
//	 * @param quantidade Quantidade a ser retirada.
//	 */
//	void retirar(Produto produto, int quantidade) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return;
//
//		if (!(quantidade > 0))
//			return;
//
//		if (estaVazio())
//			return;
//
//		if (aux < 0)
//			return;
//
//		if (quantidade > quantidadeAtual(produto))
//			return;
//
//		listaQuantidadeAtual[aux] -= quantidade;
//	}
//
//	/**
//	 * Preço de custo atual de um produto.
//	 *
//	 * @param produto Produto a ser verificado o preço de custo.
//	 * @return -1 se produto é nulo, ou produto não está cadastrado, ou estoque está
//	 *         vazio.
//	 */
//	float precoCustoAtual(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return -1;
//
//		if (estaVazio())
//			return -1;
//
//		if (aux < 0)
//			return -1;
//
//		return listaProdutos[aux].getPrecoCusto();
//	}
//
//	/**
//	 * Soma do preço de custo de todos os produtos do estoque.
//	 *
//	 * @return -1 se o estoque está vazio.
//	 */
//	float precoCustoAtual() {
//		if (estaVazio())
//			return -1;
//
//		float aux = 0;
//
//		for (int i = 0; i < tamanhoEstoque; i++)
//			aux += precoCustoAtual(listaProdutos[i]) * quantidadeAtual(listaProdutos[i]);
//
//		return aux;
//	}
//
//	/**
//	 * Verifica se um produto está com a quantidade abaixo do mínimo do estoque.
//	 *
//	 * @param produto Produto a ser verificado, não nulo
//	 * @return true se a quantidade atual do produto está abaixo do mínimo.
//	 */
//	boolean estaAbaixoDoMinimo(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return false;
//
//		if (estaVazio())
//			return false;
//
//		if (aux < 0)
//			return false;
//
//		return listaQuantidadeAtual[posicao(produto)] < QUANTIDADE_MINIMA;
//	}
//
//	/**
//	 * Retorna a descrição dos produtos que estão com quantidade abaixo do mínimo,
//	 * separados por quebra de linha.
//	 *
//	 * Retorna uma String vazia se o estoque está vazio.
//	 */
//	String produtosComQuantidadeAbaixoMinimo() {
//		if (estaVazio())
//			return "";
//
//		String aux = "";
//		for (Produto produto : listaProdutos)
//			if (estaAbaixoDoMinimo(produto))
//				aux += produto.getDescricao() + "\n";
//
//		return aux;
//	}
//
//	/**
//	 * Registra uma compra de um produto com uma determinada quantidade. Atualiza os
//	 * valores atuais e históricos.
//	 *
//	 * @param quantidade maior ou igual a 1
//	 */
//	void registrarCompra(Produto produto, int quantidade) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return;
//
//		if (quantidade < 1)
//			return;
//
//		if (estaVazio())
//			return;
//
//		if (aux < 0)
//			return;
//
//		repor(produto, quantidade);
//		listaTotalUnidadesCompradas[aux] += quantidade;
//		listaTotalCustoCompra[aux] += quantidade * listaProdutos[aux].getPrecoCusto();
//	}
//
//	/**
//	 * Total histórico de unidades compradas de um produto.
//	 *
//	 * @return -1 Se o produto é nulo, ou o estoque está vazio ou o produto não está
//	 *         cadastrado.
//	 */
//	int totalUnidadesCompradas(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return -1;
//
//		if (estaVazio())
//			return -1;
//
//		if (aux < 0)
//			return -1;
//
//		return listaTotalUnidadesCompradas[aux];
//	}
//
//	/**
//	 * Total do custo de compra de um produto.
//	 *
//	 */
//	float totalCustoCompra(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return -1;
//
//		if (estaVazio())
//			return -1;
//
//		if (aux < 0)
//			return -1;
//
//		return listaTotalCustoCompra[aux];
//	}
//
//	/**
//	 * Total histórico de unidades vendidas de um produto.
//	 *
//	 * @param produto não nulo
//	 * @return
//	 */
//	int totalUnidadesVendidas(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return -1;
//
//		if (estaVazio())
//			return -1;
//
//		if (aux < 0)
//			return -1;
//
//		return listaTotalUnidadesVendidas[aux];
//	}
//
//	/**
//	 * Total histórico do faturamento de um produto
//	 *
//	 * @param produto não nulo
//	 * @return
//	 */
//	float totalFaturamento(Produto produto) {
//		int aux = posicao(produto);
//
//		if (produto == null)
//			return -1;
//
//		if (estaVazio())
//			return -1;
//
//		if (aux < 0)
//			return -1;
//
//		return listaTotalFaturamento[aux];
//	}


