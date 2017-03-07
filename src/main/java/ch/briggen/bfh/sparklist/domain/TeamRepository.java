package ch.briggen.bfh.sparklist.domain;

import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Repository für alle Teams.
 * Hier werden alle Funtkionen für die DB-Operationen zu Projekt implementiert.
 * @author gilbaumann
 *
 */


public class TeamRepository {
	
	private final Logger log = LoggerFactory.getLogger(ItemRepository.class);
	
	/**
	 * Liefert alle Teams in der Datenbank
	 * @return Collection aller Items
	 */

	public Collection<Projektteam> getAll(){
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from projekt_team");
			ResultSet rs = stmt.executeQuery();
			return mapProjektteam(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}
	


	private static Collection<Projektteam> mapProjektteam(ResultSet rs) throws SQLException 
	{
		LinkedList<Projektteam> list = new LinkedList<Projektteam>();
		while(rs.next())
		{
			Projektteam i = new Projektteam(rs.getInt("idProjektteam"),rs.getInt("idPerson"),rs.getInt("idRolle"),rs.getString("Name"),rs.getString("Vorname"),rs.getString("Strasse"), rs.getInt("Strassen_Nr"), rs.getString("Wohnort"), rs.getInt("Wohnort_PLZ"), rs.getString("idFunktion"), rs.getString("idAbteilung"));			
		
			
			list.add(i);
		}
		return list;
	}
}
