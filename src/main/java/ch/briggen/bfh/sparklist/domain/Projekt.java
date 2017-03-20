package ch.briggen.bfh.sparklist.domain;

public class Projekt {
	
	private Integer idProjekt;
	private Integer idProjektdetails;
	private Integer idProjektstatus;
	private String projekt_TITLE;
	private String projekt_DESC;
	private String projektstatus_DESC;
	private String name;
	private String vorname;
	private String rolle_Desc;
	private Integer idPerson;
	private Integer idRolle;
		
	/**
	 * Konstruktor
	 * @param id Eindeutige Id
	 * @param name Name des eintrags in der Liste
	 * @param quantity Menge
	 */

	public Projekt(int idProjekt, int idProjektdetails, int idProjektstatus, String projekt_TITLE, String projekt_DESC,
			String projektstatus_DESC, String name, String vorname, int idPerson, int idRolle) {
		super();
		this.idProjekt = idProjekt;
		this.idProjektdetails = idProjektdetails;
		this.idProjektstatus = idProjektstatus;
		this.projekt_TITLE = projekt_TITLE;
		this.projekt_DESC = projekt_DESC;
		this.projektstatus_DESC = projektstatus_DESC;
		this.name = name;
		this.vorname = vorname;
		this.idRolle = idRolle;
		this.idPerson = idPerson;
	}
	
	public Projekt(int idProjekt, int idProjektdetails, int idProjektstatus, String projekt_TITLE, String projekt_DESC,
			String projektstatus_DESC, String name, String vorname) {
		super();
		this.idProjekt = idProjekt;
		this.idProjektdetails = idProjektdetails;
		this.idProjektstatus = idProjektstatus;
		this.projekt_TITLE = projekt_TITLE;
		this.projekt_DESC = projekt_DESC;
		this.projektstatus_DESC = projektstatus_DESC;
		this.name = name;
		this.vorname = vorname;
	}
	
	public Projekt(){
		
	}

	public Integer getIdProjekt() {
		return idProjekt;
	}

	public void setIdProjekt(Integer idProjekt) {
		this.idProjekt = idProjekt;
	}

	public Integer getIdProjektdetails() {
		return idProjektdetails;
	}

	public void setIdProjektdetails(Integer idProjektdetails) {
		this.idProjektdetails = idProjektdetails;
	}

	public Integer getIdProjektstatus() {
		return idProjektstatus;
	}

	public void setIdProjektstatus(Integer idProjektstatus) {
		this.idProjektstatus = idProjektstatus;
	}

	public String getProjekt_TITLE() {
		return projekt_TITLE;
	}

	public void setProjekt_TITLE(String projekt_TITLE) {
		this.projekt_TITLE = projekt_TITLE;
	}

	public String getProjekt_DESC() {
		return projekt_DESC;
	}

	public void setProjekt_DESC(String projekt_DESC) {
		this.projekt_DESC = projekt_DESC;
	}

	public String getProjektstatus_DESC() {
		return projektstatus_DESC;
	}

	public void setProjektstatus_DESC(String projektstatus_DESC) {
		this.projektstatus_DESC = projektstatus_DESC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getRolle_Desc() {
		return rolle_Desc;
	}

	public void setRolle_Desc(String rolle_Desc) {
		this.rolle_Desc = rolle_Desc;
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Integer getIdRolle() {
		return idRolle;
	}

	public void setIdRolle(Integer idRolle) {
		this.idRolle = idRolle;
	}
}