import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    //Vender produtos, retirando do estoque e fazer pedido de produtos para repor o estoque;

    public static void main(String[] args) {

        System.out.print("Digite o tamanho de seu estoque: ");
        Estoque estoqueCliente = new Estoque(sc.nextInt());
        System.out.print("Digite até quantos produtos podem ser cadastrados: ");
        Produto[] listaProduto = new Produto[sc.nextInt()];

        cadastraProduto(estoqueCliente);
        cadastraProduto(estoqueCliente);
        escolhaDeAcao(listaProduto, estoqueCliente);
    }
    private static void escolhaDeAcao(Produto[] listaProduto, Estoque estoqueCliente) {

        System.out.println("1 - Registrar venda" + "\n2 - Registrar pedido de compra" + "\n3 - Consultar quantidade de" +
                "um produto" + "\n4 - Consultar quantidade total no estoque" + "\n5 - Balanço da empresa");
        System.out.print("Digite qual operação deseja realizar: ");
        switch (sc.nextInt()) {

            case 1:
                registraVenda(listaProduto, estoqueCliente);
                break;
//            case 2:
//                registraCompra(listaProduto, estoqueCliente);
//                break;
        }
    }

    private static void registraVenda(Produto[] listaProduto, Estoque estoqueCliente) {

        int produtoAVender = estoqueCliente.posicao();

        if (!estoqueCliente.estaAbaixoDoMinimo(listaProduto[produtoAVender])) {

            estoqueCliente.registrarVenda();
            estoqueCliente.registrarVenda(listaProduto[produtoAVender], qtd);
            estoqueCliente.quantidadeAtual();
        }

    }

//    private static void registraCompra(Produto[] listaProduto, Estoque estoqueCliente) {
//        int produtoAComprar = buscaProduto(listaProduto, estoqueCliente);
//
//        if (produtoAComprar == 0){
//            System.out.println("Ainda não há esse produto cadastrado no estoque");
//            System.out.println("Cadastrar? S/N");
//            if (sc.nextLine().equals("S")){
//                cadastraProduto(listaProduto, estoqueCliente);
//
//            }
//        }
//
//        System.out.println("Digite o id do produto que devera ser comprado: ");
//        int id = sc.nextInt();
//        for (Produto produtos : listaProduto){
//            if (produtos.getId() == id){
//                for (listaProduto[])
//            }
//        }
//        estoqueCliente.registrarCompra();
//
//
//    }

    private static void cadastraProduto(Estoque estoqueCliente){

        System.out.print("Descrição do produto: ");
        sc.nextLine();
        String descricao = sc.nextLine();
        System.out.print("Preço de custo: ");
        float precoCusto = sc.nextFloat();
        System.out.print("Margem de lucro: ");
        float margemLucro = sc.nextFloat();
        Produto produto = new Produto(descricao, precoCusto, margemLucro);
        estoqueCliente.cadastrar(produto);

        System.out.println(estoqueCliente);
    }

    private static int proximoItem(Produto[] listaProduto, int item) {
        if (listaProduto[item] == null){
            return item;
        } else {
            item++;
            proximoItem(listaProduto, item);
        }

        return 0;
    }
}
