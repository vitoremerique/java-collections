package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> setProdutos;

    public CadastroProdutos() {
        this.setProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        setProdutos.add(new Produto(cod,nome,preco,quantidade));
    }


    public Set<Produto>exibirProdutosPorNome(){
        Set<Produto>ProdutosPorNome = new TreeSet<>(setProdutos);
        if(!setProdutos.isEmpty()){
            return ProdutosPorNome;
        }
        else
        {
            throw new RuntimeException("Produtos nao encontrados");
        }

    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> ProdutosPorPreco = new TreeSet<>(new ProdutoComparatorPreco());
        ProdutosPorPreco.addAll(setProdutos);

        if(!setProdutos.isEmpty()){
            return  ProdutosPorPreco;
        }
        else
        {
            throw new RuntimeException("Produtos nao encontrados");
        }

    }


    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto 5", 15d, 5);
        cadastroProdutos.adicionarProduto(2L, "Produto 0", 20d, 10);
        cadastroProdutos.adicionarProduto(1L, "Produto 3", 10d, 2);
        cadastroProdutos.adicionarProduto(9L, "Produto 9", 2d, 2);

        System.out.println(cadastroProdutos.setProdutos);

        System.out.println("Produtos por nome: -> " +cadastroProdutos.exibirProdutosPorNome());

        System.out.println("Produtos por preco: -> "+ cadastroProdutos.exibirProdutosPorPreco());
    }


}
