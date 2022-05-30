package onlinevotingsystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.sql.*;
class StringConstantTest {

	@Test
	void getDRIVER_test() {
		String driver ="org.postgresql.Driver";
		assertEquals("org.postgresql.Driver",driver,"Db driver should match");
		
	}
	@Test
	void getConnection_test() throws SQLException {
	String DB_URL = "jdbc:postgresql://localhost:5432/JRN-10";
	String USER = "postgres";
	String PASSWORD = "Charan@16";
	Connection dbConnection=DriverManager.getConnection(DB_URL,USER,PASSWORD);
	assertNotNull(dbConnection,"connection should be successful");
	}
}
