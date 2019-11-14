import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Wallet  {
	 JFrame f;
	JTextField t1; 
	JLabel l1,l2;
	public float wallet;
	
	public Wallet() 
	{
	
			
		
		f= new JFrame("Wallet"); 
	    
	    
	    l1=new JLabel("Enter the amount (in Rs.) :");  
	    l1.setBounds(50,50, 150,30); 
	    
	    t1=new JTextField("1000");
	    t1.setBounds(300,50,100,30);
	    
	    l2=new JLabel("Wallet balance : "+ wallet);  
	    l2.setBounds(50,200, 300,30);
	    
	    String s1=t1.getText(); 
	    float a=Float.parseFloat(s1);
	    JButton b1=new JButton("Add Money");  
		 
	    b1.setBounds(250,100,200,30); 
	    
	    f.add(b1);
	    b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
			wallet(wallet,a,s1);


			}
		});
	    
  
	    f.add(l2);
	    f.add(l1);f.add(t1);
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);
		

		
	}
	
	public void wallet(float w,float a,String s1)
	{
		 try{
			 s1=t1.getText(); 
		 a=Float.parseFloat(s1);
		 if(a<=0)
		 {JOptionPane.showMessageDialog(null, "Please enter the correct amount");return;}
		l2.setText("Wallet balance : "+ (w+a));
		t1.setText("");
		wallet=w+a;
		if(wallet>=1000)
		{
			JButton b2=new JButton("Select Start and Destination");
			 b2.setBounds(250,200,350,30);
			 f.add(b2);
			    b2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ae) {
						
					new Option(wallet);


					}
				});
		}
		

		 }
		 catch(Exception e)
		 {
			 JOptionPane.showMessageDialog(null, "Please enter the amount");
		 }
		
	}
	
	
	

	public static void main(String[] args) {
		
		new Wallet();
	}


}
