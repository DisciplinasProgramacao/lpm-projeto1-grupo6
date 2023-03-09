import java.security.InvalidParameterException;

import javax.naming.SizeLimitExceededException;

public class Estoque {
	private Produto[] listaProduto;
	private int tamanho;
	private int[] listaQuantidade;

	public Estoque(int tamanho) {
		if (tamanho < 1)
			throw new InvalidParameterException("Erro ao criar estoque: O estoque deve ter pelo menos 1 produto");

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

	public boolean produtoCadastrado(Produto produto) {
		return indexProduto(produto) != -1;
	}

	public int quantidade(Produto produto) {
		return listaQuantidade[indexProduto(produto)];
	}

	public void cadastrar(Produto produto) throws SizeLimitExceededException {
		if (estaCheio()) {
			throw new SizeLimitExceededException("Erro ao cadastrar produto: O estoque está cheio!");
		}

		listaProduto[tamanho] = produto;
		listaQuantidade[tamanho] = 0;
		tamanho++;
	}

	public void repor(Produto produto, int quantidade) {
		if (produtoCadastrado(produto))
			listaQuantidade[indexProduto(produto)] += quantidade;
	}
}
