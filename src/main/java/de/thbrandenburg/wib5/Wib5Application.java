package de.thbrandenburg.wib5;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Wib5Application {

	public static void main(String[] args) {
		SpringApplication.run(Wib5Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping(path = "/test", produces = "application/json")
	public String listTutors() {
		Tutor tutor = new Tutor(3, "Florian", new String[]{"Englisch", "Mathe"});
		Gson gson = new Gson();
		return gson.toJson(tutor);
	}
}
