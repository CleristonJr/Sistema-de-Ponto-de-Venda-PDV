public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return produto.getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public void processarBaixaDeEstoque() {
        produto.baixarEstoque(quantidade);
    }

    @Override
    public String toString() {
        return String.format("%-15s x%d = R$ %.2f", produto.getNome(), quantidade, getSubtotal());
    }
}
