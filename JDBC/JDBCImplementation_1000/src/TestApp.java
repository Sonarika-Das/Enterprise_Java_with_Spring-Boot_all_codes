import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class TestApp {

	public static void main(String[] args) throws SQLException {
		//step-1 load and register the driver
		Driver driver=new Driver(); // creating mysql specific object / creating driver object for mysql db
		DriverManager.registerDriver(driver); // in jre create an environment so that i can talk to jdbc
		System.out.println("Driver registered successfully");
		
		
		//step-2 Establish the Connection b/w java application and database
		//in DriverManager class there are 3 connection methods
		//JDBC URL Syntax: <mainprotocol>:<subprotocol>:<subname>
		String url="jdbc:mysql://localhost:3306/enterprisejava";
		String username="root";
		String password="1234";
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection object is created :: " + connection);
		System.out.println();
		System.out.println("Implementation class of the connection is :: " + connection.getClass().getName());
		
		
		//step-3 Create a Statement Object
		Statement statement = connection.createStatement();
		System.out.println("Statement object is created :: " + statement);
		
		//step-4 Send and execute the Query
		String sqlSelectQuery="select sid,sname,sage,saddr from student";
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		System.out.println("ResultSet object is created :: " + resultSet);
		
		//step-5 Process the result from ResultSet
		System.out.println("SID\tSNAME\tSAGE\tSADDR");
		while(resultSet.next()) {
			Integer sid = resultSet.getInt(1);
			String sname = resultSet.getString(2);
			Integer sage = resultSet.getInt(3);
			String saddr = resultSet.getString(4);
			System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
		}
		
		//step-6 Close the connection
		connection.close();
		
		System.out.println("Closing the connection....");
		
	}
		
}
