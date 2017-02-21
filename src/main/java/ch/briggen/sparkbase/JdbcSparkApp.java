package ch.briggen.sparkbase;

import static spark.Spark.before;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;

public abstract class JdbcSparkApp {

	protected abstract void doConfigureHttpHandlers();

	protected abstract void doInitializeDBServer() throws ConfigurationException;
	
	protected abstract void doInitializeDB() throws ConfigurationException;

	protected abstract String getDBDriverName();

	protected abstract String getDBConnectionString();

	protected abstract String getDBUser();

	protected abstract String getDBPassword();

	public Connection getJdbcConnection() throws SQLException {
		return DriverManager.getConnection(getDBConnectionString(), getDBUser(), getDBPassword());
	}

	final static Logger log = LoggerFactory.getLogger(JdbcSparkApp.class);
	private static JdbcSparkApp APPLICATION = null;

	public final void configure() {
		log.debug("Starting configuration");
		APPLICATION = this;
		
		doInitializeDBServer();
		doInitializeDB();
	}
	
	public final void run() {
		doInitializeHttpServer();
		doConfigureHttpHandlers();
		log.debug("Running...");
	}

	protected void doInitializeHttpServer() {
		port(4567);
		log.debug("Spark http port set to 4567");

		staticFiles.location("/static");
		log.info("Place static ressources to src/main/resources/static");

		before((request, response) -> {
			log.info(requestInfoToString("", request));
		});

	}

	public static JdbcSparkApp getApplication() {
		return APPLICATION;
	}

	public static String requestInfoToString(String message, Request request) {
		StringBuilder sb = new StringBuilder();
		sb.append(message);
		sb.append(request.requestMethod());
		sb.append(" " + request.url());
		// sb.append(" " + request.body());
		// do not read request.body() as it will consume the inputstream!!
		return sb.toString();
	}

}
