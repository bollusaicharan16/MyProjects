package onlinevotingsystem.main;
import onlinevotingsystem.beans.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import onlinevotingsystem.dbo.*;
import stringconstant.java.StringConstant;

public class OnlineVotingSystem extends StringConstant{

	public static void main(String[] args) throws Exception{
		Connection c=null;
		Statement s=null;
		Class.forName(DRIVER);
		c=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		  VoterRegistration u=new VoterRegistration(c);
		    BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		    String option;
		  
		   do {
		    System.out.println("##### Welcome To Voter Registration #### ");
		    System.out.println("Choose your Choice:");
		    System.out.println("****1.Create Voter_id****");
		    System.out.println("****2.UpdateVoterdetail****");
		    System.out.println("****3.DeleteVoterid****");
		    System.out.println("****4.Allvoters()****");
		    System.out.println("****5.view voterid****");
		    System.out.println("****6.view parties****");
		    System.out.println("****7.voting****");
		    System.out.println("****8.MaxVotes****");
		    System.out.println("****9.AllVoting Data****");
		    System.out.println("Enter choice:");
		    int choice=Integer.parseInt(br.readLine());
		    switch(choice) {
		    case 1:System.out.println("Enter your Age:");
		           int age=Integer.parseInt(br.readLine());
		           if(age>=18) {
		        	   System.out.println("You are eligible for voting:");
		        	   System.out.println("Create your Voterid for voting...");
		        	   System.out.println("Enter your Name:");
		        	   String name=br.readLine();
		        	   System.out.println("Enter your Age:");
		        	   int age1=Integer.parseInt(br.readLine());
		        	   System.out.println("Enter your Mobile Number:");
		        	   String phoneNumber=br.readLine();
		        	   u.CreateUserId(new VoterDetails(0,name,age1,phoneNumber));
		        	 
		           }
		           else {
		        	   System.out.println("you are not eligible for voting.....Wait for "+(18-age)+" years");
		           }
		           break;
		    	
		    case 2:System.out.println("Update voterDetails:");
		           System.out.println("Enter your id:");
		           int id=Integer.parseInt(br.readLine());
		           System.out.println("Enter your new votername:");
		           String name=br.readLine();
		           u.UpdatedUserdata(id, name);
		    	break;
		    case 3:System.out.println("Delete User:");
		           System.out.println("Enter your User_id:");
		           int user_id=Integer.parseInt(br.readLine());
		           u.DelectUserdata(user_id);
		           break;
		    case 4:System.out.println("Voters Data :");
		           u.AllUsers().forEach(x -> System.out.println("Voter_id ="+x.getId()+"\tVoter_Name ="+x.getName()+"\tAge ="+x.getAge()+"\tPhone_Number ="+x.getPhoneNumber()));
		           break;
		    
		    case 5:System.out.println("GET VOTERDETAILS :");
		           System.out.println("Enter phoneNumber:");
		           String phone_Number =br.readLine();
		           u.viwevoterid(phone_Number);
		           break;
		    case 6:System.out.println("****WELCOME TO VOTINGBOOTH****");
		           System.out.println("####Partie Details####");
		           PartiesRegistration p= new PartiesRegistration(c);
		           p.allparties(); 
		           break;
		    case 7:System.out.println("****Voting****");
		           System.out.println("1.BJP");
		           System.out.println("2.CONGRESS");
		           Class.forName(DRIVER);
					c=DriverManager.getConnection(DB_URL,USER,PASSWORD);
				   VotingBooth voting =new VotingBooth(c); 
				   System.out.println("ENTER VOTER_ID :");
				   int voter_id =Integer.parseInt(br.readLine());
				   System.out.println("ENTER PARTIE_NO:");
				   int partie_no=Integer.parseInt(br.readLine());
				   voting.insertVoting(new Voting(0,voter_id,partie_no));
				   System.out.println("#####Thanks for voting####");
		           break;
		    case 8:System.out.println("***MaxVotes****");
		            Class.forName(DRIVER);
			        c=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		            VotingBooth votings =new VotingBooth(c); 
		            System.out.println("****MaxVotesAchievedByPartie****");
		            System.out.println("Enter Partie_no: ");
		            int parties_no=Integer.parseInt(br.readLine());
		            votings.maxVotes(parties_no);
		            break;
		    case 9:System.out.println("*****Allvoted Data*****");
		            System.out.println("***MaxVotes****");
                    Class.forName(DRIVER);
	                c=DriverManager.getConnection(DB_URL,USER,PASSWORD);
                    VotingBooth vote =new VotingBooth(c); 
		            vote.AllVoting();
		            break;
		    	
		     default :System.out.println("Please Enter Valid Choice......!");
		              break;
		    }
		    
		    System.out.println("Continue.....(Yes/no)");
		    option=br.readLine();
		 }while(option.equalsIgnoreCase("yes"));
		   
		  
		   
		
	
		
		
	
	}

}
