package ch.briggen.bfh.sparklist.domain;

import java.sql.Connection;
import java.sql.SQLException;

import ch.briggen.sparkbase.JdbcSparkApp;

class JdbcRepositoryHelper {
	
	public static Connection getConnection() throws SQLException
	{
		return JdbcSparkApp.getApplication().getJdbcConnection();
	}

}
