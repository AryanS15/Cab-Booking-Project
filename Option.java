import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;
public class Option
{ 
	public String e,b,c;
public float fr;
public int t;
public int dist;
public int[] dis=new int[5];
int arr[]=new int[5];
JFrame f;  
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JComboBox<Object> cb,ed;
public static float amount;
Connection con=DBConnect.getConnection();
String point[]={"BPHC","Secunderabad_Railway_Station","Thumkunta","Airport","Begumpet"}; 
public Option(float wallet){    
    f=new JFrame("Select a route");           
    amount = wallet;
    l1=new JLabel("From : ");
    l1.setBounds(50,25,250,20); 
	
	cb= new JComboBox<Object>(point);    
    cb.setBounds(50, 50,250,20);
    
    try {
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
  
    }
    catch(Exception e)
    {
    	
    }
    
    
    JButton b= new JButton("Proceed");
    b.setBounds(275,100,95,30);
	b.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent ae) {
			getloc(cb.getSelectedItem().toString());
			details(cb.getSelectedItem().toString(),ed.getSelectedItem().toString());
			System.out.println("DIstance : "+dist+" km");
			if(dist==0)
			{
				JOptionPane.showMessageDialog(null, "Please select different source/destination");
			}
			else
			{
				l3=new JLabel("Congratulations! Your Trip is confirmed");
				l3.setBounds(210,150,300,30);
				f.add(l3);
				dispDistCalcTimeAndFare(dist);
				if(dist!=-1) {
				JButton b1=new JButton("Begin Trip");
				b1.setBounds(275,500,200,50);
				f.add(b1);
				b1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ae) {
						String query2="UPDATE registration SET Busy=1 WHERE Name=+ ";//pass user name as argument to the function to update his busy status
						PreparedStatement statement2=con.prepareStatement(query2);
						statement2.executeQuery();
						String query3="UPDATE driver SET Busy=1 WHERE Name='"+e+"'";//driver busy status is updated to one as soon as the trip begins
						PreparedStatement statement3=con.prepareStatement(query3);
						statement3.executeQuery();
				new MyTimer(5,amount,fr,e);
					}
				});
				}
				else
				{
					System.out.println("No driver is available");//dist=-1 means all drivers are busy
				}

			}
		}
	});
	
	
    f.add(cb);f.add(ed);
    f.add(l1);f.add(l2);
    f.add(b);
    
    f.setLayout(null);    
    f.setSize(800,800);    
    f.setVisible(true);    
    

  
}    
public void findDriver(int i) {
	if(i<5) {
	try {
			String query="SELECT * FROM drivers WHERE Location='"+arr[i]+"'";
			PreparedStatement statement=con.prepareStatement(query);
			statement.executeQuery();
			String query1="SELECT * FROM drivers WHERE Location='"+arr[i]+"',Busy=0 AND Rating=(SELECT MAX(Rating) FROM drivers WHERE Location = '"+arr[i]+"')";
			//Busy=0 is to check if any free driver is available at that location
			PreparedStatement statement1=con.prepareStatement(query1);
			
			ResultSet result=statement1.executeQuery();
			if(result.next())
			{
				e=result.getString("Name");
				b=result.getString("Rating");
				c=result.getString("Mobile");
				String query2="UPDATE driver SET Busy=1 WHERE Name='"+e+"'";
				PreparedStatement statement2=con.prepareStatement(query);
				statement2.executeQuery();
			}
			else
			{	
				//driver with highest rating from min distance location
				//NoDriver();
				i=i+1;
				findDriver(i);
			}
		}
		catch(Exception e)
		{
			System.out.println("errrroooorrrrr"+e);
		}
	}
	else
	{
		System.out.println("All drivers are busy");
		dist=-1;
	}
}
//public void NoDriver()
//{
//	String query="SELECT * FROM drivers WHERE Location='"+(a+1)+"' AND Rating=(SELECT MAX(Rating) FROM drivers WHERE Location = '"+(a+1)+"')";
//}
//
public void getloc(String object1)  //cb.getSelectedItem() is the source and ed.getSelectedItem() is the destination
{
	//This function stores the values of all distances and destinations from the source in the arrays which are globally defined
	try
	{
		System.out.println(object1);
		
		int i=0;
			
	 String query = "SELECT BPHC,Secunderabad_Railway_Station,Thumkunta,Airport,Begumpet FROM final WHERE Source='"+object1+"'";
	 PreparedStatement statement3=con.prepareStatement(query);
		
		ResultSet result=statement3.executeQuery(query);
		while(result.next())
		{
			String d=result.getString(object1);
			dis[i]=Integer.parseInt(d);
			arr[i]=i+1;
			i++;
		}
		for(int j=1;j<=4;j++)
		{
			for(int k=0;k<j;k++)
			{
				if(dis[j]<dis[k])
				{
					int temp1=dis[j];
					dis[j]=dis[k];
					dis[k]=temp1;
					int temp2=arr[j];
					arr[j]=arr[k];
					arr[k]=temp2;
				}
			}
		}
	}
		catch(Exception e)
		{
			System.out.println("errrroooorrrrr "+e);
			
		}
}
public void details(String object1,String object2)  //cb.getSelectedItem() is the source and ed.getSelectedItem() is the destination
{
	//This function provides the distance from source to destination
	try
	{
		System.out.println(object1+" "+object2);
		String query = "SELECT "+object1+" FROM final WHERE Source='"+object2+"'";
	 PreparedStatement statement3=con.prepareStatement(query);
		
		ResultSet result=statement3.executeQuery(query);
		while(result.next())
		{
			String d=result.getString(object1);
			dist=Integer.parseInt(d);
		}
		
		
			
			
	}
	catch(Exception e)
	{
		System.out.println("errrroooorrrrr "+e);
		
	}
	
	
	
}

	public void dispDistCalcTimeAndFare(int d)
	{
		fr=3*d;
		t=4*d;
		
		l4=new JLabel("Duration of the trip :"+t+" minutes");
		l5=new JLabel("Fare for the trip : Rs. "+fr);
		l6=new JLabel("Distance of the trip : "+d+" km");
		l7=new JLabel("Name of driver :"+e);
		l8=new JLabel("Rating of driver :"+b);
		l9=new JLabel("Mobile No. of driver :"+c);
		l7.setBounds(210,200,300,30);
		l8.setBounds(210,225,300,30);
		l9.setBounds(210,250,300,30);
		l6.setBounds(210,350,300,30);
		l4.setBounds(210,375,300,30);
		l5.setBounds(210,400,300,30);
		f.add(l4); f.add(l5); f.add(l6); f.add(l7); f.add(l8); f.add(l9);
		
		
		
	}
	
public static void main(String[] args) {    
    new Option(1000);         
}
}
