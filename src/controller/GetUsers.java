package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsers extends AsynchroonRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Person> persons = getPersonService().getPersons();
        String json = toJson(persons);
        response.setContentType("application/json");
        response.getWriter().write(json);
        return null;
    }
}
