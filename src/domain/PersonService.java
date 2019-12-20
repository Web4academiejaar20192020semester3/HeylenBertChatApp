package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	public List<Conversation> conversations = new ArrayList<>();
	private PersonRepository personRepository = new PersonRepositoryStub();


	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}


}
