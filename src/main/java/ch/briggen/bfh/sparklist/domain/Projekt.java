package ch.briggen.bfh.sparklist.domain;

public class Projekt {
	
	private Integer idProjekt;
	private Integer idProjektdetails;
	private Integer idProjektstatus;
	private String Projekt_TITLE;
	private String Projekt_DESC;
	private String Projektstatus_DESC;
	private String Name;
	private String Vorname;
	private String Rolle_Desc;
	
	/**
	 * Defaultkonstruktor für die Verwendung in einem Controller
	 * @param string6 
	 * @param string5 
	 * @param string4 
	 * @param string3 
	 * @param string2 
	 * @param string 
	 * @param k 
	 * @param j 
	 * @param i 
	 */
	public Projekt(int i, int j, int k, String string, String string2, String string3, String string4, String string5, String string6)
	{
	
	}
	
	/**
	 * Konstruktor
	 * @param id Eindeutige Id
	 * @param name Name des eintrags in der Liste
	 * @param quantity Menge
	 */

	public Projekt(int idProjekt, int idProjektdetails, int idProjektstatus, String projekt_TITLE, String projekt_DESC,
			String projektstatus_DESC) {
		super();
		this.idProjekt = idProjekt;
		this.idProjektdetails = idProjektdetails;
		this.idProjektstatus = idProjektstatus;
		this.Projekt_TITLE = projekt_TITLE;
		this.Projekt_DESC = projekt_DESC;
		this.Projektstatus_DESC = projektstatus_DESC;
	}

	public Projekt(int Projekt_TTITLE, String Projekt_DESC, String Projektstatus_DESC) {
		this.Projekt_TITLE = Projekt_TITLE;
		this.Projekt_DESC = Projekt_DESC;
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
		return Projekt_TITLE;
	}

	public void setProjekt_TITLE(String projekt_TITLE) {
		Projekt_TITLE = projekt_TITLE;
	}

	public String getProjekt_DESC() {
		return Projekt_DESC;
	}

	public void setProjekt_DESC(String projekt_DESC) {
		Projekt_DESC = projekt_DESC;
	}

	public String getProjektstatus_DESC() {
		return Projektstatus_DESC;
	}

	public void setProjektstatus_DESC(String projektstatus_DESC) {
		Projektstatus_DESC = projektstatus_DESC;
	}
}
