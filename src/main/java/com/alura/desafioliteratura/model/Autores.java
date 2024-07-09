package com.alura.desafioliteratura.model;

import jakarta.persistence.*;

@Entity
@Table(name="autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomeAutor;
    private Integer anoDeNascimento;
    private Integer anoDaMorte;


    @ManyToOne
    private Livros livros;

    public Autores(){}


    public Autores(DadosAutores dadosAutor, Livros livro) {
        String[] autor = dadosAutor.nomeAutor().split(",");
        if (autor.length > 1) {
            this.nomeAutor = autor[1] + " " + autor[0];
        }else {
            this.nomeAutor = autor[0];
        }
        this.anoDeNascimento = dadosAutor.anoNascimento();
        this.anoDaMorte = dadosAutor.anoDamorte();
        this.livros = livro;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(Integer anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public Integer getAnoDaMorte() {
        return anoDaMorte;
    }

    public void setAnoDaMorte(Integer anoDaMorte) {
        this.anoDaMorte = anoDaMorte;
    }

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return
                "nomeAutor='" + nomeAutor + '\'' +
                ", anoDeNascimento=" + anoDeNascimento +
                ", anoDaMorte=" + anoDaMorte ;
    }
}
