import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTeste {
	private Estoque estoque;
	private Produto[] listaProduto;

	@BeforeEach
	public void initEach() {
		estoque = new Estoque(5);
		listaProduto = new Produto[5];
		listaProduto[0] = new Produto("Pão", 10, 30);
		listaProduto[1] = new Produto("Banana", 15, 35);
		listaProduto[2] = new Produto("Maçã", 20, 40);
		listaProduto[3] = new Produto("Cerveja", 25, 45);
		listaProduto[4] = new Produto("Picanha", 30, 50);
	}

	@Test
	public void produtosDevemSerCadastradosEmSequencia() {
		estoque.cadastrar(listaProduto[0]);
		estoque.cadastrar(listaProduto[1]);
		assertEquals(0, estoque.indexProduto(listaProduto[0]));
		assertEquals(1, estoque.indexProduto(listaProduto[1]));
	}

	@Test
	public void reporEstoqueIncrementaAQuantidade() {
		estoque.cadastrar(listaProduto[0]);
		assertEquals(0, estoque.quantidadeAtual(listaProduto[0]));
		estoque.repor(listaProduto[0], 45);
		assertEquals(45, estoque.quantidadeAtual(listaProduto[0]));
	}

	@Test
	public void retirarDecrementaAQuantidade() {
		estoque.cadastrar(listaProduto[4]);
		estoque.repor(listaProduto[4], 100);
		assertEquals(100, estoque.quantidadeAtual(listaProduto[4]));
		estoque.retirar(listaProduto[4], 70);
		assertEquals(30, estoque.quantidadeAtual(listaProduto[4]));
	}

	@Test
	public void quantidadeTotalDeveSomarTodosOsProdutos() {
		estoque.cadastrar(listaProduto[0]);
		estoque.cadastrar(listaProduto[1]);
		estoque.cadastrar(listaProduto[2]);
		estoque.repor(listaProduto[0], 100);
		estoque.repor(listaProduto[1], 200);
		estoque.repor(listaProduto[2], 300);
		estoque.retirar(listaProduto[2], 50);
		assertEquals(550, estoque.quantidadeAtual());
	}

	@Test
	public void precoCustoTotalDeveSomarDeTodosOsProdutosEQuantidade() {
		estoque.cadastrar(listaProduto[0]);
		estoque.cadastrar(listaProduto[1]);
		estoque.cadastrar(listaProduto[2]);
		estoque.repor(listaProduto[0], 2);
		estoque.repor(listaProduto[1], 5);
		estoque.repor(listaProduto[2], 10);
		estoque.retirar(listaProduto[2], 2);
		assertEquals(255, estoque.precoCustoAtual());
	}
}
