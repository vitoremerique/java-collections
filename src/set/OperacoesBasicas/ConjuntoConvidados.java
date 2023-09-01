package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> listaConvidados;

    public ConjuntoConvidados() {
        this.listaConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        listaConvidados.add(new Convidado(nome,codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int CodConvite){
        Convidado convidadoRemover = null;
        if(!listaConvidados.isEmpty()){
            for(Convidado convidado : listaConvidados){
                if(convidado.getCodigo() == CodConvite) {
                    convidadoRemover = convidado;
                    break;
                }
            }
        }
        listaConvidados.remove(convidadoRemover);
    }

    public int contarConvidados(){
        return listaConvidados.size();
    }

    public void exibirConvidados(){
        if(!listaConvidados.isEmpty()){
            System.out.println(listaConvidados);
        }else{
            throw new RuntimeException("Lista vazia!!");
        }
    }

    @Override
    public String toString() {
        return "ConjuntoConvidados{" +
                "listaConvidados=" + listaConvidados +
                '}';
    }


    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 1236);

        conjuntoConvidados.exibirConvidados();

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1236);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");
        conjuntoConvidados.adicionarConvidado("Convidado 5",1236);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.exibirConvidados();
    }
}
