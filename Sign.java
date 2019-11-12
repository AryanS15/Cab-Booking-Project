import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
class Sign implements ActionListener
{  
	JTextField t1; 
    JPasswordField t2;
    JLabel l1,l2;  
public static void main(String args[])  
    {
		new Sign();
    }
	Sign(){
	    JFrame f= new JFrame("User Registration"); 
	    
	    
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
private void b_LOGINActionPerformed(java.awt.event.ActionEvent evt)
{
	PreparedStatement ps;
	ResultSet rs;
	String uname=t1.getText();
	String pass=String.copyValueOf(t2.getPassword());
	String query="SELECT*FROM 'the_app_users'WHERE'u_uname'=?AND'u_pass'=?"; 
	try {
	ps=MyConnection.getConnection().prepareStatement(query);
	ps.setString(1, uname);
	ps.setString(2, pass);
	rs=ps.executeQuery();
	if(rs.next())
	{
		HOME_JFrame mf=new HOME_JFrame();
		mf.setVisible(true);
		mf.pack();
		mf.setLocationRelativeTo(null);
		mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mf.l1.setText("Welcome<"+uname+">");
		this.dispose();
	}
	else
	{
		JOptionPane.showMessageDialog(null, "NO");
	}
	}catch(SQLException ex) {
		Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
	}
}
public boolean checkUsername(String username)
{
	PreparedStatement ps;
	ResultSet rs;
	boolean checkUser=false;
	String query="SELECT*FROM 'the_app_users'WHERE'u_uname'=? "; 
	try {
	ps=MyConnection.getConnection().prepareStatement(query);
	ps.setString(1, username);
	rs=ps.executeQuery();
	if(rs.next())
	{
		checkUser=true;
	}
	}
	catch(SQLException ex) {
		Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
	}
	return checkUser;
}
 } 