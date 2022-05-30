package onlinevotingsystem.dbo;

import java.sql.*;

public class PartiesRegistration{
	public Connection c;
	public PartiesRegistration(){
		super();
	}
	public PartiesRegistration(Connection c) {
		this.c=c;
	}

	public void insertdetails() {
		try {
         Statement s=null;
         s=c.createStatement();
         String insertdetails= "INSERT INTO PARTIESDETAILS VALUES(1,'BJP')";
         s.execute(insertdetails);
         insertdetails="INSERT INTO PARTIESDETAILS VALUES(2,'CONGRESS')";
		s.execute(insertdetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updatedetails() {
		try {
			Statement s=null;
			s=c.createStatement();
			String updatedetails="UPDATE PARTIESDETAILS SET PARTIE_NAME='TRS' WHERE PARTIE_NO=2";
			s.execute(updatedetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletdetails() {
		try {
		Statement s=null;
		s=c.createStatement();
		String deletedetails ="DELETE FROM PARTIESDETAILS WHERE PARTIE_NO=1";
		s.execute(deletedetails);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void allparties() {
		try {
			Statement s=null;
			c.setAutoCommit(false);
			s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM PARTIESDETAILS");
			while(rs.next()) {
				String p_no=rs.getString("partie_no");
				String p_name=rs.getString("Partie_name");
			System.out.print("PARTIE_NO = "+p_no+" ");
			System.out.print("PARTIE_NAME = "+p_name);
			System.out.println();
			
			}
			c.commit();
			c.close();
			s.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	

}
