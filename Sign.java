import javax.swing.*;  
class Sign  
{  
public static void main(String args[])  
    {  
	    JFrame f= new JFrame("User Registration"); 
	    
	    JTextField t1; 
	    JPasswordField t2;
	    JLabel l1,l2;  
	    
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
	    
	    f.add(l1); f.add(l2);
	    f.add(t1); f.add(t2); 
	    f.add(b);
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);  
    }  
 } 