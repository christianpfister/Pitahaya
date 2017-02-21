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

public class ItemUpdateController implements TemplateViewRoute  {
	
	private final Logger log = LoggerFactory.getLogger(ItemUpdateController.class);
		
	private ItemRepository itemRepo = new ItemRepository();
	


	/**
	 * Schreibt das geänderte Item zurück in die Datenbank
	 * Bei Erfolg erfolgt ein REDIRECT zurück auf die Detailseite (/item) mit der Item-id als Parameter mit dem namen id.
	 * Validierung: Im Fehlerfall wird eine durch Spring eine Fehlerseite generiert.
	 * 
	 * Hört auf POST /item/update
	 * 
	 * @return redirect nach /item: via Browser wird /item aufgerufen, also editItem weiter oben und dann das Detailformular angezeigt.
	 */
	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		Item itemDetail = ItemWebHelper.itemFromWeb(request);
		
		log.trace("POST /item/update mit itemDetail " + itemDetail);
		
		//Speichern des Items in dann den Parameter für den Redirect abfüllen
		//der Redirect erfolgt dann z.B. auf /item&id=3 (wenn itemDetail.getId == 3 war)
		itemRepo.save(itemDetail);
		response.redirect("/item?id="+itemDetail.getId());
		return new ModelAndView(null, null);
	}
}


