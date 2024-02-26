package in.jdbc.dynamicInput;

//Standard Steps followed for developing JDBC(JDBC4.X) Application

//rt.jar => jdk s/w
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {

	public static void main(String[] args) throws SQLException {

		//Resources used in JDBC application
		Connection connection = null;
		Statement statement = null;
		
		//2. Establish the Connection b/w java application and database
		String url="jdbc:mysql://localhost:3306/enterprisejava";
		String username="root";
		String password="1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sname :: ");
		String sname = sc.next();
		System.out.println("Enter the sage :: ");
		int sage = sc.nextInt();
		System.out.println("Enter the saddr :: ");
		String saddr = sc.next();
		
		//*sname="'" + sname +"'";
		//*saddr="'" + saddr +"'";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			if(connection != null) {
				//3.Use Statement object (to move to the location using connection)
				statement = connection.createStatement();
				if(statement != null) {
					//4.Using Statement object execute the query
					//*String sqlInsertQuery="Insert into student(sname,sage,saddr) values(" +sname + "," +sage+ "," + saddr +")";
					String sqlInsertQuery = String.format("Insert into student(sname,sage,saddr) values('%s',%d,'%s')" ,sname,sage,saddr );
					int noOfRows = statement.executeUpdate(sqlInsertQuery);
					System.out.println(sqlInsertQuery);
					System.out.println("No of rows inserted :: " + noOfRows);
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Closing up all the resources
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
			if(sc != null) {
				sc.close();
			}
		}
			
	}

}
