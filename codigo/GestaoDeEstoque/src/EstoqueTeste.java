import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import javax.naming.SizeLimitExceededException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTeste {
	private Estoque estoque;
	private Produto[] listaProduto;

	@BeforeEach
	public void initEach() {
		estoque = new Estoque(1);
		listaProduto = new Produto[5];
		listaProduto[0] = new Produto("Pão", 10, 30);
		listaProduto[1] = new Produto("Banana", 15, 35);
		listaProduto[2] = new Produto("Maçã", 20, 40);
		listaProduto[3] = new Produto("Cerveja", 25, 45);
		listaProduto[4] = new Produto("Picanha", 30, 50);
	}

	@Test
	public void estoqueDeveConterPeloMenos1Produto() {
		assertThrowsExactly(InvalidParameterException.class, () -> new Estoque(0));
	}

	@Test
	public void impedirAdicaoDeProdutoSeEstoqueCheio() {
		try {
			estoque.cadastrar(listaProduto[0]);
			assertThrowsExactly(SizeLimitExceededException.class, () -> estoque.cadastrar(listaProduto[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void reporEstoqueIncrementaAQuantidade() {
		try {
			estoque = new Estoque(5);
			estoque.cadastrar(listaProduto[0]);
			estoque.cadastrar(listaProduto[1]);
			assertEquals(0, estoque.quantidade(listaProduto[1]));
			estoque.repor(listaProduto[1], 45);
			assertEquals(45, estoque.quantidade(listaProduto[1]));
		} catch (SizeLimitExceededException e) {
			e.printStackTrace();
		}
	}
}
