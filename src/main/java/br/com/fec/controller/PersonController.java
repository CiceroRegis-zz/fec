package br.com.fec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fec.model.Person;
import br.com.fec.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAllPerson() {
		return ResponseEntity.ok().body(personService.getAllPerson());
	}
	
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(personService.getPersonById(id));
	}	
	

	@PostMapping("/persons")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		return ResponseEntity.ok(this.personService.savePerson(person));

	}

	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person) {
		person.setId(id);
		return ResponseEntity.ok(this.personService.updatePerson(person));
	}

	@DeleteMapping("/persons/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable Integer id) {
		this.personService.deletePerson(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
	}

}
