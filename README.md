# 🛒 Sistema PDV (Ponto de Venda) em Java

Um sistema de Ponto de Venda via console, desenvolvido em Java. O projeto simula o fluxo de caixa de um mercado, incluindo gestão de estoque em tempo real, carrinho de compras e cálculo de troco.

## 📋 Funcionalidades

* **Catálogo de Produtos:** Listagem de itens com preço e quantidade em estoque.
* **Gestão de Estoque:** O sistema impede a venda de itens sem estoque e dá baixa automática após a finalização da venda.
* **Carrinho de Compras:** Adição de múltiplos itens e quantidades em uma mesma transação.
* **Checkout:**
    * Cálculo automático do subtotal e total.
    * Recebimento de valores.
    * Cálculo de troco.

## 🛠️ Estrutura do Projeto

O projeto segue o padrão de Orientação a Objetos, dividindo responsabilidades:

| Arquivo | Função |
| :--- | :--- |
| `Produto.java` | **Modelo:** Define o objeto produto e controla seu próprio nível de estoque. |
| `ItemVenda.java` | **Associação:** Vincula um produto a uma quantidade específica dentro de uma venda (ex: 3x Coca-Cola). |
| `Caixa.java` | **Controlador:** Gerencia o catálogo, busca produtos e manipula o carrinho de compras atual. |
| `Main.java` | **Visualização:** Interface de texto (CLI) para interação com o operador de caixa. |

## 🚀 Como Executar

1.  Baixe os arquivos `.java` para uma pasta local.
2.  Abra o terminal nesta pasta.
3.  Compile o projeto:
    ```bash
    javac *.java
    ```
4.  Execute o sistema:
    ```bash
    java Main
    ```

## 📦 Exemplo de Uso

1.  Ao iniciar, escolha a opção **1. Nova Venda**.
2.  O sistema pedirá o **Código** do produto (ex: digite `103` para Coca-Cola).
3.  Digite a **Quantidade** desejada.
4.  Repita para quantos produtos quiser.
5.  Digite `0` no código do produto para fechar a conta.
6.  Informe o valor entregue pelo cliente para ver o troco.

---
