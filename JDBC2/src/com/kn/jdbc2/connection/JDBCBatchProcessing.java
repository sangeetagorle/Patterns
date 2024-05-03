package com.kn.jdbc2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBatchProcessing {
	private static final String URL="jdbc:mysql://localhost:3306/university";
	private static final String USERNAME="root";
	private static final String PASSWORD="Bruno80@8088";
	private static final String QUERY1="UPDATE TRAINER SET GENDER='MALE' WHERE ID!=1;"; 
	private static final String QUERY2="UPDATE TRAINER SET GENDER='FEMALE' WHERE ID=1;"; 
	public static void main(String[] args) {
		
		Connection con=null;
		try {
			//1. Load and register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Establish connection with datbase
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			//3.Create statement object
			Statement stmt=con.createStatement();
		//BATCHPROCESSING-"Execution of multiple queries at a time
			//(A). set Autocommit to false	
		con.setAutoCommit(false);
		    //(B). Add task to Batch
		stmt.addBatch(QUERY1);//3 rows affected
		stmt.addBatch(QUERY2);//1 rows affected
		    //(C). Get count of records
		int[] countBatch=stmt.executeBatch();
		for(int count:countBatch) {
			System.out.println(count+" rows affected");
		}
		   //(D). Commit
		con.commit();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					//4.Closing connection
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
