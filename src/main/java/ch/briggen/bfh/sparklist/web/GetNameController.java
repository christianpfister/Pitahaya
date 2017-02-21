package ch.briggen.bfh.sparklist.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;


/**
 * Return the page which asks for the name
 * This example returns the Thymeleaf view for a static page.
 * could also be done in /static)
 * 
 * Template: getname.html
 * @author MarcelBriggen
 *
 */
public class GetNameController implements TemplateViewRoute {
	
	final static Logger log = LoggerFactory.getLogger(GetNameController.class);

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		log.info("Returning getname and an empty HashMap.");
		return new ModelAndView(new HashMap(), "getname");
		// getname.html is located in resources/templates
		// Return an empty model. Null or an empty String crashes immediately.
	}

}
