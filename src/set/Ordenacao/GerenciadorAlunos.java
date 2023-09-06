package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> setAlunos;

    public GerenciadorAlunos() {
        this.setAlunos = new HashSet<>();
    }


    public void adicionarAluno(String nome, Long matricula, double media){
        setAlunos.add(new Aluno(nome,matricula,media));
    }


    public void removerAlunoPorMatricula(long matricula)
    {
       Aluno aluno = null;
        if(!setAlunos.isEmpty())
        {
            for(Aluno al : setAlunos){
                if(al.getMatricula() == matricula){
                        aluno = al;
            }

        }
    }
        setAlunos.remove(aluno);

    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunoPorNome= new TreeSet<>(setAlunos);
        if(!setAlunos.isEmpty()){
            System.out.println(alunoPorNome);

        }
        else
        {
            throw new RuntimeException("Set de alunos vazia!!");
        }
    }

    public void exibirAlunosPorNota(){
        Set<Aluno> alunoPorNotas= new TreeSet<>(new ComparetorAlunoPorNota());
        alunoPorNotas.addAll(setAlunos);

        if(!setAlunos.isEmpty()){
            System.out.println(alunoPorNotas);

        }
        else
        {
            throw new RuntimeException("Set de alunos vazia!!");
        }
    }


    public void exibirAlunos(){
        if(!setAlunos.isEmpty()){
            System.out.println(setAlunos);
        }
        else
        {
            throw new RuntimeException("Set de alunos vazia!!");
        }
    }


    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Aluno 1", 123456l, 6d);
        gerenciadorAlunos.adicionarAluno("Aluno 2", 1234567l, 8d);
        gerenciadorAlunos.adicionarAluno("Aluno 3", 12345678l, 1d);
        gerenciadorAlunos.adicionarAluno("Aluno 4", 123456789l, 9d);
        System.out.println(gerenciadorAlunos.setAlunos);

        gerenciadorAlunos.removerAlunoPorMatricula(000l);
        gerenciadorAlunos.removerAlunoPorMatricula(123456789l);
        System.out.println(gerenciadorAlunos.setAlunos);

        gerenciadorAlunos.exibirAlunosPorNome();

        gerenciadorAlunos.exibirAlunosPorNota();
    }

}
