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
            String lName = request.getParameter("lastName");
            person.setLastName(lName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }

        try {
            String fname = request.getParameter("name");
            person.setFirstName(fname);
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
            errors.add(e.getMessage());
        }

        try {
            String bDay = request.getParameter("birthday");
            LocalDate birthday = LocalDate.parse(bDay);
            person.setBirthday(birthday);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }

        try {
            String password = request.getParameter("password");
            String passwordrep = request.getParameter("passwordrep");
            if (!password.equals(passwordrep)) {
                throw new IllegalArgumentException("Passwords must match!");
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
