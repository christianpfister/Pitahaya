package ch.briggen.bfh.sparklist.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.sparkbase.JdbcSparkApp;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * Reads all the database schemas from the default database and outputs them (vie a template)
 * This is not a good design example as it includes the domain logic in the controller:
 * - "naked" maps for the model
 * - DB access directly in the controller.
 * This is done for simplicity reasons!
 * 
 * Template: dbschemalist.html
 * Parameters (Body & URL):
 *  - String name: the user name
 * Model:
 *  - String message: a text to output (to greet the user)
 *  - String userName: the name.
 *  - ArrayList<String>: the list of the catalogs 
 * @author MarcelBriggen
 *
 */
public class DbSchemaListController implements TemplateViewRoute
{
	final static Logger log = LoggerFactory.getLogger(DbSchemaListController.class);

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		Collection<String> schemas = new ArrayList<String>();
		String userName = request.queryParams("name");
		log.debug("userName: " + userName);
		
		Connection c = JdbcSparkApp.getApplication().getJdbcConnection();
		ResultSet r = c.createStatement().executeQuery("select * from information_schema.catalogs");
		while(r.next())
		{
			String schemaName = r.getString("catalog_name");
			schemas.add(schemaName);
			log.debug("added schema: " + schemaName);
		}
		c.close();
		
		
	    Map<String, Object> model = new HashMap<>();
	    model.put("message", "Your database schemas are");
	    model.put("userName", userName);
	    model.put("schemas", schemas);
	    
	    log.debug("returning with dbschemalist.html");
		return new ModelAndView(model, "dbschemalist");
		// dbschemalist.html is located in resources/templates
	}
	
}