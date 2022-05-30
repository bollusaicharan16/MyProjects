package stringconstant.java;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

import onlinevotingsystem.dbo.*;

public class StringConstant {
	  public static final String DRIVER = "org.postgresql.Driver";
	  public static final String DB_URL = "jdbc:postgresql://localhost:5432/JRN-10";
	  public static final String USER = "postgres";
	  public static final String PASSWORD = "Charan@16";

	
	  public static final String createVoterdetails ="CREATE TABLE VOTERDETAILS " +
				"(VOTER_ID SERIAL PRIMARY KEY UNIQUE," +
		"VOTER_NAME VARCHAR(40) NOT NULL," +
				"AGE INT NOT NULL,"+
				"PHONE_NUMBER VARCHAR(20) UNIQUE NOT NULL)";
	  public static final String deleteVoterdetails ="DROP TABLE VOTERDETAILS";
	  public static final String createPartiedetails="CREATE TABLE PARTIESDETAILS" +
		"(PARTIE_NO INT PRIMARY KEY UNIQUE,"+
				"PARTIE_NAME VARCHAR(40) UNIQUE NOT NULL)";
	  public static final String deletePartiedetails ="DROP TABLE PARTIESDETAILS";
	  public static final String createVoting="CREATE TABLE VOTINGBOOTH"+
				 "(ENROLL_ID SERIAL PRIMARY KEY UNIQUE NOT NULL," +
		            " VOTER_ID INT UNIQUE NOT NULL, " +
		            "PARTIE_NO INT,"+
		            "CONSTRAINT VOTER_ID_FK FOREIGN KEY(VOTER_ID) REFERENCES VOTERDETAILS(VOTER_ID),"+
		            "CONSTRAINT PARTIE_NO_FK FOREIGN KEY(PARTIE_NO) REFERENCES PARTIESDETAILS(PARTIE_NO))";
	  public static final String deleteVoting="DROP TABLE VOTINGBOOTH";
		


}
