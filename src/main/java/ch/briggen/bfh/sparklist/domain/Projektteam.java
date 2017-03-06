package ch.briggen.bfh.sparklist.domain;

public class Projektteam {
	private int idProjektteam;
	private int idPerson;
	private int idRolle;
	private String Name;
	private String Vorname;
	private String Strasse;
	private int Strassen_Nr;
	private String Wohnort;
	private int Wohnort_PLZ;
	private String idFunktion;
	private String idAbteilung;
	
	public Projektteam()
	{
		
	}
	
	public Projektteam(int idProjektteam, int idPerson, int idRolle, String Name, String Vorname, String Strasse, int Strassen_Nr, String Wohnort, int Wohnort_PLZ, String idFunktion, String idAbteilung)
	{
		this.idProjektteam = idProjektteam;
		this.idPerson = idPerson;
		this.idRolle = idRolle;
		this.Name = Name;
		this.Vorname = Vorname;
		this.Strasse = Strasse;
		this.Strassen_Nr = Strassen_Nr;
		this.Wohnort = Wohnort;
		this.Wohnort_PLZ = Wohnort_PLZ;
		this.idFunktion = idFunktion;
		this.idAbteilung = idAbteilung;
	}

	public int getIdProjektteam() {
		return idProjektteam;
	}

	public void setIdProjektteam(int idProjektteam) {
		this.idProjektteam = idProjektteam;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public int getIdRolle() {
		return idRolle;
	}

	public void setIdRolle(int idRolle) {
		this.idRolle = idRolle;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getStrasse() {
		return Strasse;
	}

	public void setStrasse(String strasse) {
		Strasse = strasse;
	}

	public int getStrassen_Nr() {
		return Strassen_Nr;
	}

	public void setStrassen_Nr(int strassen_Nr) {
		Strassen_Nr = strassen_Nr;
	}

	public String getWohnort() {
		return Wohnort;
	}

	public void setWohnort(String wohnort) {
		Wohnort = wohnort;
	}

	public int getWohnort_PLZ() {
		return Wohnort_PLZ;
	}

	public void setWohnort_PLZ(int wohnort_PLZ) {
		Wohnort_PLZ = wohnort_PLZ;
	}

	public String getIdFunktion() {
		return idFunktion;
	}

	public void setIdFunktion(String idFunktion) {
		this.idFunktion = idFunktion;
	}

	public String getIdAbteilung() {
		return idAbteilung;
	}

	public void setIdAbteilung(String idAbteilung) {
		this.idAbteilung = idAbteilung;
	}
	
}