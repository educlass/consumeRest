package com.edu;

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
			
			Curso curso = restTemplate.getForObject("http://localhost:8090/postrest-0.0.1-SNAPSHOT/cursos/3", Curso.class);
			
//			restTemplate.delete("http://localhost:8090/postrest-0.0.1-SNAPSHOT/cursos/2");
			
//			restTemplate.headForHeaders("");
			
			Curso request =  new Curso();
			request.setDuracao("66");
			request.setId(1);
			request.setNome("TEste");
			
			restTemplate.put("http://localhost:8090/postrest-0.0.1-SNAPSHOT/cursos/1", request);
			
			Curso curso2 = restTemplate.getForObject("http://localhost:8090/postrest-0.0.1-SNAPSHOT/cursos/1", Curso.class);
			
			
			System.out.println(curso2.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
