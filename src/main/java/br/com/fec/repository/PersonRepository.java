package br.com.fec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fec.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
