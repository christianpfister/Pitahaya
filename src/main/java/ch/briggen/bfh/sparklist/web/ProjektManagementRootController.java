package ch.briggen.bfh.sparklist.web;

import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Item;
import ch.briggen.bfh.sparklist.domain.ItemRepository;
import ch.briggen.bfh.sparklist.domain.Projekt;
import ch.briggen.bfh.sparklist.domain.ProjektRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * WWW-Controller
 * Liefert unter "/projektoverview" die ganze Projekt Liste
 * 
 * !!! Diese Version verfügt bewusst über keine Validierung / Fehlerbehandlung !!!
 * 
 * @author Marino Kilchhofer
 *
 */
public class ProjektManagementRootController implements Route {
	
	private final Logger log = LoggerFactory.getLogger(ProjektManagementRootController.class);

	ProjektRepository repository = new ProjektRepository();

	/**
	 *Liefert die Liste als Root-Seite "/" zurück 
	 */	
	public Object handle(Request request, Response response) throws Exception {
		
		//Projekte werden geladen und die Collection dann für das Template unter dem namen "projekt" bereitgestellt
		//Das Template muss dann auch den Namen "projekt" verwenden.
		log.trace("getAll from /projektoverview");
		return repository.getAll();
	}
}
