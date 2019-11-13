import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;
public class Option
{    
JFrame f;    
String point[]={"BPHC","Secunderabad Railway Station","Thumkunta","Airport","Parade Ground"}; 
Option(){    
    f=new JFrame("ComboBox Example");           
    JLabel l1,l2;
    l1=new JLabel("From : ");
    l1.setBounds(50,25,250,20); 
	
	JComboBox<Object> cb= new JComboBox<Object>(point);    
    cb.setBounds(50, 50,250,20);
    
    
	cb.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent actionEvent) {
    	System.out.println(cb.getSelectedItem());
    	System.out.println(cb.getSelectedIndex());
    	findDriver(cb.getSelectedIndex());
    	
    }
  });
  
    
    l2=new JLabel("To : ");
    l2.setBounds(350,25,250,20);
    
	JComboBox<Object> ed= new JComboBox<Object>(point);    
    ed.setBounds(350, 50,250,20);
    
    
    JButton b= new JButton("Proceed");
    b.setBounds(275,100,95,30);
//	b.addActionListener(new ActionListener() {
//		
//		public void actionPerformed(ActionEvent ae) {
//			new Journey();
//		}
//	});
//	
//	
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
			Connection con=DBConnect.getConnection();
			
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
		
		
		
//		
//		ArrayList<String> array1=new ArrayList<String>();
//		int array[]=new int[5];
//		JTextField t1;
//		JLabel l1;
//		int i=0;
//		while(result1.next()) {
//			array1.add(result1.getString("Name"));
//			array[i]=result2.getInt("Rating");
//			i++;
//		}
//		/*
//		 *    t1=new JTextField(" ");  
//	    t1.setBounds(50,50, 200,30); 
//	    
//	     l2=new JLabel("User Id");  
//	    l2.setBounds(50,100, 100,30);
//		 */
//		if(i==0)
//		{
//			DriverNotAvailable(a)
//			System.out.println("Driver is not available");
//			l1=new JLabel("Driver is not available");
//			l1.setBounds(50,100,250,20);
//		}
//		else {
//		int s=sort(array,i);
//		l1=new JLabel("Driver is"+array1.get(s));
//		l1.setBounds(50,100,250,20);
//		}
//		}

//}
//public void DriverNotAvailable(int a){
//	try {
//	Connection con=getConnection();
//	String s=point[a-1];
//	PreparedStatement statement3=con.prepareStatement("SELECT 's' FROM destination WHERE Location=a");
//	}
//	catch(Exception e)
//	{
//		System.out.println(e);
//	}
//}
//public int sort(int array[],int n)
//{
//	int max=array[0];
//	for(int i=0;i<n;i++)
//	{
//		if(array[i]>array[max])
//			max=i;
//	}
//	return max;
//}

public static void main(String[] args) {    
    new Option();         
}    
} 
