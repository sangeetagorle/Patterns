package com.kn.jdbc2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMethods {
	private static final String URL="jdbc:mysql://localhost:3306/university";
	private static final String USER_NAME="root";
	private static final String PASSWORD="Bruno80@8088";
	//private static final String CREATE_TRAINER_TABLE="CREATE TABLE TRAINER(ID INT,NAME VARCHAR(20),SALARY INT);";
	private static final String INSERT_TRAINER_TABLE="INSERT INTO TRAINER VALUES(?,?,?);";
	private static final String UPDATE_TRAINER_TABLE="UPDATE TRAINER SET SALARY=(SALARY+1000) WHERE ID= ?;";
	private static final String READ_TRAINER_TABLE="SELECT*FROM TRAINER;";
	private static final String DELETE_TRAINER_TABLE="DELETE FROM TRAINER WHERE ID= ?;";
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//1.load and register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//2.Establish the connection with database
			Connection con=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			
			System.out.println("Enter your choice");
			System.out.println("1.TO INSERT DATA");
			System.out.println("2.TO SELECT DATA");
			System.out.println("3.TO UPDATE DATA");
			System.out.println("4.TO DELETE DATA");
			int option=scan.nextInt();
			
			switch(option) {
			case 1:{
				insertEmpData(con,scan);
				break;
			}
			case 2:{
				readEmpData(con,scan);
				break;
			}
			case 3:{
				updateEmpData(con,scan);
				break;
			}
			case 4:{
				deleteEmpData(con,scan);
				break;
			}
			default:{
				System.out.println("Choose correct answer");
				
			}
			}
			/*Statement stmt=con.createStatement();	
			stmt.execute(CREATE_TRAINER_TABLE);*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

}
	private static void insertEmpData(Connection con,Scanner scan) {
		System.out.println("Enter id= ");
		int id=scan.nextInt();
		System.out.println("Enter Name= ");
		String name=scan.next();
		System.out.println("Enter Salary= ");
		double salary=scan.nextDouble();
		
		
		try {
			PreparedStatement pstmt=con.prepareStatement(INSERT_TRAINER_TABLE);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setDouble(3,salary);
			pstmt.execute();
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void readEmpData(Connection con,Scanner scan) {
		try {
			PreparedStatement pstmt=con.prepareStatement(READ_TRAINER_TABLE);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID= "+rs.getInt(1)
				+",NAME= "+rs.getString(2)
				+", SALARY= "+rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void updateEmpData(Connection con,Scanner scan) {
		
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_TRAINER_TABLE);
			System.out.println("ENTER ID WHOSE SALARY NEED TO BE UPDATED= ");
			int id=scan.nextInt();
			pstmt.setInt(1,id);
			pstmt.execute();
			System.out.println("salary for employee id= "+id+", has been updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	private static void deleteEmpData(Connection con,Scanner scan) {
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_TRAINER_TABLE);
			System.out.println("ENTER ID WHOSE SALARY NEED TO BE DELETED= ");
			int id=scan.nextInt();
			pstmt.setInt(1,id);
			pstmt.execute();
			System.out.println("salary for employee id= "+id+", has been deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
