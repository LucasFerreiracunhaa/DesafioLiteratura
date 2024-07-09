package com.alura.desafioliteratura.service;

public interface  IConverteDados {
    <T> T obterDados (String json , Class<T> classe);
}
