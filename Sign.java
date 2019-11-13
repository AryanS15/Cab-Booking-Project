import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;



class Sign implements ActionListener
{  
	JTextField t1; 
    JPasswordField t2;
    JLabel l1,l2;  
public static void main(String args[])  
    {
		new Sign();
		
    }

public Sign(){
	    JFrame f= new JFrame("User Sign in"); 
	    
	    
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
	    
	    f.add(l1); f.add(l2);
	    f.add(t1); f.add(t2); 
	    f.add(b);
	    f.setSize(400,400);  
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
					
				JOptionPane.showMessageDialog(null, "Success !!");
				new Option();
				
				
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
