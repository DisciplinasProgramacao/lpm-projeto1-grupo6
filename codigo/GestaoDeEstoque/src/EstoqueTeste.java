import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import org.junit.Test;

public class EstoqueTeste {
	@Test
	public void estoqueDeveConterPeloMenos1Produto() {
		assertThrowsExactly(InvalidParameterException.class, () -> new Estoque(0));
	}

	@Test
	public void produtosSaoAdicionadosEmSequencia() {
		Estoque estoque = new Estoque(2);
		Produto produtoA = new Produto("Banana", 10, 50);
		Produto produtoB = new Produto("Maçã", 20, 30);
		assertEquals(-1, estoque.indexProduto(produtoA));
		assertEquals(-1, estoque.indexProduto(produtoB));
		estoque.repor(produtoA, 10);
		estoque.repor(produtoB, 10);
		assertEquals(0, estoque.indexProduto(produtoA));
		assertEquals(1, estoque.indexProduto(produtoB));
	}
}
