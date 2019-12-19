package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriend extends AsynchReqHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person) request.getSession().getAttribute("user");
        if(user != null ){
            String friendId = request.getParameter("friend");
            Person friend = getPersonService().getPerson(friendId);
            friend.addFriend(user);
            user.addFriend(friend);
        }
        return null;
    }
}
