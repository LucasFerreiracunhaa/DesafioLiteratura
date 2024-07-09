package com.alura.desafioliteratura;

import com.alura.desafioliteratura.principal.Principal;
import com.alura.desafioliteratura.repositorio.LivrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioliteraturaApplication implements CommandLineRunner {
	@Autowired
	private LivrosRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(DesafioliteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();

	}
}
