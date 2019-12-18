package controller;

import domain.Gender;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Register extends SynchroonRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String destination = "index.jsp";
        List<String> errors = new ArrayList<>();
        Person person = new Person();

        try {
            String name = request.getParameter("name");
            person.setFirstName(name);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }

        try {
            String lastName = request.getParameter("lastName");
            person.setLastName(lastName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }

        try {
            String userId = request.getParameter("email");
            person.setUserId(userId);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }

        try {
            String gender = request.getParameter("gender");
            person.setGender(Gender.valueOf(gender));
        } catch (Exception e) {
            System.out.println("gender");
            errors.add(e.getMessage());
        }

        try {
            String strBirthday = request.getParameter("birthday");
            LocalDate birthday = LocalDate.parse(strBirthday);
            person.setBirthday(birthday);
        } catch (Exception e) {
            System.out.println("birtday");
            errors.add(e.getMessage());
        }

        try {
            String password = request.getParameter("password");
            String passwordrep = request.getParameter("passwordrep");
            if (!password.equals(passwordrep)) {
                throw new IllegalArgumentException("the passwords don't match");
            }
            person.setHashedPassword(password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }

        if (errors.isEmpty()) {
            try {
                getPersonService().addPerson(person);
            } catch (Exception e) {
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
            }
        } else {
            request.setAttribute("errors", errors);
            destination = "register.jsp";
        }

        return destination;
    }
}
