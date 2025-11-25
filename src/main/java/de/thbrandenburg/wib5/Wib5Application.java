package de.thbrandenburg.wib5;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Wib5Application {

	@Autowired
	TutorRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Wib5Application.class, args);
	}

	//neuer Tutor
	@PostMapping(path = "/tutors", consumes = "application/json")
	public String createTutor(@RequestBody String body) {
		Gson gson = new Gson();
		Tutor tutor = gson.fromJson(body, Tutor.class);
		repository.save(tutor);
		return "Created tutor: " + tutor.getId();
	}
	//Alle Tutoren ausgeben
	@GetMapping(path = "/tutors", produces = "application/json")
	public String listTutors() {
		List<Tutor> allTutors = repository.findAll();
		Gson gson = new Gson();
		return gson.toJson(allTutors);
	}

	// Tutor nach ID ausgeben
	@CrossOrigin
	@GetMapping(path="/tutors/{id}", produces = "application/json")
	public String getTutorById(@PathVariable("id") Long id) {
		Tutor tutor = repository.findById(id);
		if (tutor != null) {
			Gson gson = new Gson();
			return gson.toJson(tutor);
		} else {
			return "{}";
		}
	}
	//Tutor nach ID löschen
	@DeleteMapping(path = "/tutors/{id}", produces = "application/json")
		public String deleteTutor(@PathVariable("id") Long id) {
			Tutor tutor = repository.findById(id);
			if (tutor != null) {
				repository.delete(tutor);
				return "Deleted tutor with id " + id;
			} else {
				return "Tutor with id " + id + " not found.";
			}
		}

		@PutMapping(path = "/tutors/{id}", consumes = "application/json")
	public String updateTutor(@PathVariable("id") Long id, @RequestBody String body) {
		Tutor existingTutor = repository.findById(id);
		if (existingTutor != null) {
			Gson gson = new Gson();
			Tutor updatedTutor = gson.fromJson(body, Tutor.class);
			updatedTutor.setId(id);
			repository.save(updatedTutor);
			return "Updated tutor with id " + id;
		} else {
			return "Tutor with id " + id + " not found.";
		}
	}
}
