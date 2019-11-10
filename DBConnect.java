import java.sql.*;


/**
 * @author karthikshetty03
 *
 */
public class DBConnect {

	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","karthik@12345");
			st=con.createStatement();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error "+ex);
		}
		
	}
	
	public void getData() {
		try {
			String query = "select * from persons";
			rs=st.executeQuery(query);
			System.out.println("Records from database");
			while(rs.next())
			{
				String name=rs.getString("name");
				String age = rs.getString("age");
				System.out.println("Name :" +name + "Age : " + age);
				
				
				
				
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error ! " + ex);
		}
	}


	public static void main(String args[]) {
		DBConnect connect = new DBConnect();
		
	}

}
