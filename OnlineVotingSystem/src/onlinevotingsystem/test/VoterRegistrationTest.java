package onlinevotingsystem.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import onlinevotingsystem.beans.VoterDetails;
import onlinevotingsystem.dbo.VoterRegistration;

import java.sql.*;

class VoterRegistrationTest{
	@Test
	void insertvoterid_test()throws Exception{
		String DB_URL = "jdbc:postgresql://localhost:5432/JRN-10";
		String USER = "postgres";
		String PASSWORD = "Charan@16";
		Connection connect =DriverManager.getConnection(DB_URL,USER,PASSWORD);
		
		VoterDetails voter=new VoterDetails();
		VoterRegistration v=new VoterRegistration(connect);
		voter.setId(1);
		voter.setName("sai charan");
		voter.setAge(21);
		voter.setPhoneNumber("7093214576");
		v.CreateUserId(voter);
		assertEquals("sai charan",voter.getName(),"name must be equal");
	}
	
	

}
