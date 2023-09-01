package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> agendaContato;

    public AgendaContatos() {
        this.agendaContato = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        agendaContato.add(new Contato(nome,numero));
    }

    public void exibirContatos(){
        if(!agendaContato.isEmpty())
        {
            System.out.println(agendaContato);
        }
        else
        {
            System.out.println("Agenda Vazia!!");
        }
    }


    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatos = new HashSet<>();
        if(!agendaContato.isEmpty()){
            for(Contato cont : agendaContato){

                if(cont.getNome().startsWith(nome)){
                    contatos.add(cont);

                }

            }
            return contatos;
        }else{
            throw new RuntimeException("Agenda vazia!!");
        }

    }


    public Contato atualizarNumeroContato(String nome, int novoNumero)
    {
        Contato contatoAtualizado = null;
        if(!agendaContato.isEmpty())
        {
            for(Contato cont : agendaContato)
            {

                if(cont.getNome().equalsIgnoreCase(nome) )
                {

                   cont.setTelefone(novoNumero);
                   contatoAtualizado = cont;
                    break;
                }

            }
            return contatoAtualizado;
        }

        else
        {
            throw  new RuntimeException("O conjunto esta vazio!");
        }

    }


    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("Camila", 5665);
        agendaContatos.adicionarContato("Camila", 5665);
        agendaContatos.adicionarContato("Camila Cavalcante", 1111111);
        agendaContatos.adicionarContato("Camila DIO", 654987);
        agendaContatos.adicionarContato("Maria Silva", 1111111);

        agendaContatos.exibirContatos();

        System.out.println("Pesquisa de nome" + agendaContatos.pesquisarPorNome("Camila"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 5555555));

        agendaContatos.exibirContatos();
    }

}
