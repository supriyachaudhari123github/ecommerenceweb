package com.velocity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EcommerceDataBase
{
   public static void main(String[] args)
   {
	try
	{
		String sql =" insert into product(p_id, p_name,p_discription ,p_price,p_quantity )"
				+ "values (1,'pen',' ball pen', 5.0,10),(2,'pencil','apsara pencil',7.0,10 ),(3,'eraser','camel',5.0,10),(4,'scale','classmate',10.0,12),(5,'exam bord','classmate',130.0,10),(6,'notebook','classmate',60.0,12),(7,'book','GK',100.0,12),(8,'calculator','casio',780.0,10),\r\n"
				+ "(9,'sketch pen','camel',10.0,12),(10,'pen ink','camel',70.0,12)";  
	
	   Class.forName("com.mysql.cj.jdbc.Driver");
	
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Supriya@1996");
	  Statement statement = con.createStatement();
	  statement.execute(sql);
	  System.out.println("Insertion successfully...");
	  con.close();
	  statement.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
   }
}
