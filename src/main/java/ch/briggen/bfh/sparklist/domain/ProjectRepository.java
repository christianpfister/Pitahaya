package ch.briggen.bfh.sparklist.domain;

import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Repository für alle Items.
 * Hier werden alle Funtkionen für die DB-Operationen zu Projekt implementiert.
 * @author gilbaumann
 *
 */


public class ProjectRepository {
	
	private final Logger log = LoggerFactory.getLogger(ItemRepository.class);
	
	/**
	 * Liefert alle Projekte in der Datenbank
	 * @return Collection aller Items
	 */

	public Collection<Projekt> getAll(){
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from projekt_overview");
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}
	
	/**
	 * Liefert ein Projekt mit der angegeben ID zurück
	 * @params id des Projekts
	 * @return Projekt oder Null
	 */
	
	public Projekt getById(int id){
		log.trace("getById" + id);
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from projekt_overview where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}

	}
}
