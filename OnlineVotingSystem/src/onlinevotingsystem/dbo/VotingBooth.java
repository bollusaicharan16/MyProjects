package onlinevotingsystem.dbo;
import onlinevotingsystem.beans.*;

import java.sql.*;

public class VotingBooth {
	public Connection c;
	public VotingBooth(Connection c) {
		this.c=c;
	}
	public void insertVoting(Voting voting) {
		try {
		PreparedStatement s=null;
		String insertion ="INSERT INTO VOTINGBOOTH(VOTER_ID,PARTIE_NO) VALUES (?,?) ";
		s=c.prepareStatement(insertion);
		//s.setInt(1,voting.getEnroll_id());
		s.setInt(1,voting.getVoter_id());
		s.setInt(2,voting.getCan_id());
		s.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void AllVoting() {
		try {
		Statement s=null;
		c.setAutoCommit(false);
		s=c.createStatement();
		ResultSet rs=s.executeQuery("SELECT * FROM VOTINGBOOTH");
		while(rs.next()) {
			int enroll_id=rs.getInt(1);
			int voter_id=rs.getInt(2);
			int partie_no=rs.getInt(3);
			System.out.println("Enroll_id = "+enroll_id+" ,voter_id = "+voter_id+" ,partie_no = "+partie_no);
		
		}
		c.commit();

		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void maxVotes(int id) {
		int resultpartieone=0;
		
		try {
			
			PreparedStatement s=null;
			String sql="SELECT COUNT(PARTIE_NO) FROM VOTINGBOOTH GROUP BY PARTIE_NO HAVING PARTIE_NO=?";
			s=c.prepareStatement(sql);
			s.setInt(1,id);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				resultpartieone=rs.getInt(1);
			}
			System.out.println("No of votes: "+resultpartieone);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
