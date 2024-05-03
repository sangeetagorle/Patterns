package com.kn.jdbc2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {
	
	private static final String URL="jdbc:mysql://localhost:3306/university";
	private static final String USERNAME="root";
	private static final String PASSWORD="Bruno80@8088";
	private static final String CREATE_TRAINER_TABLE="CREATE TABLE TRAINER1(ID INT,NAME VARCHAR(20));";
	//private static final String INSERT_TRAINER_TABLE="INSERT INTO TRAINER VALUES(1,'Punit'),(2,'Ayush'),(3,'Arun');";
	//private static final String UPDATE_TRAINER_TABLE="UPDATE TRAINER SET NAME='Priya' WHERE NAME='Punit';";
	//private static final String SELECT_TRAINER_TABLE="SELECT*FROM TRAINER;";
	public static void main(String[] args) {
		Connection con=null;
		try {
			//1.Load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish the connection with database
		con=DriverManager.getConnection(URL, USERNAME,PASSWORD);
		
		//3.Create statement object
		Statement stmt=con.createStatement();
		
		//4.Send and execute query
		stmt.execute(CREATE_TRAINER_TABLE);
		System.out.println("Query executed successfully");
		//int rows=stmt.executeUpdate(INSERT_TRAINER_TABLE);
		/*ResultSet rs=stmt.executeQuery(SELECT_TRAINER_TABLE);
		while(rs.next()) {
			System.out.println("ID= "+rs.getInt(1)+",NAME= "+rs.getString(2));
		}*/
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
	
	}finally {
		try {
			if(con!=null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
	}
	}
	}
}
