import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

public class ProdutoTeste {
    @Test
    public void descricaoNaoPodeConterMenosDe3Caracteres() {
        assertThrowsExactly(Exception.class, () -> new Produto("a", 20, 33));
    }

    @Test
    public void precoCustoNaoPodeSerMenorOuIgualAZero() {
        assertThrowsExactly(Exception.class, () -> new Produto("aaa", 0, 33));
    }

    @Test
    public void margemLucroNaoPodeSerMenorQue30() {
        assertThrowsExactly(Exception.class, () -> new Produto("aaa", 0, 29));
    }

    @Test
    public void margemLucroNaoPodeSerMaiorQue80() {
        assertThrowsExactly(Exception.class, () -> new Produto("aaa", 31, 81));
    }
}
