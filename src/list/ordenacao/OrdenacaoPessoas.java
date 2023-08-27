package list.ordenacao;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        listaPessoas.add(new Pessoa(nome,idade,altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> ListaIdade = new ArrayList<>(listaPessoas);
        if(!listaPessoas.isEmpty()){
            Collections.sort(ListaIdade);
            return ListaIdade;
        }else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> ListaAltura = new ArrayList<>(listaPessoas);
        if(!listaPessoas.isEmpty()){
            Collections.sort(ListaAltura , new comparatorPorAltura());
            return ListaAltura;
        }else{
            throw new RuntimeException("Lista vazia");
        }
    }


    public void exibeLista(){
        if(!listaPessoas.isEmpty()){
            System.out.println(listaPessoas);
        }
    }

    @Override
    public String toString() {
        return "OrdenacaoPessoas{" +
                "listaPessoas=" + listaPessoas +
                '}';
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoa = new OrdenacaoPessoas();

        ordenacaoPessoa.adicionarPessoa("Nome 1", 20, 1.70);
        ordenacaoPessoa.adicionarPessoa("Nome 2", 30, 1.80);
        ordenacaoPessoa.adicionarPessoa("Nome 3", 25, 1.50);
        ordenacaoPessoa.adicionarPessoa("Nome 4", 17, 1.56);

        ordenacaoPessoa.exibeLista();

        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println(ordenacaoPessoa.ordenarPorAltura());


    }

}
