package onlinevotingsystem.beans;

public class Voting {
	private int Enroll_id;
	private int voter_id;
	private int can_id;
	public Voting(){
		
	}
	public Voting(int enroll_id, int voter_id, int can_id) {
		super();
		Enroll_id = enroll_id;
		this.voter_id = voter_id;
		this.can_id = can_id;
	}
	public int getEnroll_id() {
		return Enroll_id;
	}
	public void setEnroll_id(int enroll_id) {
		Enroll_id = enroll_id;
	}
	public int getVoter_id() {
		return voter_id;
	}
	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}
	public int getCan_id() {
		return can_id;
	}
	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}
	

}
