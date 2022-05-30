package onlinevotingsystem.dbo;
import onlinevotingsystem.beans.*;
import stringconstant.java.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import onlinevotingsystem.beans.VoterDetails;



public class VoterRegistration  {
	
     private Connection c;
     public VoterRegistration() {
    	 super();
     }
	public VoterRegistration(Connection c) {
		this.c=c;
		
	}
	
	
	
	public void CreateTable() {
		try {
			Statement s=null;
			s=c.createStatement();
			String sql="CREATE TABLE VOTERDETAILS " +
			"(VOTER_ID SERIAL PRIMARY KEY ," +
			"VOTER_NAME VARCHAR(40) NOT NULL," +
			"AGE INT NOT NULL,"+
			"PHONE_NUMBER VARCHAR(20) UNIQUE NOT NULL)";
			s.executeUpdate(sql);
			s.close();
			System.out.println("User Table Created.....!");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	

	public void DeleteTable() {
		try {
			Statement s=null;
			s=c.createStatement();
			s.execute("DROP TABLE VOTERDETAILS");
			s.close();
			System.out.println("Table deleted succefully......!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void CreateUserId(VoterDetails voter) {
		try {
			PreparedStatement s1=null;
			s1=c.prepareStatement("INSERT INTO VOTERDETAILS(VOTER_NAME,AGE,PHONE_NUMBER) VALUES(?,?,?)");
			s1.setString(1, voter.getName());
			s1.setInt(2,voter.getAge());
			s1.setString(3, voter.getPhoneNumber());
			s1.executeUpdate();
			s1.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void UpdatedUserdata(int id, String votername) {
		try {
			PreparedStatement s1=null;
			s1 =c.prepareStatement("UPDATE VOTERDETAILS SET VOTER_NAME=? WHERE USER_ID=?");
			s1.setString(1, votername);
			s1.setInt(2, id);
			s1.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DelectUserdata(int id) {
		try {
			PreparedStatement s1=null;
			s1=c.prepareStatement("DELETE FROM VOTERDETAILS WHERE USER_ID=?");
			s1.setInt(1, id);
			s1.executeUpdate();
			s1.close();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		
	}
	
	public List<VoterDetails> AllUsers() {
		try {
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM VOTERDETAILS");
			List<VoterDetails> voter=new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String phonenumber=rs.getString(4);
				voter.add(new VoterDetails(id,name,age,phonenumber));
			}
			return voter;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void viwevoterid(String phoneNumber) {
		try {
			PreparedStatement s1=null;
			s1=c.prepareStatement("SELECT * FROM VOTERDETAILS WHERE PHONE_NUMBER=?");
			s1.setString(1, phoneNumber);
			ResultSet rs=s1.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String phonenumber=rs.getString(4);
				System.out.println("Your VoterDetails: voter_id ="+id+",voter_name = "+name+", age = "+age+" ,phonenumber = "+phonenumber);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}

	