package onlinevotingsystem.beans;


public class VoterDetails {
	private int id;
	private String name;
	private int age;
	private String phoneNumber;
	public VoterDetails() {
		super();
	}

	public VoterDetails(int id, String name, int age, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	

	
	

}
