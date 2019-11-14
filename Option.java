import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;
public class Option
{    
JFrame f;  
JLabel l1,l2,l3,l4;
JComboBox<Object> cb,ed;
Connection con=DBConnect.getConnection();
String point[]={"BPHC","Secunderabad Railway Station","Thumkunta","Airport","Parade Ground"}; 
Option(){    
    f=new JFrame("Select a route");           
 
    l1=new JLabel("From : ");
    l1.setBounds(50,25,250,20); 
	
	cb= new JComboBox<Object>(point);    
    cb.setBounds(50, 50,250,20);
    
    
	cb.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent actionEvent) {
    	System.out.println(cb.getSelectedItem());
    	System.out.println(cb.getSelectedIndex()+1);
    	findDriver(cb.getSelectedIndex());
    	
    }
  });
  
    
    l2=new JLabel("To : ");
    l2.setBounds(350,25,250,20);
    
	 ed= new JComboBox<Object>(point);    
    ed.setBounds(350, 50,250,20);
    
	ed.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent actionEvent) {
    	System.out.println(ed.getSelectedItem());
    	System.out.println(ed.getSelectedIndex()+1);
    	
    	
    }
  });
  
    
    
    
    JButton b= new JButton("Proceed");
    b.setBounds(275,100,95,30);
	b.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent ae) {
			
			details(((JLabel) cb.getSelectedItem()).getText(),((JLabel) ed.getSelectedItem()).getText());
			//calcFareTime(distance);
			//l3=new JLabel("Distance : "+distance);
			//l3.setBounds(100,100,250,20);
			//f.add(l3);
			
		}
	});
	
	
    f.add(cb);f.add(ed);
    f.add(l1);f.add(l2);
    f.add(b);
    
    f.setLayout(null);    
    f.setSize(800,800);    
    f.setVisible(true);    
    

      
    //code for point != point condition
      findDriver(cb.getSelectedIndex());
}    
public void findDriver(int a) {
	try {
			
			
			String query="SELECT * FROM drivers WHERE Location='"+(a+1)+"'";
			PreparedStatement statement=con.prepareStatement(query);
			statement.executeQuery();
			String query1="SELECT * FROM drivers WHERE Location='"+(a+1)+"' AND Rating=(SELECT MAX(Rating) FROM drivers WHERE Location = '"+(a+1)+"')";
			PreparedStatement statement1=con.prepareStatement(query1);
			
			ResultSet result=statement1.executeQuery();
			
			if(result.next())
			{
				System.out.println(result.getString("Name"));
				   
			}
			else
			{
				//driver with highest rating from min distance location
				System.out.println("Sorry ! No drivers");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}

public void details(String object1,String object2)  //cb.getSelectedItem() is the source and ed.getSelectedItem() is the destination
{
	try
	{
		System.out.println(object1+" "+object2);
		
		System.out.println("Hello");
			
	 String query = "SELECT Airport FROM final WHERE Source='Parade Ground' ";
	 PreparedStatement statement3=con.prepareStatement(query);
		
		ResultSet result=statement3.executeQuery(query);
		int d=result.getInt("Airport");
		System.out.println("Helo"+d);
			
			
	}
	catch(Exception e)
	{
		
	}
	
}
	public void dispDistCalcTime(int d)
	{
		//float f=20*d;
		int t=10*d;
		//label j4 and j5 should print the distance and time required for the journey
		
		new MyTimer(t);
		//new Details(f,wallet);
		
		
		
		
		
	}
	
public static void main(String[] args) {    
    new Option();         
}    
} 
