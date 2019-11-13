import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;
public class Option
{    
JFrame f;    
Option(){    
    f=new JFrame("ComboBox Example");    
    String point[]={"BPHC","Secunderabad Railway Station","Thumkunta","Airport","Parade Ground"};        
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
		ArrayList<int> array2=new ArrayList<Int>();
		JTextField t1;
		int i=0;
		while(result1.next()) {
			array1.add(result1.getString("Name"));
			array2.add(result2.getInt("Rating"));
		}
		String s=sort(array1);
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