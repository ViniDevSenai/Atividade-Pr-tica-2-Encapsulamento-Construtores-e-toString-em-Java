import java.util.Scanner;

public class Main {

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("CONTROLE DE ESTOQUE");


        Produto p1 = new Produto("Teclado Mecânico", 250.0, 15);

        System.out.println("\n--- 1. Estado inicial ---");
        System.out.println(p1);

        System.out.println("\n--- 2. Adicionando 5 unidades ---");
        p1.adicionarEstoque(5);

        System.out.println("\n--- 3. Tentando definir preço de -50.0 ---");
        p1.setPreco(-50.0);

        System.out.println("\n--- 4. Removendo 2 unidades ---");
        p1.removerEstoque(2);

        System.out.println("\n--- 5. Estado final ---");
        System.out.println(p1);

        menuInterativo(p1);
    }

    private static void menuInterativo(Produto produto) {
        int opcao;
        do {
            System.out.println("\n============ MENU ============");
            System.out.println("1 - Exibir produto");
            System.out.println("2 - Adicionar estoque");
            System.out.println("3 - Remover estoque");
            System.out.println("4 - Alterar preço");
            System.out.println("5 - Alterar nome");
            System.out.println("6 - Valor total do estoque");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            opcao = lerInteiro("Escolha uma opção: ");
            System.out.println();

            switch (opcao) {
                case 1 -> System.out.println(produto);
                case 2 -> produto.adicionarEstoque(lerInteiro("Quantidade a adicionar: "));
                case 3 -> produto.removerEstoque(lerInteiro("Quantidade a remover: "));
                case 4 -> produto.setPreco(lerDecimal("Novo preço (R$): "));
                case 5 -> {
                    produto.setNome(lerTexto("Novo nome: "));
                    System.out.println("[OK] Nome atualizado.");
                }
                case 6 -> System.out.println("Valor total em estoque: R$ " + produto.calcularValorTotalEstoque());
                case 0 -> System.out.println("Encerrando. Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine().trim();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDecimal(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(mensagem).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido.");
            }
        }
    }
}