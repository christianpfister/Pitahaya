package ch.briggen.bfh.sparklist.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Item;
import spark.Request;

class ItemWebHelper {
	
	private final static Logger log = LoggerFactory.getLogger(ItemWebHelper.class);
	
	public static Item itemFromWeb(Request request)
	{
		return new Item(
				Long.parseLong(request.queryParams("itemDetail.id")),
				request.queryParams("itemDetail.name"),
				Integer.parseInt(request.queryParams("itemDetail.quantity")));
	}

}
