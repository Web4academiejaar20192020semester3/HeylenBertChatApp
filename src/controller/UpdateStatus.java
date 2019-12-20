package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatus extends AsynchReqHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person) request.getSession().getAttribute("user");
        if(user != null){
            String status = request.getParameter("statusText");
            try {
                user.setStatus(status);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
