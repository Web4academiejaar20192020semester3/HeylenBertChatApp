package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PersonService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonService personService = new PersonService();
	private ControllerFactory controllerFactory = new ControllerFactory();

	public Controller() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);


	}
	protected void doOptions(HttpServletRequest request,
							 HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		response.addHeader("Access-Control-Max-Age", "86400");
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        String action = request.getParameter("action");
        String destination = "index.jsp";
		Reqhandler handler = null;
        if (action != null) {
        	try {
        		handler = controllerFactory.getController(action, personService);
				destination = handler.handleRequest(request, response);
        	} 
        	catch (NotAuthorizedException e) {
        		List<String> errors = new ArrayList<String>();
        		errors.add(e.getMessage());
        		request.setAttribute("errors", errors);
        		destination="index.jsp";
        	}
        }
        if(handler instanceof AsynchReqHandler) {
        	return ;
		}

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
	}
}
