import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    //Vender produtos, retirando do estoque e fazer pedido de produtos para repor o estoque;

    public static void main(String[] args) {

        System.out.print("Digite até quantos produtos podem ser cadastrados: ");
        Estoque estoque = null;

        escolhaDeAcao(estoque);
    }
    private static void escolhaDeAcao(Estoque estoqueCliente) {

        if(estoqueCliente == null) {
            System.out.println("Determine o tamanho do estoque:");
            int qtd = sc.nextInt();

            estoqueCliente = new Estoque(qtd);
        }

        System.out.println("1 - Registrar venda" + "\n2 - Registrar pedido de compra" + "\n3 - Consultar quantidade de" +
                "um produto" + "\n4 - Consultar quantidade total no estoque" + "\n5 - Balanço da empresa" + "" +
                "\n6 - Cadastrar produto");
        System.out.print("Digite qual operação deseja realizar: ");
        switch (sc.nextInt()) {

            case 1:
                registraVenda(estoqueCliente);
                break;
            case 2:
                registraCompra(estoqueCliente);
                break;
            case 3:
                consultaQuantidade(estoqueCliente);
                break;
            case 4:
                consultaQuantidadeTotal(estoqueCliente);
                break;
            case 5:
                consultaBalanco(estoqueCliente);
                break;
            case 6:
                cadastraProduto(estoqueCliente);
                break;
        }
    }

    private static void registraVenda(Estoque estoqueCliente) {

        System.out.println("Digite o id do produto a ser vendido: ");
        int id = sc.nextInt();
        System.out.println("Digite a quantidade do produto");
        int quantidade = sc.nextInt();
        ItemEstoque itemEstoque = estoqueCliente.retornaItem(id);
        estoqueCliente.registrarRetirada(itemEstoque.getProduto(), quantidade, false);
    }

    private static void registraCompra(Estoque estoqueCliente) {

        System.out.println("Digite o id do produto a ser comprado: ");
        int id = sc.nextInt();
        System.out.println("Digite a quantidade do produto");
        int quantidade = sc.nextInt();
        ItemEstoque itemEstoque = estoqueCliente.retornaItem(id);
        estoqueCliente.registrarCompra(itemEstoque.getProduto(), quantidade);
    }

    private static void consultaQuantidade(Estoque estoqueCliente) {

        System.out.println("Digite o id do produto a ser consultado: ");
        int id = sc.nextInt();
        ItemEstoque itemEstoque = estoqueCliente.retornaItem(id);
        System.out.println("O item pesquisado possui" + itemEstoque.getQuantidade() + "unidades em estoque");
    }

    private static void consultaQuantidadeTotal(Estoque estoqueCliente) {

        System.out.println("Há" + estoqueCliente.quantidadeTotalProdutos() + "itens no estoque");
    }

    private static void consultaBalanco(Estoque estoqueCliente) {

        System.out.println("Há R$" + estoqueCliente.quantidadeTotalProdutos() + "em produtos");
    }

    private static void cadastraProduto(Estoque estoqueCliente){

        System.out.print("Descrição do produto: ");
        sc.nextLine();
        String descricao = sc.nextLine();
        System.out.print("Preço de custo: ");
        float precoCusto = sc.nextFloat();
        System.out.print("Margem de lucro: ");
        float margemLucro = sc.nextFloat();
        Produto produto = new Produto(descricao, precoCusto, margemLucro);
        System.out.println("Digite a quantidade que deseja adicionar:");
        int qtd = sc.nextInt();

        estoqueCliente.adicionaItemEstoque(produto,qtd);
    }
}
