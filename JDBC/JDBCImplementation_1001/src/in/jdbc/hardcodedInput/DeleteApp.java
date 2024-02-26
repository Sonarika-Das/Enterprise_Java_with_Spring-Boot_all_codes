package in.jdbc.hardcodedInput;

//Standard Steps followed for developing JDBC(JDBC4.X) Application

//rt.jar => jdk s/w
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {

	public static void main(String[] args) throws SQLException {

		//Resources used in JDBC application
		Connection connection = null;
		Statement statement = null;
		
		//2. Establish the Connection b/w java application and database
		String url="jdbc:mysql://localhost:3306/enterprisejava";
		String username="root";
		String password="1234";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			if(connection != null) {
				//3.Use Statement object (to move to the location using connection)
				statement = connection.createStatement();
				if(statement != null) {
					//4.Using Statement object execute the query
					String sqlDeleteQuery="delete from student where sid=5";
					int noOfRows = statement.executeUpdate(sqlDeleteQuery);
					System.out.println("No of rows deleted :: " + noOfRows);
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
		}
			
	}

}
