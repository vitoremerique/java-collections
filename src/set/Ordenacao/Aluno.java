package set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno>{
    private  String nome;
    private Long matricula;
    private double media;

    public Aluno(String nome, Long matricula, double media) {
        this.nome = nome;
        this.matricula = matricula;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return Objects.equals(getMatricula(), aluno.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", media=" + media +
                '}';
    }

    @Override
    public int compareTo(Aluno p) {
        return nome.compareToIgnoreCase(p.getNome());
    }
}

class ComparetorAlunoPorNota implements Comparator<Aluno>{

    @Override
    public int compare(Aluno p1, Aluno p2) {
        return Double.compare(p1.getMedia(),p2.getMedia());
    }
}
