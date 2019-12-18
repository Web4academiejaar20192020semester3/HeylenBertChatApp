package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.PersonService;
import domain.Person;
import domain.Role;

import java.io.IOException;

public interface RequestHandler {

	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	void setModel(PersonService personService);

	PersonService getPersonService();
}
