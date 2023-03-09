import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTeste {
	Estoque estoque;
	Produto produtoA;
	Produto produtoB;

	@BeforeEach
	public void initEach() {
		estoque = new Estoque(1);
		produtoA = new Produto("Banana", 10, 50);
		produtoB = new Produto("Maçã", 20, 50);
	}

	@Test
	public void estoqueDeveConterPeloMenos1Produto() {
		assertThrowsExactly(InvalidParameterException.class, () -> new Estoque(0));
	}

	@Test
	public void impedirAdicaoDeProdutoSeEstoqueCheio() {
		try {
			estoque.adicionar(produtoA);
			assertThrowsExactly(Exception.class, () -> estoque.adicionar(produtoB));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
