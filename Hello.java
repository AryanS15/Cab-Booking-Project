import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

  
public class Hello implements ActionListener         
{  
	JFrame f;
	JTextField t1,t3,t4;
    JPasswordField t2; 
    JLabel l1,l2,l3,l4,l5; 
    
	
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
	    l3.setBounds(50,175, 100,30); 
	    
	    t3=new JTextField(" ");  
	    t3.setBounds(50,200, 200,30); 
	    
	    l4=new JLabel("Password");  
	    l4.setBounds(50,250, 100,30); 
	    
	    t2=new JPasswordField();  
	    t2.setBounds(50,275, 200,30);
	    
	    JButton b1=new JButton("Register");  
	    b1.setBounds(50,325,95,30); 
	    b1.addActionListener(this);  
	    
	    l1=new JLabel("Already Registered ?");
	    l1.setBounds(275,325,120,30);
	    
	    JButton b2=new JButton("Login");  
	    b2.setBounds(405,325,95,30); 
	    
	    f.add(l1); f.add(l2);f.add(l3); f.add(l4);f.add(l5);
	    f.add(t1); f.add(t2);f.add(t3); f.add(t4);
	    f.add(b1);f.add(b2);
	    f.setSize(600,600);  
	    f.setLayout(null);  
	    f.setVisible(true);  
    } 




public void actionPerformed(java.awt.event.ActionEvent e) {
	String Name = t1.getText(); 
	String UserId = t3.getText();
	String Pass = String.valueOf(t2.getPassword());
	String EmailId = t4.getText();
	
	PreparedStatement ps;
	String query = "INSERT INTO `registeredusers`(`Name`, `UserId`, `Pass`, `EmailId`) VALUES (?,?,?,?)";
	
	try	{
			ps = DBConnect.getConnection().prepareStatement(query);
			ps.setString(1, Name);
			ps.setString(2, UserId);
			ps.setString(3, Pass);
			ps.setString(4, EmailId);
			
			if(ps.executeUpdate() >0)
			{
				JOptionPane.showMessageDialog(null, "new user added");
				
			}
	
		}
	catch(SQLException ex)
		{
			//Logger.getLogger(Hello.class.getName(), null).log(Level.SEVERE,null,ex);
					
		}
		
	} 

} 
