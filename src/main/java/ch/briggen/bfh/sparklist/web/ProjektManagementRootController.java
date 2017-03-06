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
import spark.TemplateViewRoute;

/**
 * WWW-Controller
 * Liefert unter "/" die ganze Liste
 * 
 * !!! Diese Version verfügt bewusst über keine Validierung / Fehlerbehandlung !!!
 * 
 * @author M. Briggen
 *
 */
public class ProjektManagementRootController implements TemplateViewRoute {
	
	private final Logger log = LoggerFactory.getLogger(ProjektManagementRootController.class);

	ProjektRepository repository = new ProjektRepository();

	/**
	 *Liefert die Liste als Root-Seite "/" zurück 
	 */	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		
		//Items werden geladen und die Collection dann für das Template unter dem namen "list" bereitgestellt
		//Das Template muss dann auch den Namen "list" verwenden.
		HashMap<String, Collection<Projekt>> model = new HashMap<String, Collection<Projekt>>();
		model.put("projekt", repository.getAll());
		
		return new ModelAndView(model, "projektTemplate");
	}
}
