import java.security.InvalidParameterException;

public class Estoque {
	Produto[] produtos;

	public Estoque(int tamanho) {
		if (tamanho < 1)
			throw new InvalidParameterException("Erro ao criar estoque: O estoque deve ter pelo menos 1 produto");

		produtos = new Produto[tamanho];
	}

}
