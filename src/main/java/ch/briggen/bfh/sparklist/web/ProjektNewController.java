package ch.briggen.bfh.sparklist.web;



import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;

import ch.briggen.bfh.sparklist.domain.Item;
import ch.briggen.bfh.sparklist.domain.Projekt;
import ch.briggen.bfh.sparklist.domain.ProjektRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

/**
 * Controller für alle Operationen auf einzelnen Items
 * !!! Diese Version verfügt bewusst über keine Validierung / Fehlerbehandlung !!!
 * @author Marcel Briggen
 *
 */

public class ProjektNewController implements Route{
	
	private final Logger log = LoggerFactory.getLogger(ProjektNewController.class);
		
	private ProjektRepository projektRepo = new ProjektRepository();
	
	/**
	 * Erstellt ein neues Item in der DB. Die id wird von der Datenbank erstellt.
	 * Bei Erfolg wird wieder nachm dem Auto Refresh der Projektoverview, dass neue Projekt angezeigt
	 * 
	 * Hört auf POST /newprojekt
	 * 
	 * @return ProjektOverview
	 */	
	@Override
	public Object handle( Request request, Response response) throws Exception {
		
		Gson gson = new Gson();
		
		log.trace("POST /projektnen mit Projekt " + request.body());
		
		//Mappt das Json auf ein Projekt
		Projekt projektNew = gson.fromJson(request.body(), Projekt.class);
		
		log.trace("Projekt ID:" + projektNew.getProjekt_TITLE());

		//insert gibt die von der DB erstellte id zurück.
		projektRepo.insert(projektNew);

		return projektRepo.getAll();
	}
}


