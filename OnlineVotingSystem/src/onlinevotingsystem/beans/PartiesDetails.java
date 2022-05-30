package onlinevotingsystem.beans;

public class PartiesDetails {
	private int p_no;
	private String partyName;
	public PartiesDetails() {
		super();
	}
	public PartiesDetails(int p_no, String partyName) {
		super();
		this.p_no = p_no;
		this.partyName = partyName;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	

}
