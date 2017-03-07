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
	 * Bei Erfolg wird wieder auf die Detailseite redirected (z.B.: /item&id=99  wenn die id 99 war.)
	 * 
	 * Hört auf POST /item/new
	 * 
	 * @return Redirect zurück zur Startmaske
	 */	
	@Override
	public Object handle( Request request, Response response) throws Exception {
		Gson gson = new Gson();
		
		log.trace("POST /item/new mit projektNew " + request.body());
		
		Projekt projektNew = gson.fromJson(request.body(), Projekt.class);

		log.trace("POST /item/new mit projektNew " + projektNew);
		
		//insert gibt die von der DB erstellte id zurück.
		int id = projektRepo.insert(projektNew);
		
		//die neue Id wird dem Redirect als Parameter hinzugefügt
		//der redirect erfolgt dann auf /item?id=432932
		response.redirect("/projektoverview");
		return new ModelAndView(null, null);
	}
}


