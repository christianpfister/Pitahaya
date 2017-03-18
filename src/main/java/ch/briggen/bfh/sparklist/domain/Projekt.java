package ch.briggen.bfh.sparklist.domain;

public class Projekt {
	private int idProjekt;
	private String idProjektleiter;
	private int idProjektdetails;
	private int idProjektstatus;
	private String Projekt_TITLE;
	private String Projekt_DESC;
	private String Projektstatus_DESC;
	
	/**
	 * Defaultkonstruktor für die Verwendung in einem Controller
	 */
	public Projekt()
	{
	
	}
	
	/**
	 * Konstruktor
	 * @param id Eindeutige Id
	 * @param name Name des eintrags in der Liste
	 * @param quantity Menge
	 */

	public Projekt(int idProjekt, String idProjektleiter, int idProjektdetails, int idProjektstatus, String projekt_TITLE, String projekt_DESC,
			String projektstatus_DESC) {
		super();
		this.idProjekt = idProjekt;
		this.idProjektleiter = idProjektleiter;
		this.idProjektdetails = idProjektdetails;
		this.idProjektstatus = idProjektstatus;
		this.Projekt_TITLE = projekt_TITLE;
		this.Projekt_DESC = projekt_DESC;
		this.Projektstatus_DESC = projektstatus_DESC;
	}

	public Projekt(String Projekt_TTITLE, String Projekt_DESC, String Projektstatus_DESC) {
		this.Projekt_TITLE = Projekt_TITLE;
		this.Projekt_DESC = Projekt_DESC;
	}

	public int getIdProjekt() {
		return idProjekt;
	}

	public void setIdProjekt(int idProjekt) {
		this.idProjekt = idProjekt;
	}

	public String getIdProjektleiter() {
		return idProjektleiter;
	}

	public void setIdProjektleiter(String idProjektleiter) {
		this.idProjektleiter = idProjektleiter;
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
