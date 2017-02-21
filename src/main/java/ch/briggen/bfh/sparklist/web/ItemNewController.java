package ch.briggen.bfh.sparklist.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class ItemNewController implements TemplateViewRoute {
	
	private final Logger log = LoggerFactory.getLogger(ItemNewController.class);
		
	private ItemRepository itemRepo = new ItemRepository();
	
	/**
	 * Erstellt ein neues Item in der DB. Die id wird von der Datenbank erstellt.
	 * Bei Erfolg wird wieder auf die Detailseite redirected (z.B.: /item&id=99  wenn die id 99 war.)
	 * 
	 * Hört auf POST /item/new
	 * 
	 * @return Redirect zurück zur Detailmaske
	 */	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		Item itemDetail = ItemWebHelper.itemFromWeb(request);
		log.trace("POST /item/new mit itemDetail " + itemDetail);
		
		//insert gibt die von der DB erstellte id zurück.
		long id = itemRepo.insert(itemDetail);
		
		//die neue Id wird dem Redirect als Parameter hinzugefügt
		//der redirect erfolgt dann auf /item?id=432932
		response.redirect("/item?id="+id);
		return new ModelAndView(null, null);
	}
}


