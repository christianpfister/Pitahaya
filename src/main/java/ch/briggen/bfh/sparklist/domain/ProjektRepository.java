package ch.briggen.bfh.sparklist.domain;

import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Repository für alle Items. Hier werden alle Funtkionen für die DB-Operationen
 * zu Projekt implementiert.
 * 
 * @author gilbaumann
 *
 */

public class ProjektRepository {

	private final Logger log = LoggerFactory.getLogger(ItemRepository.class);

	/**
	 * Liefert alle Projekte in der Datenbank
	 * 
	 * @return Collection aller Items
	 */
	public Collection<Projekt> getAll() {
		log.trace("getAll");
		try (Connection conn = getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from projekt_overview");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			log.trace("Spaltenname: " + rsmd.getColumnName(9));
			return mapProjekt(rs);
		} catch (SQLException e) {
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}

	/**
	 * Liefert ein Projekt mit der angegeben ID zurück
	 * 
	 * @params id des Projekts
	 * @return Projekt oder Null
	 */
	public Projekt getById(int idProjekt) {
		log.trace("getById" + idProjekt);
		try (Connection conn = getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from projekt_overview where idProjekt=?");
			stmt.setInt(1, idProjekt);
			ResultSet rs = stmt.executeQuery();
			return mapProjekt(rs).iterator().next();
		} catch (SQLException e) {
			String msg = "SQL error while retreiving an Item by ID.";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}

	/**
	 * Insert Projekt Fügt ein Projekt in der DB hinzu.
	 * @params idRol setzt die ID für die Rolle Projektleiter
	 * @status setzt den Status eines neuen Projekts per Default auf 0
	 */
	public void insert(Projekt i) {
		log.trace("insert" + i.toString());
		Integer id = 0;
		Integer idPers = 0;
		Integer status = 1;
		Integer idRol = 1;

		// Projekt mit TS in DB schreiben
		try (Connection conn = getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("insert into projekt (Create_TS) values (DEFAULT)");
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			id = key.getInt(1);
			log.trace("Neuer Schlüssel " + id.toString());
		} catch (SQLException e) {
			String msg = "SQL error while inserting project " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
		

		
		// Projektedetails in DB schreiben
		try (Connection conn = getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"insert into projektdetails (Projekt_TITLE,Projekt_DESC,idProjektstatus,idProjekt) values (?,?,?,?)");
			stmt.setString(1, i.getProjekt_TITLE());
			stmt.setString(2, i.getProjekt_DESC());
			stmt.setInt(3, status);
			stmt.setInt(4, id);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			String msg = "SQL error while updating item " + i;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
		
		//Person in DB schreiben
		try (Connection conn = getConnection()){
			PreparedStatement stmt = conn.prepareStatement(
					"insert into person (Name, Vorname) values (?,?)");
			stmt.setString(1, i.getName() );
			stmt.setString(2, i.getVorname() );
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			idPers = key.getInt(1);
			log.trace("Neuer Schlüssel " + idPers.toString());
		} catch (SQLException e) {
			String msg = "SQL error while updating item " + i;
			log.error(msg, e);
			throw new RepositoryException(msg);	
		}

		
		//ID der Rolle Projektleiter ermitteln
		/**
		try (Connection conn = getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from rollen where Rolle_DESC = ?");
			stmt.setString(1, "Antragssteller");
			ResultSet rs = stmt.executeQuery();
			idRol = rs.getInt("IDROLLE");
		} catch (SQLException e) {
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
		*/

		// Projektleiter in Projektteam schreiben
		try (Connection conn = getConnection()){
			PreparedStatement stmt = conn.prepareStatement(
					"insert into projektteam (idPerson, idRolle, idProjekt) values (?,?,?)");
			stmt.setInt(1, idPers);
			stmt.setInt(2, idRol);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			String msg = "SQL error while updating item " + i;
			log.error(msg, e);
			throw new RepositoryException(msg);	
		}
	}

	public void deleteProjekt(Projekt i) {

		log.trace("löschen des Projekts " + i.getIdProjekt());
		try (Connection conn = getConnection()) {
			PreparedStatement stmt = conn
					.prepareStatement("update projekt set projekt_active = (?) where idprojekt = (?)");
			stmt.setBoolean(1, false);
			stmt.setInt(2, i.getIdProjekt());
			stmt.executeUpdate();
		} catch (SQLException e) {
			String msg = "SQL error while updating item " + i;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}

	}

	/**
	 * Mappt die Resultate einer Query auf das Objekt Projekt
	 * 
	 * @param rs
	 *            enthält das ResulSet der Query
	 * @return gib die Projekte als Collection zurück
	 * @throws SQLException
	 */
	private static Collection<Projekt> mapProjekt(ResultSet rs) throws SQLException {
		
		final Logger log = LoggerFactory.getLogger(ItemRepository.class);
		
		log.trace("Map Objekte");
		
		LinkedList<Projekt> list = new LinkedList<Projekt>();
		while (rs.next()) {
			Projekt i = new Projekt(rs.getInt("idProjekt"), rs.getInt("idProjektdetails"), rs.getInt("idProjektstatus"),
					rs.getString("Projekt_Title"), rs.getString("Projekt_DESC"), rs.getString("Projektstatus_DESC"), rs.getString("Name"), rs.getString("Vorname"), rs.getInt("IDROLLE"),rs.getInt("IDPERSON"));
			list.add(i);
		}
		return list;
	}
}
