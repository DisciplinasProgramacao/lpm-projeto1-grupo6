# Diagramas de classe

> Coloque aqui todas as versões do seu diagrama de classes. Cada versão deve começar com um número de dois dígitos, na ordem crescente.

## Versão atual

### v03

```mermaid
classDiagram
    class Produto {
      -int proximoId$
      -float PERCENTUAL_IMPOSTOS$
      -String descricao
      -float precoCusto
      -int margemLucro
      -float precoVenda
      -float valorLucro
      -float valorImpostos
      -int id
      +calcularValoresDeVenda()
    }

    class Estoque {
      -int QUANTIDADE_MINIMA$
      -int tamanhoEstoque
      -Produto[] listaProdutos
      -int[] listaQuantidadeAtual
	    - int[] listaTotalUnidadesCompradas
	    - float[] listaTotalCustoCompra
	    - int[] listaTotalUnidadesVendidas
	    - float[] listaTotalFaturamento
      +estaVazio()boolean
      +estaCheio()boolean
      +posicao(Produto: produto) int
      +cadastrar(Produto: produto) void
      +repor(Produto: produto, int: quantidade) void
      +quantidadeAtual(Produto: produto):int
      +quantidadeAtual()int
      +retirar(Produto: produto, int: quantidade)void
      +precoCustoAtual(Produto: produto) float
      +precoCustoAtual()float
      +estAbaixoDoMinimo(Produto: produto)boolean
      +produtosComQuantidadeAbaixoMinimo()String
      +registrarCompra(Produto: produto, int: quantidade)void
      +totalUnidadesCompradas(Produto: produto) int
      +totalCustoCompra(Produto: produto)float
      +registrarVenda(Produto: produto, int: quantidade) void
      +totalUnidadesVendidas(Produto produto)int
      +totalFaturamento(Produto produto)float
    }
    
    Estoque -- Produto

```

## Versões anteriores

### v02

```mermaid
classDiagram
    class Produto {
      -String descricao
      -float precoCusto
      -int margemLucro
      -float precoVenda
      -float valorLucro
      -float valorImpostos
      +Produto()
      +Produto(descricao : String, precoCusto : float, margemLucro : int)
      -calcularValores()
    }
```

### v01

```mermaid
classDiagram
    class Produto {
      +String descricao
      +float precoDeCusto
      +float precoDeVenda
      +float margemDeLucro
      +float valorDeImpostos
    }
```
