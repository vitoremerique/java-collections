package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    List<Livro> listaLivros;

    public CatalogoLivros() {
        this.listaLivros = new ArrayList<>();
    }


    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        listaLivros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor)
    {
        List<Livro> livrosAutor = new ArrayList<>();

        if(!listaLivros.isEmpty())
        {
            for(Livro l : listaLivros){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosAutor.add(l);
                }
            }
            return livrosAutor;

        }else {
            throw  new RuntimeException("Lista vazia!!");
        }

    }


    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal)
    {
        List<Livro> livrosPorIntervalo = new ArrayList<>();
        if(!listaLivros.isEmpty())
        {
            for(Livro l : listaLivros){
                if(l.getAnoPub() >= anoInicial && l.getAnoPub() <= anoFinal){
                    livrosPorIntervalo.add(l);
                }
            }
            return livrosPorIntervalo;

        }else
        {
            throw  new RuntimeException("Lista vazia!!");
        }
    }



    public List<Livro> pesquisarPorTitulo(String titulo){
        List<Livro> ps = new ArrayList<>();
        if(!listaLivros.isEmpty()){

            for(Livro l : listaLivros){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    ps.add(l);
                }

            }

            return ps;
        }else
        {
            throw  new RuntimeException("Lista vazia!!");
        }
    }

    @Override
    public String toString() {
        return "CatalogoLivros{" +
                "listaLivros=" + listaLivros +
                '}';
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2021);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2020);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2022));

        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
    }
}
