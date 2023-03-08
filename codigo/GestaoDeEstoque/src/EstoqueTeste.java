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
	public void reporEstoqueVazio() {
		Estoque estoque = new Estoque(3);
		Produto produtoA = new Produto("Banana", 10, 50);
		assertEquals(-1, estoque.indexProduto(produtoA));
		try {
			estoque.repor(produtoA, 10);
			assertEquals(0, estoque.indexProduto(produtoA));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
