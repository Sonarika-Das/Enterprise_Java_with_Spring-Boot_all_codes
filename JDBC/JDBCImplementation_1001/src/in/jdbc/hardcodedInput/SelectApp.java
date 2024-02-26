package in.jdbc.hardcodedInput;

//Standard Steps followed for developing JDBC(JDBC4.X) Application

//rt.jar => jdk s/w
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//MYSQL JAR -> Given by MYSQL DB Vendor
import com.mysql.cj.jdbc.Driver;

public class SelectApp {

	public static void main(String[] args) throws SQLException {

		//Resources used in JDBC application
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
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
					String sqlSelectQuery="SELECT SID,SNAME,SAGE,SADDR FROM STUDENT";
					resultSet = statement.executeQuery(sqlSelectQuery);
					if(resultSet != null) {
						//5.Process the result from ResultSet
						System.out.println("SID\tSNAME\tSAGE\tSADDR");
						while(resultSet.next()) {
							int sid = resultSet.getInt("sid");
							String sname = resultSet.getString("sname");
							int sage = resultSet.getInt("sage");
							String saddr = resultSet.getString("saddr");
							System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
							
						}
					}
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Closing up all the resources
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
			
	}

}
