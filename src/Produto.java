public class Produto {

    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("O preço não pode ser negativo. Preço mantido em R$ " + this.preco);
            return;
        }
        this.preco = preco;
        System.out.println("Preço definido em R$ " + this.preco);
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Informe uma quantidade maior que zero para adicionar.");
            return;
        }
        quantidadeEstoque += qtd;
        System.out.println("OK " + qtd + " unidade(s) adicionada(s). Estoque atual: " + quantidadeEstoque);
    }

    public void removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Informe uma quantidade maior que zero para remover.");
            return;
        }
        if (qtd > quantidadeEstoque) {
            System.out.println("Estoque insuficiente. Disponível: " + quantidadeEstoque + " unidade(s).");
            return;
        }
        quantidadeEstoque -= qtd;
        System.out.println("OK " + qtd + " unidade(s) removida(s). Estoque atual: " + quantidadeEstoque);
    }

    public double calcularValorTotalEstoque() {
        return preco * quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto: " + nome
                + " | Preço: R$ " + preco
                + " | Estoque: " + quantidadeEstoque + " unidade(s)"
                + " | Valor Total: R$ " + calcularValorTotalEstoque();
    }
}