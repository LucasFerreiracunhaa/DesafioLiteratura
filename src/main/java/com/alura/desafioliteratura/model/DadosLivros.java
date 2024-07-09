package com.alura.desafioliteratura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivros(@JsonAlias("title") String titulo,
                          @JsonAlias("authors") List<DadosAutores> autores,
                          @JsonAlias("download_count") Integer numeroDownload,
                          @JsonAlias("languages") String[] languages){

}
