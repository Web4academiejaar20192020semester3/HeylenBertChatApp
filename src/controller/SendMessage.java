package controller;

import domain.Conversation;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMessage extends AsynchReqHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        if (user != null) {
            String userID = request.getParameter("userId");
            Conversation found = null;
            if (user.getFriends().contains(getPersonService().getPerson(userID))) {
                for (Conversation conversation : this.getPersonService().conversations) {
                    if ((conversation.person1.getUserId().equals(user.getUserId()) && conversation.person2.getUserId().equals(userID)) ||
                            (conversation.person2.getUserId().equals(user.getUserId()) && conversation.person1.getUserId().equals(userID))) {
                        found = conversation;
                        break;
                    }
                }
                if(found == null) {
                    found = new Conversation(user, getPersonService().getPerson(userID));
                    this.getPersonService().conversations.add(found);
                }
                if (!request.getParameter("message").isEmpty()) {
                    found.messages.add(user.getUserId() + ": " +request.getParameter("message"));

                }
            }
        }
        return null;
    }
}