package ch.briggen.bfh.sparklist.domain;

public class Stakeholder {
	private int idStakeholder;
	private String Rolle_Desc;
	
	public Stakeholder()
	{
		
	}
	
	public Stakeholder(int idStakeholder, String Rolle_Desc)
	{
		this.idStakeholder = idStakeholder;
		this.Rolle_Desc = Rolle_Desc;
	}

	public int getIdStakeholder() {
		return idStakeholder;
	}

	public void setIdStakeholder(int idStakeholder) {
		this.idStakeholder = idStakeholder;
	}

	public String getRolle_Desc() {
		return Rolle_Desc;
	}

	public void setRolle_Desc(String rolle_Desc) {
		Rolle_Desc = rolle_Desc;
	}

}
