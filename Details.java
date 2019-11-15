import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

//Class displays details of the trip
public class Details {
	public int rating =-1;
	Connection con=DBConnect.getConnection();
	JFrame f;
	JLabel l1,l2,l3,l4;
	int b,c;
	JButton pay,rate;
	JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
	public String DN;//this is used to store the value of the name of the driver
	
	//funtion displays details
	public Details(float fare,float wallet,String n) {
		try {
		f = new JFrame("Details of the trip");
		l1=new JLabel("You have reached your destination");
		l1.setBounds(300,50,300,30);
		f.add(l1);
		l2=new JLabel("Fare : "+fare);
		l2.setBounds(350,100,300,30);
		f.add(l2);
		JButton pay=new JButton("Make Payment");
		pay.setBounds(250,125,400,30);
		f.add(pay);
		pay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
		
				l3=new JLabel("Amount of Rs."+fare+" has been deducted from your wallet");
				l3.setBounds(250,150,400,30);
				 f.add(l3);


			}
		});


		DN=n;
		
		JButton rate=new JButton("Submit Rating");
		rate.setBounds(100,350,400,30);
		f.add(rate);
		rate.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent ae) {
		try {	//Selects the rating which the user has selected
			
			if (r1.isSelected()) { 
				   rating =1; 
	        } 

	        else if (r2.isSelected()) { 
	        	rating = 2; 
	        } 
	        else if (r3.isSelected()) { 

	            rating=3; 
	        } 
	        else if (r4.isSelected()) { 

	            rating=4; 
	        } 
	        else if (r5.isSelected()) { 

	            rating=5; 
	        } 
	        else if (r6.isSelected()) { 

	            rating=6; 
	        } 
	        else if (r7.isSelected()) { 

	            rating=7; 
	        } 
	        else if(r8.isSelected()) { 

	            rating=8; 
	        } 
	        else if (r9.isSelected()) { 

	            rating=9; 
	        } 
	        else if (r10.isSelected()) { 

	            rating=10; 
	        } 
		 			
			System.out.println(rating);	
			//This query Selects rating and total journeys of the driver
		String query="SELECT Rating,Total_Journeys FROM drivers WHERE Name='"+DN+"'";
		PreparedStatement statement=con.prepareStatement(query);
		
		ResultSet result=statement.executeQuery();
		
			//String to int conversion from sql
			b=Integer.parseInt(result.getString("Rating"));
			c=Integer.parseInt(result.getString("Total_Journeys"));
			System.out.println("Rating :"+b+"Journeys : "+c);
			b=(b*c + rating)/(c+1);
			c=c+1;
			//Redifines rating and total journeys
			
			String query2="UPDATE driver SET Rating='"+b+"'AND Total_Journeys="+c+" WHERE Name='"+DN+"'";
			PreparedStatement statement2=con.prepareStatement(query2);
			
			statement2.executeQuery();
			//The new rating and the Total number of journeys column in the sql has been updated
		JOptionPane.showMessageDialog(null, "Thank You for riding with us");
				
			new Sign();
 		}
 		catch(Exception e)
 		{
 			
 		}

			}
		});

			
		//feed to database
		l4=new JLabel("Rate Your Trip");
		l4.setBounds(100,0,100,30);
		r1=new JRadioButton("1/10");r2=new JRadioButton("2/10");r3=new JRadioButton("3/10");r4=new JRadioButton("4/10");r5=new JRadioButton("5/10");    
        r6=new JRadioButton("6/10");r7=new JRadioButton("7/10");r8=new JRadioButton("8/10");r9=new JRadioButton("9/10");r10=new JRadioButton("10/10");    
		r1.setBounds(100,25,100,30);r2.setBounds(100,50,100,30);r3.setBounds(100,75,100,30);r4.setBounds(100,100,100,30);r5.setBounds(100,125,100,30);   
		r6.setBounds(100,150,100,30);r7.setBounds(100,175,100,30); r8.setBounds(100,200,100,30);r9.setBounds(100,225,100,30);r10.setBounds(100,250,100,30);
		ButtonGroup bg=new ButtonGroup(); 
		r1.setEnabled(true);
		bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);bg.add(r5);bg.add(r6);bg.add(r7);bg.add(r8);bg.add(r9);bg.add(r10);        
		f.add(r1);f.add(r2);f.add(r3);f.add(r4);f.add(r5);f.add(r6);f.add(r7);f.add(r8);f.add(r9);f.add(r10);
	    
		
		
	    f.add(l4);
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);
		}
		catch(Exception e)
		{
			
		}
		String query1="UPDATE driver SET Busy=0 WHERE Name='"+DN+"'";
		PreparedStatement statement1=con.prepareStatement(query1);
		
		ResultSet result=statement1.executeQuery();
		
		
		System.out.println("Driver Name " +DN);
	}


	public static void main(String args[])
	{
		new Details(100,100,"Sharukh Khan");
	}
	

}
//feed wallet balance and rating after trip
//make user as well as cab driver busy
//no driver condition