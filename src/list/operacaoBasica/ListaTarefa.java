package list.operacaoBasica;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> lista;


    public ListaTarefa()
    {
        this.lista = new ArrayList<Tarefa>();
    }

    public void adicionarTarefa(String descricao)
    {
        lista.add(new Tarefa(descricao));
    }

        public void removerTarefa(String descricao)
        {
            List<Tarefa> listaParaRemover = new ArrayList<>();
            if (!lista.isEmpty())
            {

                for (Tarefa t : lista)
                {
                    if (t.getDescricao().equalsIgnoreCase(descricao))
                    {
                        listaParaRemover.add(t);
                    }

                }
                lista.removeAll(listaParaRemover);

            }else
            {
                System.out.println("A lista est[a vazia!!");
            }
        }


    public int obterNumeroTotalTarefas()
    {
        return lista.size();
    }


    public void obterDescricoesTarefas()
    {
        if(!lista.isEmpty())
        {
            System.out.println(lista);
        } else
        {
            System.out.println("A lista esta vazia!!");
        }

    }



    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();
    }

}
