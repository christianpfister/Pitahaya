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
 * Repository für alle Stakeholder.
 * Hier werden alle Funtkionen für die DB-Operationen zu Stakeholder implementiert.
 * @author naefp
 *
 */


public class StakeholderRepository {
	
	private final Logger log = LoggerFactory.getLogger(ItemRepository.class);
	
	/**
	 * Liefert alle Stakeholder in der Datenbank
	 * @return Collection aller Items
	 */

	public Collection<Stakeholder> getAll(){
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from projekt_stakeholder");
			ResultSet rs = stmt.executeQuery();
			return mapStakeholder(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}
	


	private static Collection<Stakeholder> mapStakeholder(ResultSet rs) throws SQLException 
	{
		LinkedList<Stakeholder> list = new LinkedList<Stakeholder>();
		while(rs.next())
		{
			Stakeholder i = new Stakeholder(rs.getInt("idStakeholder"),rs.getString("Rolle_Desc"));			
		
			
			list.add(i);
		}
		return list;
	}
}
