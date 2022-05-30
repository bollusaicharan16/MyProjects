package onlinevotingsystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import onlinevotingsystem.beans.PartiesDetails;
import onlinevotingsystem.dbo.PartiesRegistration;

class PartiesRegistrationTest {

	@Test
	void test() throws SQLException {
		String DB_URL = "jdbc:postgresql://localhost:5432/JRN-10";
		String USER = "postgres";
		String PASSWORD = "Charan@16";
		Connection connect =DriverManager.getConnection(DB_URL,USER,PASSWORD);
		PartiesDetails p=new PartiesDetails();
		PartiesRegistration p1=new PartiesRegistration(connect);
		p.setP_no(1);
		p.setPartyName("BJP");
		p1.insertdetails();
		assertEquals(1,p.getP_no(),"partie number should equal");
	}
}
