package ch.briggen.bfh.sparklist.domain;

import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.*;

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
 * Hier werden alle Funktionen für die DB-Operationen zu Items implementiert
 * @author Marcel Briggen
 *
 */


public class ItemRepository {
	
	private final Logger log = LoggerFactory.getLogger(ItemRepository.class);
	

	/**
	 * Liefert alle items in der Datenbank
	 * @return Collection aller Items
	 */
	public Collection<Item> getAll()  {
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select id, name, quantity from items");
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
	 * Liefert alle Items mit dem angegebenen Namen
	 * @param name
	 * @return Collection mit dem Namen "name"
	 */
	public Collection<Item> getByName(String name) {
		log.trace("getByName " + name);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select id, name, quantity from items where name=?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving items by name " + name;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
			
	}

	/**
	 * Liefert das Item mit der übergebenen Id
	 * @param id id des Item
	 * @return Item oder NULL
	 */
	public Item getById(long id) {
		log.trace("getById " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select id, name, quantity from items where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving items by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					
	}

	/**
	 * Speichert das übergebene item in der Datenbank. UPDATE.
	 * @param i
	 */
	public void save(Item i) {
		log.trace("save " + i);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("update items set name=?, quantity=? where id=?");
			stmt.setString(1, i.getName());
			stmt.setInt(2, i.getQuantity());
			stmt.setLong(3, i.getId());
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + i;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
	}

	/**
	 * Löscht das Item mit der angegebenen Id von der DB
	 * @param id Item ID
	 */
	public void delete(long id) {
		log.trace("delete " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("delete from items where id=?");
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while deleteing items by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					

	}

	/**
	 * Speichert das angegebene Item in der DB. INSERT.
	 * @param i neu zu erstellendes Item
	 * @return Liefert die von der DB generierte id des neuen Items zurück
	 */
	public long insert(Item i) {
		
		log.trace("insert " + i);

		//Integer id = jdbc.queryForObject("select IDENTITY();", Integer.class);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("insert into items (name, quantity) values (?,?)");
			stmt.setString(1, i.getName());
			stmt.setInt(2, i.getQuantity());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			Long id = key.getLong(1);
			return id;
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + i;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}

	}
	
	/**
	 * Helper zum konvertieren der Resultsets in Item-Objekte. Siehe getByXXX Methoden.
	 * @author Marcel Briggen
	 * @throws SQLException 
	 *
	 */
	private static Collection<Item> mapItems(ResultSet rs) throws SQLException 
	{
		LinkedList<Item> list = new LinkedList<Item>();
		while(rs.next())
		{
			Item i = new Item(rs.getLong("id"),rs.getString("name"),rs.getInt("quantity"));
			list.add(i);
		}
		return list;
	}

}
