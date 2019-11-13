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
    
    l2=new JLabel("To : ");
    l2.setBounds(350,25,250,20);
    
	JComboBox<Object> ed= new JComboBox<Object>(point);    
    ed.setBounds(350, 50,250,20);
    System.out.print("hello");
    JButton b= new JButton("Proceed");
    b.setBounds(275,100,95,30);
    b.addActionListener((ActionListener) this);
    f.add(cb);f.add(ed);
    f.add(l1);f.add(l2);
    f.add(b);
    
    f.setLayout(null);    
    f.setSize(800,800);    
    f.setVisible(true);    
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
        }
      };
      cb.addActionListener(actionListener);
      ed.addActionListener(actionListener);
    //code for point != point condition
      findDriver(cb.getSelectedIndex());
}    
public void findDriver(int a) {
	try {
		Connection con=getConnection();
		PreparedStatement statement1=con.prepareStatement("SELECT Name FROM drivers WHERE Location=a");
		PreparedStatement statement2=con.prepareStatement("SELECT Rating FROM drivers WHERE Location=a");
		ResultSet result1=statement1.executeQuery();
		ResultSet result2=statement2.executeQuery();
		ArrayList<String> array1=new ArrayList<String>();
		int array[]=new int[5];
		JTextField t1;
		JLabel l1;
		int i=0;
		while(result1.next()) {
			array1.add(result1.getString("Name"));
			array[i]=result2.getInt("Rating");
			i++;
		}
		/*
		 *    t1=new JTextField(" ");  
	    t1.setBounds(50,50, 200,30); 
	    
	     l2=new JLabel("User Id");  
	    l2.setBounds(50,100, 100,30);
		 */
		if(i==0)
		{
			DriverNotAvailable(a)
			System.out.println("Driver is not available");
			l1=new JLabel("Driver is not available");
			l1.setBounds(50,100,250,20);
		}
		else {
		int s=sort(array,i);
		l1=new JLabel("Driver is"+array1.get(s));
		l1.setBounds(50,100,250,20);
		}
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
}
public void DriverNotAvailable(int a){
	try {
	Connection con=getConnection();
	String s=point[a-1];
	PreparedStatement statement3=con.prepareStatement("SELECT 's' FROM destination WHERE Location=a");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public int sort(int array[],int n)
{
	int max=array[0];
	for(int i=0;i<n;i++)
	{
		if(array[i]>array[max])
			max=i;
	}
	return max;
}
public static Connection getConnection() throws Exception{
	  try{
	   String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/finaldestination";
	   String username = "root";
	   String password = "abcd";
	   Class.forName(driver);
	   
	   Connection conn = DriverManager.getConnection(url,username,password);
	   System.out.println("Connected");
	   return conn;
	  } catch(Exception e){System.out.println(e);}
	  return null;
	 }
public static void main(String[] args) {    
    new Option();         
}    
} 
