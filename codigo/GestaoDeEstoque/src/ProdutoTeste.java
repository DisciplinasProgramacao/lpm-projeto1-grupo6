import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTeste {
    Produto p; // Instancia de produto

    /**
     * Preparando para cada teste um novo produto
     */
    @BeforeEach
    public void prepare() {
        p = new Produto("Descrição para fluxo típico", 100, 30);
    }

    /**
     * Teste em prol de verificar se a descrição é aceita com MENOS de 3 caracteres.
     */
    @Test
    public void descricaoNaoPodeConterMenosDe3Caracteres() {
        assertThrowsExactly(InvalidParameterException.class, () -> new Produto("12", 20, 33));
    }

    /**
     * Teste para verificar se PRECO CUSTO nao aceita entrada MENOR ou IGUAL a ZERO.
     */
    @Test
    public void precoCustoNaoPodeSerMenorOuIgualAZero() {
        assertThrowsExactly(InvalidParameterException.class,
                () -> new Produto("Descrição básica de um produto", 0, 33));
    }

    /**
     * Teste para verificar se a MARGEM DE LUCRO nao aceita entrada MENOR que 30.
     */
    @Test
    public void margemLucroNaoPodeSerMenorQue30() {
        assertThrowsExactly(InvalidParameterException.class,
                () -> new Produto("Descrição básica de um produto", 0, 10));
    }

    /**
     * Teste para verificar se a MARGEM DE LUCRO nao aceita entrada MAIOR que 80.
     */
    @Test
    public void margemLucroNaoPodeSerMaiorQue80() {
        assertThrowsExactly(InvalidParameterException.class,
                () -> new Produto("Descrição básica de um produto", 31, 100));
    }

    /**
     * Teste para verificação para cálculo de valor de venda.
     */
    @Test
    public void precoVendaDeveResultarCalculoCorreto() {
        p.calcularValoresDeVenda();
        assertEquals(153, p.getPrecoVenda()); // 153
    }

    /**
     * Verificando se o preço de custo é igual ao inserido quando objeto criado.
     */
    @Test
    public void precoDeCustoDeveSerIGualAoInserido() {
        assertEquals(100, p.getPrecoCusto());
    }

    /**
     * Verificando se o VALOR DO LUCRO é igual ao inserido.
     */
    @Test
    public void valorLucroDeverSerIgualAoInserido() {
        assertEquals(30, p.getValorLucro(), 0.5);
    }

    /**
     * Verificando se o VALOR DOS IMPOSTOS é igual ao inserido.
     */
    @Test
    public void valorImpostosDeveSerIgualAoInserido() {
        assertEquals(23, p.getValorImpostos(), 0.5);

    }
}
