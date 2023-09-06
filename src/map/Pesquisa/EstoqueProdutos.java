package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long,Produto> estoqueProdutos;
    private double menorValorEmEstoque;

    public EstoqueProdutos() {
        this.estoqueProdutos = new HashMap<>();
    }


    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutos.put(cod, new Produto(nome,preco, quantidade));
    }

    public void exibirProdutos(){
        if(!estoqueProdutos.isEmpty()){
            System.out.println(estoqueProdutos);
        }
    }



    public double calcularValorTotalEstoque(){
    double valorTotal = 0;
    if(!estoqueProdutos.isEmpty()){
        for(Produto produto : estoqueProdutos.values()){
                valorTotal +=produto.getPreco()* produto.getQuantidade();

        }

        return valorTotal;
    }else
    {
        throw new RuntimeException("Estoque vazio!");
    }

    }



    public Produto obterProdutoMaisCaro(){
        Produto product = null;
        double produtoMaisCaro = Double.MIN_VALUE;
        if(!estoqueProdutos.isEmpty()){
            for (Produto p : estoqueProdutos.values()){
                if(p.getPreco()>produtoMaisCaro){
                    produtoMaisCaro = p.getPreco();
                    product = p;
                }
            }
            return product;
        }
        else
        {
            throw new RuntimeException("Estoque vazio!");
        }
    }


    public Produto obterProdutoMaisBarato(){
        Produto product = null;
        double produtoMaisBarato = Double.MAX_VALUE;
        if(!estoqueProdutos.isEmpty()){
            for (Produto p : estoqueProdutos.values()){
                if(p.getPreco()<produtoMaisBarato){
                    produtoMaisBarato = p.getPreco();
                    product = p;
                }
            }
            return product;
        }
        else
        {
            throw new RuntimeException("Estoque vazio!");
        }
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto product =null;
        double MaiorValorEmEstoque = Double.MIN_VALUE;
        if(!estoqueProdutos.isEmpty()){
            for(Map.Entry<Long,Produto> entry : estoqueProdutos.entrySet()){
                double valorMaximoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if(valorMaximoEmEstoque > MaiorValorEmEstoque){
                        MaiorValorEmEstoque = valorMaximoEmEstoque;
                        product = entry.getValue();
                }
            }
            return product;
        }
        else
        {
            throw new RuntimeException("Estoque vazio!");
        }
    }


    public Produto obterProdutoMenorQuantidadeValorTotalNoEstoque(){
        Produto product =null;
        menorValorEmEstoque = Double.MAX_VALUE;
        if(!estoqueProdutos.isEmpty()){
            for(Map.Entry<Long,Produto> entry : estoqueProdutos.entrySet()){
                double valorMaximoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if(valorMaximoEmEstoque < menorValorEmEstoque){
                    menorValorEmEstoque = valorMaximoEmEstoque;
                    product = entry.getValue();
                }
            }
            return product;
        }
        else
        {
            throw new RuntimeException("Estoque vazio!");
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Produto A", 1, 50.0);
        estoque.adicionarProduto(2L, "Produto B", 5, 11.0);
        estoque.adicionarProduto(3L, "Produto C", 3, 10.0);
        estoque.adicionarProduto(3L, "Produto D", 2, 4.0);

        estoque.exibirProdutos();

        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
        System.out.println("O produto mais caro e: "+ estoque.obterProdutoMaisCaro());
        System.out.println("O produto mais barato e: "+ estoque.obterProdutoMaisBarato());
        System.out.println("O produto com maior quantidade de valor em estoque "+ estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        System.out.println("O produto com menor quantidade de valor em estoque "+ estoque.obterProdutoMenorQuantidadeValorTotalNoEstoque());

    }

}
