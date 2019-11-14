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
	    f= new JFrame("User Sign in"); 
	    
	    
	    l1=new JLabel("Username");  
	    l1.setBounds(50,50, 100,30); 
	    
	    t1=new JTextField(" ");  
	    t1.setBounds(50,75, 200,30); 
	    
	    l2=new JLabel("Password");  
	    l2.setBounds(50,125, 100,30); 
	    
	    t2=new JPasswordField();  
	    t2.setBounds(50,150, 200,30);
	    
	    JButton b=new JButton("Sign in");  
	    b.setBounds(50,200,95,30);
	    b.addActionListener(this);
	    
	    JLabel l10=new JLabel("New User ?");
	    l10.setBounds(275,325,120,30);
	    
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
		PreparedStatement ps;
		ResultSet rs;
		String UserId=t1.getText();  
		String Pass=String.valueOf(t2.getPassword());
		
		
		String query="SELECT * FROM registeredusers WHERE UserId=? and Pass=? ";
		System.out.println(UserId + Pass);
		try {
			ps	= DBConnect.getConnection().prepareStatement(query);
			ps.setString(1, UserId);
			ps.setString(2, Pass);
			rs = ps.executeQuery();
			
		
		
	
		
			if(rs.next())
			{
					
				JOptionPane.showMessageDialog(null, "User Logged in successfully");
			    l3=new JLabel("Welcome, "+rs.getString("Name"));  
			    l3.setBounds(50,0,300,30);
			    l4=new JLabel("Wallet balance : "+ wallet);  
			    l4.setBounds(50,25, 300,30); 
			    f.add(l3);f.add(l4);
				
				if(wallet<1000)
				{
					
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
				JOptionPane.showMessageDialog(null, "Wrong Credentials !!");
			}
			
		}catch(SQLException ex) {
			
			//Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
		}
	}


} 
