public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void baixarEstoque(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            this.quantidadeEstoque -= quantidade;
        }
    }

    public boolean temEstoque(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-20s | R$ %7.2f | Est: %d", codigo, nome, preco, quantidadeEstoque);
    }
}
