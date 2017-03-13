package ch.briggen.bfh.sparklist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import ch.briggen.bfh.sparklist.domain.Projekt;
import ch.briggen.bfh.sparklist.domain.ProjektRepository;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProjektDeleteController implements Route{
	
	private final Logger log = LoggerFactory.getLogger(ProjektNewController.class);
	ProjektRepository projektRepo = new ProjektRepository();
	private final Gson jsonParser = new Gson();

	
	/**
	 * Löscht das Projekt anhand der idProjekt in der DB und gibt die ProjektOverview zurück
	 */
	@Override
	public Object handle(Request request, Response response) throws Exception {
		
		log.trace("Projekt löschen mit ID " + request.queryParams("idProjekt"));
		
		Projekt i = jsonParser.fromJson(request.body(), Projekt.class);
		log.trace("Projekt löschen mit ID " + i.getIdProjekt());
		projektRepo.deleteProjekt(i);
		
		return projektRepo.getAll();
	}

}
