package ch.briggen.bfh.sparklist;

import static spark.Spark.get;
import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.web.DbSchemaListController;
import ch.briggen.bfh.sparklist.web.GetNameController;
import ch.briggen.bfh.sparklist.web.ProjektDetailController;
import ch.briggen.bfh.sparklist.web.ProjektManagementRootController;
import ch.briggen.bfh.sparklist.web.ProjektNewController;
import ch.briggen.sparkbase.H2SparkApp;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import com.google.gson.Gson;


public class SparkListServer extends H2SparkApp {

    final static Logger log = LoggerFactory.getLogger(SparkListServer.class);
    private final Gson jsonEngine = new Gson();

    public static void main(String[] args) {
    		
    	SparkListServer server = new SparkListServer();
    	server.configure();
    	server.run();
    }


    @Override
	protected void doConfigureHttpHandlers() {

    	//Beispiel aus Sparklist
    	//get("/", new ListManagementRootController(), new ThymeleafTemplateEngine());
    	
    	get("/projectoverview", new ProjektManagementRootController(),jsonEngine::toJson);
    	get("/projectoverviewid/:id", new ProjektDetailController(), jsonEngine::toJson);
    	post("/newprojekt", new ProjektNewController(), null);

    	
    	//post("/add", new ProjektNewController(), new ThymeleafTemplateEngine());
        get("/th", new GetNameController(), new ThymeleafTemplateEngine());
        post("/th", new DbSchemaListController(), new ThymeleafTemplateEngine());		
	}



}

