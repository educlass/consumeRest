package com.edu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.edu.model.Curso;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
//			Curso curso = restTemplate.getForObject("http://localhost:8090/postrest-0.0.1-SNAPSHOT/cursos/1", Curso.class);
			Curso curso = restTemplate.getForObject("http://localhost:8080/cursos/1", Curso.class);
			
//			restTemplate.delete("http://localhost:8090/postrest-0.0.1-SNAPSHOT/cursos/2");
			
//			restTemplate.headForHeaders("");
			
			curso.setNome("ALTERADO");
			
			Map<String, String> params = new HashMap<String, String>();
		    params.put("id", "1");
			
			restTemplate.put("http://localhost:8080/cursos/1", curso);
			
			curso = restTemplate.getForObject("http://localhost:8080/cursos/1", Curso.class);
			System.out.println(curso.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
