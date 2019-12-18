package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFriends extends AsynchroonRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        if (user != null) {
            List<Person> friends = new ArrayList<>(user.getFriends());
            String result = this.toJson(friends);
            response.getWriter().write(result);
        }
        return null;
    }
}
