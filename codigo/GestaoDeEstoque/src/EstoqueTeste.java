import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTeste {
	private Estoque estoque;
	private Produto[] lista;

	@BeforeEach
	public void initEach() {
		estoque = new Estoque(1);
		lista = new Produto[5];
		lista[0] = new Produto("Pão", 10, 30);
		lista[1] = new Produto("Banana", 15, 35);
		lista[2] = new Produto("Maçã", 20, 40);
		lista[3] = new Produto("Cerveja", 25, 45);
		lista[4] = new Produto("Picanha", 30, 50);
	}

	@Test
	public void estoqueDeveConterPeloMenos1Produto() {
		assertThrowsExactly(InvalidParameterException.class, () -> new Estoque(0));
	}

	@Test
	public void impedirAdicaoDeProdutoSeEstoqueCheio() {
		try {
			estoque.adicionar(lista[0], 0);
			assertThrowsExactly(Exception.class, () -> estoque.adicionar(lista[1], 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void quantidadeAdicionadaNaoPodeSerMenorQueZero() {
		assertThrowsExactly(InvalidParameterException.class, () -> estoque.adicionar(lista[0], -1));
	}
}
