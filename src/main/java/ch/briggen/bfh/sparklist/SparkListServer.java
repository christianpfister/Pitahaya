package ch.briggen.bfh.sparklist;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Item;
import ch.briggen.bfh.sparklist.domain.ItemRepository;
import ch.briggen.bfh.sparklist.domain.Projekt;
import ch.briggen.bfh.sparklist.domain.ProjektRepository;
import ch.briggen.bfh.sparklist.web.DbSchemaListController;
import ch.briggen.bfh.sparklist.web.GetNameController;
import ch.briggen.bfh.sparklist.web.ItemDeleteController;
import ch.briggen.bfh.sparklist.web.ItemEditController;
import ch.briggen.bfh.sparklist.web.ItemNewController;
import ch.briggen.bfh.sparklist.web.ItemUpdateController;
import ch.briggen.bfh.sparklist.web.ListManagementRootController;
import ch.briggen.bfh.sparklist.web.ProjektManagementRootController;
import ch.briggen.bfh.sparklist.web.StartScreenController;
import ch.briggen.sparkbase.H2SparkApp;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import com.google.gson.Gson;


public class SparkListServer extends H2SparkApp {

    final static Logger log = LoggerFactory.getLogger(SparkListServer.class);

    public static void main(String[] args) {
    		
    	SparkListServer server = new SparkListServer();
    	server.configure();
    	server.run();
    }


    @Override
	protected void doConfigureHttpHandlers() {
    	
    	Gson gson = new Gson();
    	HashMap<String, Collection<Projekt>> model = new HashMap<String, Collection<Projekt>>();
    	//Beispiel aus Sparklist
    	//get("/", new ListManagementRootController(), new ThymeleafTemplateEngine());
    	
    	get("/hello", (request, response) -> model.put("list", new ProjektRepository().getAll()), gson::toJson);
    	post("/add", new ProjektManagementRootController(), new ThymeleafTemplateEngine());
    	post();
    	
        get("/th", new GetNameController(), new ThymeleafTemplateEngine());
        post("/th", new DbSchemaListController(), new ThymeleafTemplateEngine());		
	}



}

