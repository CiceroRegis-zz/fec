package br.com.fec.service;

import java.util.List;

import br.com.fec.model.Person;

public interface PersonService {
	
	Person savePerson(Person person);
	Person updatePerson(Person person);
	List<Person> getAllPerson();
	Person getPersonById(Integer id);
	void deletePerson(Integer id);
	
}
