package list.operacaoBasica;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> listaItens;


    public CarrinhoDeCompras() {
        this.listaItens = new ArrayList<>();
    }


    public void adicionarItem(String nome, double preco, int quantidade) {
        listaItens.add(new Item(nome, preco, quantidade));
    }

    public void removeItem(String nome) {
        List<Item> listaRemover = new ArrayList<>();
        if (!listaItens.isEmpty()) {
            for (Item i : listaItens) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    listaRemover.add(i);
                }

            }
        }
        listaItens.removeAll(listaRemover);
    }


    public double calcularValorTotal() {
        double valorTotal = 0d;

        if (!listaItens.isEmpty())
        {
           for (Item i : listaItens)
           {
                double valor = i.getPreco() * i.getQuantidade();
                valorTotal = valorTotal + valor;
            }

        }

        return valorTotal;
    }



    public void exibeItens(){
        if(!listaItens.isEmpty()){
            for(Item i : listaItens){
                System.out.println(i);
            }
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "listaItens=" + listaItens +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        carrinhoDeCompras.exibeItens();

        carrinhoDeCompras.removeItem("Lápis");
        carrinhoDeCompras.exibeItens();

        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}


