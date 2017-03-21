package ch.briggen.bfh.sparklist.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Item;
import ch.briggen.bfh.sparklist.domain.Projekt;
import spark.Request;

class ProjektWebHelper {
	
	private final static Logger log = LoggerFactory.getLogger(ProjektWebHelper.class);
	/**
	 * Wandelt den Request in ein Projekt um
	 * @param request enthält ein Projekt Objekt
	 */
	public static void projektFromWeb(Request request)
	{
		//return new Projekt("projektDetail.Projekt_TITLE","projektDetail.Projekt_DESC","projektDetail.Projektstatus_DESC", null);
	}

}
