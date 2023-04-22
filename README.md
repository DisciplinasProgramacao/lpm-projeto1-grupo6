[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10079236)

# Gestão de Estoque

Uma mercearia está informatizando seus processos e vai começar a modernização pela gestão de estoque.

---

## Nota base do grupo: 6

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários

- Sem descontar pontos (ainda)
    - se vão usar algo que ainda não vimos na matéria, usem direito. De que adianta uma classe de vocês mesmos gerar uma exceção e o programa principal não tratar a exceção?

### Diagrama + aderência das classes ao diagrama: 1/2 pontos 
Implementação do estoque está totalmente diferente do que está no planejado. (itemEstoque nem consta no diagrama)
### Requisitos corretamente implementados: 2/6 pontos 
	- produto (preço, estoque)
        -por que tem um arredondamento para baixo no preço de venda?
	- estoque (valor, abaixo do estoque)
        - os 2 testes que consegui escrever (dados os problemas) falharam.
	- sistema (vender, comprar, consultas)
        - só faz uma ação, impedindo de executar e cumprir requisitos

### Documentação de código: 1/3 pontos 
Falta de documentação de ItemEstoque não me deixa entender a lógica. 

    if (quantidade > 0){
        this.quantidade--;

        if (venda)
        totalUnidadesVendidas += quantidade;
    }

O que é este booleano em retirarItem? Se tem um parâmetro quantidade, porque é um -- e não um -= ?
	
Documentação praticamente só existe nos testes, que deveria ser onde é menos necessária.
### Testes (quantidade e qualidade): 2/4 pontos 
Se há itemEstoque, deveria ter um teste para itemEstoque
    
    - produto: 2/2 pontos
	- estoque+itemEstoque: 0/2 pontos (somente código comentado)
	
---

## Alunos integrantes da equipe

* Eric Rodrigues Diniz
* Luiz Felipe Vieira
* Gustavo Henrique dos Santos Riegert
* Paulo Roncarati de Souza
* Pedro Henrique Pessoa Cruz

## Professores responsáveis

* João Caram Santos de Oliveira
