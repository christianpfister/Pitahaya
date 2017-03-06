package ch.briggen.bfh.sparklist;

import static spark.Spark.get;
import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Item;
import ch.briggen.bfh.sparklist.web.DbSchemaListController;
import ch.briggen.bfh.sparklist.web.GetNameController;
import ch.briggen.bfh.sparklist.web.ItemDeleteController;
import ch.briggen.bfh.sparklist.web.ItemEditController;
import ch.briggen.bfh.sparklist.web.ItemNewController;
import ch.briggen.bfh.sparklist.web.ItemUpdateController;
import ch.briggen.bfh.sparklist.web.ListManagementRootController;
import ch.briggen.bfh.sparklist.web.StartScreenController;
import ch.briggen.sparkbase.H2SparkApp;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class SparkListServer extends H2SparkApp {

    final static Logger log = LoggerFactory.getLogger(SparkListServer.class);

    public static void main(String[] args) {
    		
    	SparkListServer server = new SparkListServer();
    	server.configure();
    	server.run();
    }


    @Override
	protected void doConfigureHttpHandlers() {
    	get("/", new ListManagementRootController(), new ThymeleafTemplateEngine());
    	get("/item", new ItemEditController(), new ThymeleafTemplateEngine());
    	post("/item/update", new ItemUpdateController(), new ThymeleafTemplateEngine());
    	get("/item/delete", new ItemDeleteController(), new ThymeleafTemplateEngine());
    	post("/item/new", new ItemNewController(), new ThymeleafTemplateEngine());
    	
    	get("/start", new StartScreenController(), new ThymeleafTemplateEngine());
    	
    	
		get("/hello", (req, res) -> "Hello World");
        get("/th", new GetNameController(), new ThymeleafTemplateEngine());
        post("/th", new DbSchemaListController(), new ThymeleafTemplateEngine());		
	}



}

