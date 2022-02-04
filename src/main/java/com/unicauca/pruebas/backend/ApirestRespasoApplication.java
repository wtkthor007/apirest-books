package com.unicauca.pruebas.backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApirestRespasoApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ApirestRespasoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "springboot";
		for (int i = 0; i < 3; i++) {
			String passwordBCrypt =passwordEncoder.encode(password);
			System.out.println(passwordBCrypt);
		}
	}

}
