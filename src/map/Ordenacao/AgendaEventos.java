package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEvento;

    public AgendaEventos() {
        this.agendaEvento = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        agendaEvento.put(data,new Evento(nome,atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> agendaCrescente = new TreeMap<>(agendaEvento);
        if(!agendaEvento.isEmpty()){
            System.out.println(agendaCrescente);
        }
    }

    public void obterProximoEvento()
    {
        LocalDate dataAtual = LocalDate.now();
        if (!agendaEvento.isEmpty())
        {
            Evento proximoEvento = null;
            LocalDate proximaData = null;

            Map<LocalDate, Evento> eventoTree = new TreeMap<>(agendaEvento);

            for (Map.Entry<LocalDate, Evento> entry : eventoTree.entrySet())
            {
                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual))
                {
                    proximaData = entry.getKey();
                    proximoEvento = entry.getValue();
                    System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                    break;

                }

            }
        }
    }
    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 15), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 7, 9), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JANUARY, 10), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.DECEMBER, 14), "Evento 5", "Atração 5");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.NOVEMBER, 20), "Evento 6", "Atração 6");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
