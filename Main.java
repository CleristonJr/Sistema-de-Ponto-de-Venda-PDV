import java.util.Scanner;

public class Main {
    private static Caixa caixa = new Caixa();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sistemaAtivo = true;

        System.out.println("=== SISTEMA PDV INICIADO ===");

        while (sistemaAtivo) {
            System.out.println("\n1. Nova Venda | 2. Ver Produtos | 0. Sair");
            System.out.print("Opção: ");
            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    iniciarVenda();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 0:
                    sistemaAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void listarProdutos() {
        System.out.println("\n--- CATÁLOGO ---");
        for (Produto p : caixa.getCatalogo()) {
            System.out.println(p);
        }
    }

    private static void iniciarVenda() {
        boolean vendendo = true;
        System.out.println("\n--- CAIXA ABERTO ---");

        while (vendendo) {
            System.out.println("\nTotal Atual: R$ " + String.format("%.2f", caixa.calcularTotal()));
            System.out.print("Digite o CÓDIGO do produto (ou 0 para finalizar): ");
            int codigo = lerInteiro();

            if (codigo == 0) {
                if (caixa.getCarrinho().isEmpty()) {
                    System.out.println("Venda cancelada (carrinho vazio).");
                    return;
                }
                vendendo = false;
                fecharConta();
            } else {
                System.out.print("Quantidade: ");
                int qtd = lerInteiro();
                if (!caixa.adicionarAoCarrinho(codigo, qtd)) {
                    System.out.println("Erro: Produto não encontrado ou estoque insuficiente.");
                }
            }
        }
    }

    private static void fecharConta() {
        double total = caixa.calcularTotal();
        System.out.println("\n--- FECHAMENTO DE CONTA ---");
        
        for (ItemVenda item : caixa.getCarrinho()) {
            System.out.println(item);
        }
        
        System.out.println("---------------------------");
        System.out.println("TOTAL A PAGAR: R$ " + String.format("%.2f", total));

        double valorPago = 0;
        while (valorPago < total) {
            System.out.print("Valor recebido: R$ ");
            try {
                valorPago = Double.parseDouble(scanner.nextLine());
                if (valorPago < total) {
                    System.out.println("Valor insuficiente. Faltam: R$ " + String.format("%.2f", total - valorPago));
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }

        double troco = valorPago - total;
        caixa.finalizarVenda();
        
        System.out.println("\nPagamento confirmado!");
        System.out.println("Troco: R$ " + String.format("%.2f", troco));
        System.out.println("Estoque atualizado. Venda concluída.");
    }

    private static int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
