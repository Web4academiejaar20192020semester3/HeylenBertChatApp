package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStatus extends AsynchroonRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");

        if (user != null) {
            String status = user.getStatus();
            response.setContentType("application/json");
            response.getWriter().write(status);

        }
        return null;
    }

}
