import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private List<Produto> catalogo;
    private List<ItemVenda> carrinho;

    public Caixa() {
        this.catalogo = new ArrayList<>();
        this.carrinho = new ArrayList<>();
        inicializarEstoque();
    }

    private void inicializarEstoque() {
        catalogo.add(new Produto(101, "Arroz 5kg", 25.90, 50));
        catalogo.add(new Produto(102, "Feijão 1kg", 8.50, 40));
        catalogo.add(new Produto(103, "Coca-Cola 2L", 9.90, 100));
        catalogo.add(new Produto(104, "Sabão em Pó", 15.30, 30));
        catalogo.add(new Produto(105, "Leite 1L", 4.20, 60));
    }

    public List<Produto> getCatalogo() {
        return catalogo;
    }

    public Produto buscarProduto(int codigo) {
        for (Produto p : catalogo) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public boolean adicionarAoCarrinho(int codigo, int quantidade) {
        Produto produto = buscarProduto(codigo);
        
        if (produto != null && produto.temEstoque(quantidade)) {
            carrinho.add(new ItemVenda(produto, quantidade));
            System.out.println("Item adicionado: " + produto.getNome());
            return true;
        }
        return false;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : carrinho) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<ItemVenda> getCarrinho() {
        return carrinho;
    }

    public void finalizarVenda() {
        for (ItemVenda item : carrinho) {
            item.processarBaixaDeEstoque();
        }
        carrinho.clear();
    }
}
