package ch.briggen.bfh.sparklist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Projekt;
import ch.briggen.bfh.sparklist.domain.ProjektRepository;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * WWW-Controller
 * Liefert unter "/projektoverviewid" das Projekt mit der aufgerufenen ID
 * 
 * !!! Diese Version verfügt bewusst über keine Validierung / Fehlerbehandlung !!!
 * 
 * @author Gil Bauman
 *
 */
public class ProjektDetailController implements Route {
	
	private final Logger log = LoggerFactory.getLogger(ProjektDetailController.class);

	ProjektRepository repository = new ProjektRepository();

	/**
	 *Liefert das Projekt anhand der ID zurück
	 */	
	public Object handle(Request request, Response response) throws Exception {
		
		String idString = request.queryParams("idProjekt");
		log.trace("Input für projektoverviewid mit ID" + idString);
		int id = Integer.parseInt(idString);
		
		Projekt i = repository.getById(id);
		
		log.trace(i.getProjekt_TITLE());
		
		return i;
	}
}
