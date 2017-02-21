package ch.briggen.sparkbase;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class H2SparkApp extends JdbcSparkApp {

	final static Logger log = LoggerFactory.getLogger(H2SparkApp.class);

	@Override
	protected String getDBDriverName() {
		return "org.h2.Driver";
	}

	@Override
	protected String getDBConnectionString() {
		return "jdbc:h2:~/test;TRACE_LEVEL_SYSTEM_OUT=2";
	}

	@Override
	protected String getDBUser() {
		return "sa";
	}

	@Override
	protected String getDBPassword() {
		return "";
	}

	@Override
	protected void doInitializeDBServer() throws ConfigurationException {
		try {
			Class.forName(getDBDriverName());
		} catch (ClassNotFoundException e) {
			log.error("Driver " + getDBDriverName() + " not found. " + e.getMessage());
			throw new ConfigurationException("Driver " + getDBDriverName() + " not found.", e);
		}

		startH2Console();
		log.info("H2 Console started on http://localhost:8082");

	}

	private void startH2Console() throws ConfigurationException {
		try {
			// Server.startWebServer(getDBConnection());
			Server.createWebServer().start();
		} catch (SQLException sqle) {
			log.error("H2 Console Not Started " + sqle.getMessage());
			throw new ConfigurationException("H2 Console Not Started", sqle);
		}
	}
	
	@Override
	protected void doInitializeDB() throws ConfigurationException {
		ClassLoader myLoader = this.getClass().getClassLoader();
		InputStream sqlscript = myLoader.getResourceAsStream("initdatabase.sql");
		if(null == sqlscript)
		{
			log.info("no database initialization found at src/main/resources/initdatabase.sql");
		}
		else
		{
			log.info("initializing database from src/main/resources/initdatabase.sql ...");
			try {
				RunScript.execute(getJdbcConnection(),new InputStreamReader(sqlscript));
			} catch (SQLException e) {
				log.error("SQL error during db initializiation. " + e.getMessage());
				throw new ConfigurationException("SQL error during db initializiation.", e);
			}
		}
		 
	}
   

}
