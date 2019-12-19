package controller;

import domain.PersonService;

public class ControllerFactory {
	
    public Reqhandler getController(String key, PersonService model) {
        return createHandler(key, model);
    }
    
	private Reqhandler createHandler(String handlerName, PersonService model) {
		Reqhandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (Reqhandler) handlerObject;
	    	handler.setModel(model);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
