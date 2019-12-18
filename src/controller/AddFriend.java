package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends AsynchroonRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person) request.getSession().getAttribute("user");
        if(user != null){
            String userId = request.getParameter("friend");
            Person friend = getPersonService().getPerson(userId);
            user.addFriend(friend);
            friend.addFriend(user);
        }
        return null;
    }
}
