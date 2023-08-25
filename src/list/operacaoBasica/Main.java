package list.operacaoBasica;

public class Main {
    public static void main(String[] args) {



        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotaldeTarefas());

        listaTarefa.adicionaTarefa("Tarefa 1");
        listaTarefa.adicionaTarefa("Tarefa 1");
        listaTarefa.adicionaTarefa("Tarefa 2");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotaldeTarefas());

        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotaldeTarefas());

        listaTarefa.obterDescricoesTarefas();
    }
}