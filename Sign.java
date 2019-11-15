import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Sign implements ActionListener
{ 
	public int wallet;
	 JFrame f;
	JTextField t1,t3; 
    JPasswordField t2;
    JLabel l1,l2,l3,l4;  
public static void main(String args[])  
    {
		new Sign();
		
    }

public Sign(){
	//Creates User interface for sign in
	    f= new JFrame("User Sign in"); 
	    
	    
	    l1=new JLabel("Username");  
	    l1.setBounds(50,50, 100,30); 
	    
	    t1=new JTextField(" ");  
	    t1.setBounds(50,75, 200,30); 
	    
	    l2=new JLabel("Password");  
	    l2.setBounds(50,125, 100,30); 
	    
	    t2=new JPasswordField();  
	    t2.setBounds(50,150, 200,30);
	    //Button which on being clicked checks the user conditions
	    JButton b=new JButton("Sign in");  
	    b.setBounds(50,200,95,30);
	    b.addActionListener(this);
	    
	    JLabel l10=new JLabel("New User ?");
	    l10.setBounds(275,325,120,30);
	    //Button if the user wants to register
	    JButton b10=new JButton("Register");  
	    b10.setBounds(405,325,95,30);
	    b10.addActionListener(new ActionListener() {
	    	
			public void actionPerformed(ActionEvent ae) {
				
				new Hello();
			}
			});
	    
	    
	    
	    
	   	    
	    
	    f.add(l1); f.add(l2);f.add(l10);
	    f.add(t1); f.add(t2); 
	    f.add(b);f.add(b10);
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);  
    }  

	public void actionPerformed(java.awt.event.ActionEvent e)
	{	
		PreparedStatement ps,ps1;
		ResultSet rs,rs1;
		String UserId=t1.getText();  
		String Pass=String.valueOf(t2.getPassword());
		//This takes the value of username and password which is taken input on the frame
		//Then it redirects to the database where it checks whether the user exist or not
		String query="SELECT * FROM registeredusers WHERE UserId=? and Pass=? ";
		System.out.println(UserId + Pass);
		try {
			ps	= DBConnect.getConnection().prepareStatement(query);
			ps.setString(1, UserId);
			ps.setString(2, Pass);
			rs = ps.executeQuery();
		
		
	
		
			if(rs.next())
			{
				//THIS first checks whether user is already on a cab
				String temp=rs.getString("Busy");
				if(temp=="1") {
				JOptionPane.showMessageDialog(null, "User Logged in successfully");
			    l3=new JLabel("Welcome, "+rs.getString("Name"));  
			    l3.setBounds(50,0,300,30);
			    l4=new JLabel("Wallet balance : "+ wallet);  
			    l4.setBounds(50,25, 300,30); 
			    f.add(l3);f.add(l4);
				// If user is able to book a cab then he need to check his wallet 
				if(wallet<300)
				{
					//If the user does not have enough money then pop up would ask user to add more money
					JOptionPane.showMessageDialog(null, "Please add money to your wallet");
					 JButton b1=new JButton("Add Money to your wallet");  
					 
					    b1.setBounds(250,200,300,30); 
					    f.add(b1);
					    b1.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent ae) {
								
								
								new Wallet();
							    
								

								
							}
						});
					    

				}
				else
				{
				
					new Option(wallet);
				
				}
				
				}
				else
				{
					System.out.println("User has already booked a cab");
				}
				
			}
			else
			{
				//If user does not exist he cannot log in
				JOptionPane.showMessageDialog(null, "Wrong Credentials !!");
			}
			
		}catch(SQLException ex) {
			
			//Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
		}
	}


} 
