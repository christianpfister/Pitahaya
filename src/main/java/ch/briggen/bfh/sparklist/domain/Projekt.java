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

	public Projekt(int Projekt_TTITLE, String Projekt_DESC, String Projektstatus_DESC) {
		this.projekt_TITLE = projekt_TITLE;
		this.projektstatus_DESC = Projekt_DESC;
	}

	public int getIdProjekt() {
		return idProjekt;
	}

	public void setIdProjekt(int idProjekt) {
		this.idProjekt = idProjekt;
	}

	
	public int getIdProjektdetails() {
		return idProjektdetails;
	}

	public void setIdProjektdetails(int idProjektdetails) {
		this.idProjektdetails = idProjektdetails;
	}

	public int getIdProjektstatus() {
		return idProjektstatus;
	}

	public void setIdProjektstatus(int idProjektstatus) {
		this.idProjektstatus = idProjektstatus;
	}

	public String getProjekt_TITLE() {
		return projekt_TITLE;
	}

	public void setProjekt_TITLE(String projekt_TITLE) {
		projekt_TITLE = projekt_TITLE;
	}

	public String getProjekt_DESC() {
		return projektstatus_DESC;
	}

	public void setProjekt_DESC(String projekt_DESC) {
		projektstatus_DESC = projekt_DESC;
	}

	public String getProjektstatus_DESC() {
		return projektstatus_DESC;
	}

	public void setProjektstatus_DESC(String projektstatus_DESC) {
		projektstatus_DESC = projektstatus_DESC;
	}
}
