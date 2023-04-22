import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTeste {
	private Estoque estoqueCheio;
    private Produto produto;

	@BeforeEach
	public void initEach() {
		estoqueCheio = new Estoque(5);
        produto = new Produto("bala", 100, 50);
        estoqueCheio.adicionaItemEstoque(produto, 29);
    

	}

    @Test
    public void adicionouCorretamente(){
        assertEquals(29,estoqueCheio.quantidadeTotalProdutos());
    }

    @Test
    public void naoPodeRetirarMaisdoQueTem(){
        estoqueCheio.registrarRetirada(produto, 30, false);
        assertEquals(29,estoqueCheio.quantidadeTotalProdutos());
    }
//
//	@Test
//	public void reporEstoqueIncrementaAQuantidade() {
//		assertEquals(0, estoqueCheio.quantidadeAtual(listaProduto[0]));
//		estoqueCheio.repor(listaProduto[0], 45);
//		assertEquals(45, estoqueCheio.quantidadeAtual(listaProduto[0]));
//	}
//
//	@Test
//	public void retirarDecrementaAQuantidade() {
//		estoqueCheio.repor(listaProduto[4], 100);
//		assertEquals(100, estoqueCheio.quantidadeAtual(listaProduto[4]));
//		estoqueCheio.retirar(listaProduto[4], 70);
//		assertEquals(30, estoqueCheio.quantidadeAtual(listaProduto[4]));
//	}
//
//	@Test
//	public void quantidadeTotalDeveSomarTodosOsProdutos() {
//		estoqueCheio.repor(listaProduto[0], 100);
//		estoqueCheio.repor(listaProduto[1], 200);
//		estoqueCheio.repor(listaProduto[2], 300);
//		estoqueCheio.retirar(listaProduto[2], 50);
//		assertEquals(550, estoqueCheio.quantidadeAtual());
//	}
//
//	@Test
//	public void precoCustoTotalDeveSomarDeTodosOsProdutosEQuantidade() {
//		estoqueCheio.repor(listaProduto[0], 2);
//		estoqueCheio.repor(listaProduto[1], 5);
//		estoqueCheio.repor(listaProduto[2], 10);
//		estoqueCheio.retirar(listaProduto[2], 2);
//		assertEquals(255, estoqueCheio.precoCustoAtual());
//	}
//
//	@Test
//	public void verificarSeProdutoEstaComQuantidadeAbaixoDoMinimo() {
//		estoqueCheio.repor(listaProduto[0], 20);
//		assertEquals(false, estoqueCheio.estaAbaixoDoMinimo(listaProduto[0]));
//		estoqueCheio.retirar(listaProduto[0], 10);
//		assertEquals(true, estoqueCheio.estaAbaixoDoMinimo(listaProduto[0]));
//	}
//
//	@Test
//	public void verificarQuaisProdutosEstaoAbaixoDoMinimo() {
//		estoqueCheio.repor(listaProduto[0], 1000);
//		estoqueCheio.repor(listaProduto[4], 1000);
//		assertEquals("Banana\nMaçã\nCerveja\n", estoqueCheio.produtosComQuantidadeAbaixoMinimo());
//	}
//
//	@Test
//	public void valoresSaoAtualizadosAoRegistrarCompra() {
//		estoqueCheio.registrarCompra(listaProduto[0], 10);
//
//		assertEquals(10, estoqueCheio.quantidadeAtual(listaProduto[0]));
//		assertEquals(10, estoqueCheio.totalUnidadesCompradas(listaProduto[0]));
//		assertEquals(100, estoqueCheio.totalCustoCompra(listaProduto[0]));
//
//		estoqueCheio.registrarCompra(listaProduto[0], 10);
//		estoqueCheio.retirar(listaProduto[0], 5);
//
//		assertEquals(15, estoqueCheio.quantidadeAtual(listaProduto[0]));
//		assertEquals(20, estoqueCheio.totalUnidadesCompradas(listaProduto[0]));
//		assertEquals(200, estoqueCheio.totalCustoCompra(listaProduto[0]));
//	}
//
//	@Test
//	public void valoresSaoAtualizadosAoRegistrarVenda() {
//		estoqueCheio.repor(listaProduto[0], 100);
//		estoqueCheio.registrarVenda(listaProduto[0], 20);
//
//		assertEquals(80, estoqueCheio.quantidadeAtual(listaProduto[0]));
//		assertEquals(20, estoqueCheio.totalUnidadesVendidas(listaProduto[0]));
//		assertEquals(300, estoqueCheio.totalFaturamento(listaProduto[0]));
//
//		estoqueCheio.registrarVenda(listaProduto[0], 40);
//
//		assertEquals(40, estoqueCheio.quantidadeAtual(listaProduto[0]));
//		assertEquals(60, estoqueCheio.totalUnidadesVendidas(listaProduto[0]));
//		assertEquals(900, estoqueCheio.totalFaturamento(listaProduto[0]));
//	}
}
