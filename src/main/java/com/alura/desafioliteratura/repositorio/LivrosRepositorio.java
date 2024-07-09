package com.alura.desafioliteratura.repositorio;

import com.alura.desafioliteratura.model.Autores;
import com.alura.desafioliteratura.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface LivrosRepositorio extends  JpaRepository <Livros, Long> {
    @Query("SELECT a FROM Livros l JOIN l.autores a ORDER BY nomeAutor")
    List<Autores> findAllAutores();

    @Query("SELECT a FROM Livros l JOIN l.autores a WHERE :ano BETWEEN a.anoDeNascimento AND a.anoDaMorte")
    List<Autores> findAutoresVivosDeterminadoAno(Integer ano);


    @Query("SELECT l FROM Livros l JOIN l.autores a WHERE l.languages = %:idioma%")
    List<Livros> findLivrosPorIdiona(String[] idioma);

}

