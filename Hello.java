import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

  
public class Hello        
{  
	JFrame f;
	JTextField t1,t3,t4,t6;
    JPasswordField t2; 
    JLabel l1,l2,l3,l4,l5,l6; 
    
	
    public static void main(String args[])  
    {  
		new Hello();
    }



	public Hello()
	{
	
	    f = new JFrame("User Registration"); 

 
	    
	    l5=new JLabel("Name");  
	    l5.setBounds(50,20, 100,30); 
	    
	    t1=new JTextField(" ");  
	    t1.setBounds(50,50, 200,30); 
	    
	    l2=new JLabel("User Id");  
	    l2.setBounds(50,100, 100,30); 
	    
	    t4=new JTextField(" ");  
	    t4.setBounds(50,125, 200,30); 
	    
	     l3=new JLabel("Email Id");  
	    l3.setBounds(50,250, 100,30); 
	    
	    t3=new JTextField(" ");  
	    t3.setBounds(50,275, 200,30); 
	    
	    l4=new JLabel("Password");  
	    l4.setBounds(50,325, 100,30); 
	    
	    t2=new JPasswordField();  
	    t2.setBounds(50,350, 200,30);
	    
	    l6=new JLabel("Mobile no.");  
	    l6.setBounds(50,175, 100,30); 
	    
	    t6=new JTextField(" ");  
	    t6.setBounds(50,200, 200,30); 
	    
	    JButton b1=new JButton("Register");  
	    b1.setBounds(50,400,95,30); 
	    b1.addActionListener(new ActionListener() {
	    	
					public void actionPerformed(ActionEvent ae) {
						
						String Name = t1.getText(); 
						String UserId = t3.getText();
						String Pass = String.valueOf(t2.getPassword());
						String EmailId = t4.getText();
						String PhoneNo =t6.getText();
						
						PreparedStatement ps;
						String query = "INSERT INTO `registeredusers`(`Name`, `UserId`, `Pass`, `EmailId`, `PhoneNo`) VALUES (?,?,?,?,?)";
						
						try	{
								ps = DBConnect.getConnection().prepareStatement(query);
								ps.setString(1, Name);
								ps.setString(2, UserId);
								ps.setString(3, Pass);
								ps.setString(5, PhoneNo);
								ps.setString(4, EmailId);
								
								
								if(ps.executeUpdate() >0)
								{
									JOptionPane.showMessageDialog(null, "new user added");
									
								}
						
							}
						catch(SQLException ex)
							{
							System.out.println(ex);
								
							//Logger.getLogger(Hello.class.getName(), null).log(Level.SEVERE,null,ex);
										
							}  
					    
						
						
					}
					});
			    
			    
			    
	    
	    
		
	    l1=new JLabel("Already Registered ?");
	    l1.setBounds(275,400,120,30);
	    
	    JButton b2=new JButton("Login");  
	    b2.setBounds(405,400,95,30); 
	    b2.addActionListener(new ActionListener() {
	    	
				public void actionPerformed(ActionEvent ae) {
					
					new Sign();
				}
				});
		    
		    
		    
	    
	    f.add(l1); f.add(l2);f.add(l3); f.add(l4);f.add(l5);f.add(l6);
	    f.add(t1); f.add(t2);f.add(t3); f.add(t4);f.add(t6);
	    f.add(b1);f.add(b2);
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);  
    } 



//need to put validation
} 
