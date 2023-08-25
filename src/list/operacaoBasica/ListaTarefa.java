package list.operacaoBasica;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> lista;


    public ListaTarefa()
    {
        this.lista = new ArrayList<Tarefa>();
    }

    public void adicionaTarefa(String descricao)
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


    public int obterNumeroTotaldeTarefas()
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





}
