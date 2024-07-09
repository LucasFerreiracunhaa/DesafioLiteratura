package com.alura.desafioliteratura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @Column(unique = true)
        private String title;
        private String[] languages;
        private Integer downloadCount;


        @OneToMany(mappedBy = "livros",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
        private List<Autores> autores = new ArrayList<>();

        public Livros (){}

        public Livros(DadosLivros dadosLivro) {
            this.title = dadosLivro.titulo();
            this.languages = dadosLivro.languages();
            this.downloadCount = dadosLivro.numeroDownload();
            List<DadosAutores> authorsData = dadosLivro.autores().stream().toList();
            authorsData.forEach(a -> autores.add(new Autores(a,this)));

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getLanguages() {
            return languages;
        }

        public void setLanguages(String[] languages) {
            this.languages = languages;
        }

        public Integer getDownloadCount() {
            return downloadCount;
        }

        public void setDownloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
        }



        public String getPrimeiroAutor() {
            return autores.get(0).getNomeAutor();
        }


        public List<Autores> getAutores() {
            return autores;
        }

        public void setAutores(List<Autores> autores) {
            this.autores = autores;
        }

        @Override
        public String toString() {
            return
                    "Titulo: " + title +
                            " | Autores: " + autores +
                            " | Idioma: " + languages[0] +
                            " | Total de Downloads: " + downloadCount;
        }
    }