public class ItemEstoque {
    public int totalUnidadeCompradas = 0;
    public int totalUnidadesVendidas = 0;
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto) {
        this.produto = produto;
    }

    public void compraDeItem(int quantidade){
        if (quantidade > 0){

            totalUnidadeCompradas += quantidade;
            this.quantidade++;
        }
    }

    public void retirarItem(int quantidade, boolean venda){
        if (quantidade > 0){
            this.quantidade--;

            if (venda)
                totalUnidadesVendidas += quantidade;
        }
    }
    public double getTotalCustoCompra(){
        return produto.getPrecoCusto() * totalUnidadeCompradas;
    }

    public double getTotalFaturado(){
        return produto.getPrecoVenda() * totalUnidadesVendidas;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
