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
 * Repository für alle Items.
 * Hier werden alle Funtkionen für die DB-Operationen zu Projekt implementiert.
 * @author gilbaumann
 *
 */


public class ProjektRepository {
	
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
			return mapProjekt(rs);		
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
			return mapProjekt(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}
	/**
	 * 
	 * @param i ist ein Objekt Projekt
	 * @return id des Projekts
	 */
	public int insert(Projekt i){
		log.trace("insert" + i);
		int id = 0;
		
		
		//Projekt Id in DB schreiben
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("insert into projekt (idProjekt) values (?)");
			stmt.setInt(1, i.getIdProjekt());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			id = key.getInt(1);
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + i;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
		//Projektedetails in DB schreiben
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("insert into projektdetails (Projekt_TITLE,Projekt_DESC,idProjektstatus,idProjekt) values (?,?,?,?)");
			stmt.setString(1, i.getProjekt_TITLE());
			stmt.setString(2, i.getProjekt_DESC());
			stmt.setInt(3, i.getIdProjektstatus());
			stmt.setInt(4, i.getIdProjekt());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			id = key.getInt(1);
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + i;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
		//Projektstatus in DB schreiben
				try(Connection conn = getConnection())
				{
					PreparedStatement stmt = conn.prepareStatement("insert into projektstatus (Projektstatus_DESC) values (?)");
					stmt.setString(1, i.getProjektstatus_DESC());
					stmt.executeUpdate();
					ResultSet key = stmt.getGeneratedKeys();
					key.next();
					id = key.getInt(1);
				}
				catch(SQLException e)
				{
					String msg = "SQL error while updating item " + i;
					log.error(msg , e);
					throw new RepositoryException(msg);
				}
				
				return id;
				
		
	}
	private static Collection<Projekt> mapProjekt(ResultSet rs) throws SQLException 
	{
		LinkedList<Projekt> list = new LinkedList<Projekt>();
		while(rs.next())
		{
			Projekt i = new Projekt(rs.getInt("idProjekt"),rs.getInt("idProjektdetails"),rs.getInt("idProjektstatus"),rs.getString("Projekt_Title"),rs.getString("Projekt_DESC"),rs.getString("Projektstatus_DESC"));			
			list.add(i);
		}
		return list;
	}
}
