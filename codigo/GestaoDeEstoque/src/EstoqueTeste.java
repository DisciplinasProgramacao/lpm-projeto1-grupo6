import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import org.junit.Test;

public class EstoqueTeste {
	@Test
	public void estoqueDeveConterPeloMenos1Produto() {
		assertThrowsExactly(InvalidParameterException.class, () -> new Estoque(0));
	}

}
