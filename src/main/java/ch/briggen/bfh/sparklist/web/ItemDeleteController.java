package ch.briggen.bfh.sparklist.web;

/** Notiz PK, Test f�r Commit	

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.ItemRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * Controller für alle Operationen auf einzelnen Items
 * !!! Diese Version verfügt bewusst über keine Validierung / Fehlerbehandlung !!!
 * @author Marcel Briggen
 *
 */

public class ItemDeleteController implements TemplateViewRoute {
	
	private final Logger log = LoggerFactory.getLogger(ItemDeleteController.class);
		
	private ItemRepository itemRepo = new ItemRepository();
	

	/**
	 * Löscht das Item mit der übergebenen id in der Datenbank
	 * /item/delete&id=987 löscht das Item mit der Id 987 aus der Datenbank
	 * 
	 * Hört auf GET /item/delete (besser wäre POST)
	 * 
	 * @return Redirect zurück zur Liste
	 */	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		String id = request.queryParams("id");
		log.trace("GET /item/delete mit id " + id);
		
		Long longId = Long.parseLong(id);
		itemRepo.delete(longId);
		response.redirect("/");
		return new ModelAndView(null, null);
	}
}


