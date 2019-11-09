import javax.swing.*;  
class Hello  
{  
public static void main(String args[])  
    {  
	    JFrame f= new JFrame("User Registration"); 
	    
	    JTextField t1,t3,t4;
	    JPasswordField t2; 
	    JLabel l1,l2,l3,l4;  
	    
	    l1=new JLabel("Name");  
	    l1.setBounds(50,25, 100,30); 
	    
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
	    
	    JButton b=new JButton("Register");  
	    b.setBounds(50,325,95,30); 
	    
	    f.add(l1); f.add(l2);f.add(l3); f.add(l4);
	    f.add(t1); f.add(t2);f.add(t3); f.add(t4);
	    f.add(b);
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);  
    }  
 } 
