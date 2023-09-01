package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    Set<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new HashSet<>();
    }

    public void adicionarTarefa(Tarefa tarefa){
        listaTarefas.add(tarefa);
    }

    public void removerTarefa(String descricao){
       Tarefa ParaRemover = null;
        if(!listaTarefas.isEmpty())
        {
            for(Tarefa tarefa : listaTarefas){
                if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    ParaRemover = tarefa;
                    break;
                }
            }

            listaTarefas.remove(ParaRemover);
        }
        else
        {
            throw new RuntimeException("Lista de tarefas vazia!!");
        }

        if(ParaRemover == null){
            System.out.println("Tarefa nao encontrada!");
        }
    }


    public void exibirTarefas(){
        if(!listaTarefas.isEmpty()){
            System.out.println(listaTarefas);
        }
        else
        {
            System.out.println("As Tarefas nao existem!");
        }

    }

    public int contarTarefas(){
        return listaTarefas.size();
    }


    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!listaTarefas.isEmpty()){
            for(Tarefa tarefa : listaTarefas){
                if(tarefa.isTarefaConcluida() == true){
                    tarefasConcluidas.add(tarefa);
                }
            }
            return tarefasConcluidas;
        }
        else
        {
            throw new RuntimeException("Lista de tarefas vazia!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!listaTarefas.isEmpty()){
            for(Tarefa tarefa : listaTarefas){
                if(tarefa.isTarefaConcluida() == false){
                    tarefasPendentes.add(tarefa);
                }
            }
            return tarefasPendentes;
        }
        else
        {
            throw new RuntimeException("Lista de tarefas vazia");
        }
    }


    public void marcarTarefaConcluida(String descricao) {
        if (!listaTarefas.isEmpty()) {
            for (Tarefa tarefa : listaTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefa.setTarefaConcluida(true);
                    break;
                }
            }
        }
        else
        {
            throw new RuntimeException("Lista de tarefa vazia!");
        }

    }

    public void marcarTarefaPendente(String descricao) {
        if (!listaTarefas.isEmpty()) {
            for (Tarefa tarefa : listaTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefa.setTarefaConcluida(false);
                    break;
                }
            }
        }
        else
        {
            throw new RuntimeException("Lista de tarefa vazia!");
        }

    }

    @Override
    public String toString() {
        return "ListaTarefas{" +
                "listaTarefas=" + listaTarefas +
                '}';
    }

    public void limparListaTarefas(){
        if(!listaTarefas.isEmpty()){
            listaTarefas.clear();
        }else {
            System.out.println("Lista de tarefa ja esta vazia!!");
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 1"));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 2"));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 3"));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 4"));
        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Tarefa 55");
        listaTarefas.exibirTarefas();

        System.out.println("Existem " + listaTarefas.contarTarefas() + " na lista de tarefas.");

        System.out.println(listaTarefas.obterTarefasConcluidas());

        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Tarefa 2");
        listaTarefas.marcarTarefaConcluida("Tarefa 1");
        listaTarefas.exibirTarefas();
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
