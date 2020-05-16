package br.com.fec.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fec.model.Person;
import br.com.fec.model.exception.ResourceNotFoundException;
import br.com.fec.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);

	}

	@Override
	public Person updatePerson(Person person) {
		Optional<Person> personDb = this.personRepository.findById(person.getId());
		if (personDb.isPresent()) {
			Person personUpdate = personDb.get();
			personUpdate.setId(person.getId());
			personUpdate.setFirstName(person.getFirstName());
			personUpdate.setLastName(person.getLastName());
			personUpdate.setEmail(person.getEmail());
			personUpdate.setBirthday(person.getBirthday());
			personUpdate.setStatus(person.getStatus());
			personUpdate.setSexo(person.getSexo());
			personUpdate.setProfession(person.getProfession());
			personUpdate.setCpf(person.getCpf());
			personUpdate.setAddress(person.getAddress());
			personUpdate.setCep(person.getCep());
			personUpdate.setPhoto(person.getPhoto());
			personUpdate.setPhone(person.getPhone());
			personRepository.save(personUpdate);
			return personUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + person.getId());
		}

	}

	@Override
	public List<Person> getAllPerson() {
		return this.personRepository.findAll();
	}

	@Override
	public Person getPersonById(Integer personId) {
		Optional<Person> personDb = this.personRepository.findById(personId);
		if (personDb.isPresent()) {

			return personDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id :" + personId);
		}
	}

	@Override
	public void deletePerson(Integer personId) {
		Optional<Person> personDb = this.personRepository.findById(personId);
		if (personDb.isPresent()) {

			this.personRepository.delete(personDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id :" + personId);
		}
	}

}
