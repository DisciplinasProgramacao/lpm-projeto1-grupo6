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
		assertEquals(0, estoque.quantidade(listaProduto[0]));
		estoque.repor(listaProduto[0], 45);
		assertEquals(45, estoque.quantidade(listaProduto[0]));
	}
}
