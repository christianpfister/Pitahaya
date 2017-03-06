package ch.briggen.bfh.sparklist.domain;

public class Termine {
	private int idTermine;
	private int idTerminArt;
	private int Termin_Start_TS;
	private int Termin_End_TS;
	private String Termin_Title;
	private String Termin_DESC;
	
	public Termine()
	{
		
	}
	
	public Termine(int idTermine, int idTerminArt, int Termin_Start_TS, int Termin_End_TS, String Termin_Title, String Termin_DESC)
	{
		this.idTermine = idTermine;
		this.idTerminArt = idTerminArt;
		this.Termin_Start_TS = Termin_Start_TS;
		this.Termin_End_TS = Termin_End_TS;
		this.Termin_Title = Termin_Title;
		this.Termin_DESC = Termin_DESC;
	}

	public int getIdTermine() {
		return idTermine;
	}

	public void setIdTermine(int idTermine) {
		this.idTermine = idTermine;
	}

	public int getIdTerminArt() {
		return idTerminArt;
	}

	public void setIdTerminArt(int idTerminArt) {
		this.idTerminArt = idTerminArt;
	}

	public int getTermin_Start_TS() {
		return Termin_Start_TS;
	}

	public void setTermin_Start_TS(int termin_Start_TS) {
		Termin_Start_TS = termin_Start_TS;
	}

	public int getTermin_End_TS() {
		return Termin_End_TS;
	}

	public void setTermin_End_TS(int termin_End_TS) {
		Termin_End_TS = termin_End_TS;
	}

	public String getTermin_Title() {
		return Termin_Title;
	}

	public void setTermin_Title(String termin_Title) {
		Termin_Title = termin_Title;
	}

	public String getTermin_DESC() {
		return Termin_DESC;
	}

	public void setTermin_DESC(String termin_DESC) {
		Termin_DESC = termin_DESC;
	}
}
