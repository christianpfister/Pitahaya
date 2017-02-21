package ch.briggen.bfh.sparklist.web;



import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.standard.expression.IStandardConversionService;

import ch.briggen.bfh.sparklist.domain.Item;
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

public class ItemEditController implements TemplateViewRoute{
	
	private final Logger log = LoggerFactory.getLogger(ItemEditController.class);
	
	
	
	private ItemRepository itemRepo = new ItemRepository();
	
	
	/**
	 * Requesthandler zum Bearbeiten eines Items. 
	 * Liefert das Formular (bzw. Template) zum bearbeiten der einzelnen Felder
	 * Wenn der id Parameter 0 ist wird beim submitten des Formulars ein neues Item erstellt (Aufruf von /item/new)
	 * Wenn der id Parameter <> 0 ist wird beim submitten des Formulars das Item mit der übergebenen id upgedated (Aufruf /item/save)
	 * Hört auf GET /item
	 * @return gibt den Namen des zu verwendenden Templates zurück. Immer "itemDetailTemplate" .
	 */
	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		String idString = request.queryParams("id");
		HashMap<String, Object> model = new HashMap<String, Object>();
				
		//TODO: check if 0 or null
		if(null == idString)
		{
			log.trace("GET /item für INSERT mit id " + idString);
			//der Submit-Button ruft /item/new auf --> INSERT
			model.put("postAction", "/item/new");
			model.put("itemDetail", new Item());

		}
		else
		{
			log.trace("GET /item für UPDATE mit id " + idString);
			//der Submit-Button ruft /item/update auf --> UPDATE
			model.put("postAction", "/item/update");
			
			//damit die bereits in der Datenbank vorhandenen Werte im Formular gezeigt werden wird es geladen und dann
			//dem Modell unter dem Namen "itemDetail" hinzugefügt. itemDetal muss dem im HTML-Template verwendeten Namen entsprechen 
			Long id = Long.parseLong(idString);
			Item i = itemRepo.getById(id);
			model.put("itemDetail", i);
		}
		
		//das Template itemDetail verwenden und dann "anzeigen".
		return new ModelAndView(model, "itemDetailTemplate");
	}
	
	
	
}


