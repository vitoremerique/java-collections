package list.ordenacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {

    private List<Integer> listaNumeros;

    public OrdenacaoNumeros() {
        this.listaNumeros = new ArrayList<>();
    }


    public void adicionarNumero(int numero){
        listaNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> asc = new ArrayList<>(listaNumeros);
        if(!listaNumeros.isEmpty()){
            Collections.sort(asc);
            return asc;
        }else {
            throw  new RuntimeException("Lista vazia!");
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> desc = new ArrayList<>(listaNumeros);
        if(!listaNumeros.isEmpty()){
            desc.sort(Collections.reverseOrder());
            return desc;
        }else {
            throw  new RuntimeException("Lista vazia!");
        }
    }

    public void exibirNumeros(){
        if (!listaNumeros.isEmpty()){
            System.out.println(listaNumeros);
        }else {
            throw new RuntimeException("Lista vazia!!!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);
        numeros.exibirNumeros();

        System.out.println(numeros.ordenarAscendente());
        numeros.exibirNumeros();

        System.out.println(numeros.ordenarDescendente());
        numeros.exibirNumeros();
    }
}
