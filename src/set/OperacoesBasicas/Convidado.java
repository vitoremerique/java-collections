package set.OperacoesBasicas;

import java.util.Objects;

public class Convidado {
    private String nome;
    private int Codigo;

    public Convidado(String nome, int codigo) {
        this.nome = nome;
        Codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return Codigo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convidado convidado)) return false;
        return getCodigo() == convidado.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", Codigo=" + Codigo +
                '}';
    }
}
