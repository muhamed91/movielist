package ch.hfu.movieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class MovieShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieShowApplication.class, args);
	}

}
