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
		int id = Integer.parseInt(idString);
		Projekt i = repository.getById(id);
		return i;
	}
}
