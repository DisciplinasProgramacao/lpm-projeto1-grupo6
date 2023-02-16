# Diagramas de classe

> Coloque aqui todas as versões do seu diagrama de classes. Cada versão deve começar com um número de dois dígitos, na ordem crescente.

## Versão atual

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

## Versões anteriores

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
