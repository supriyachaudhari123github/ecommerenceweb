package com.velocity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class UserRegistartion
{
	 public void userRegistation()throws SQLException
	 {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter your First Name: ");
		 String fname = sc.next();
		 System.out.println("Enter your Last Name: ");
		 String lname = sc.next();
		 System.out.println("Create User Name: ");
		 String uname = sc.next();
		 System.out.println("Create Password: ");
		 String pword = sc.next();
		 Connection con =null;
		 PreparedStatement ps = null;
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Supriya@1996");
			 ps = con.prepareStatement("insert into user1(firstname,lastname, username , password1) values (?,?,?,?)");
			 ps.setString(1, fname);
			 ps.setString(2, lname);
			 ps.setString(3, uname);
			 ps.setString(4, pword);
			 int a = ps.executeUpdate();
			 System.out.println("User Registration Successfull...."+a);	 
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
				
			}
		 finally
			{
				if(ps!=null)
				{  
					try {
						ps.close();
				        }
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
				}
				if(con!=null)
				{  
					try {
						con.close();
				        }
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
				}
				
			}
	 }
	 
	 public int userLogin() throws SQLException
	 {
		 int count = 0;
		 int co = 0;
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try
		 {
			 Scanner scanner = new Scanner(System.in);
			 
			 System.out.println("Enter User Name: ");
			 String uname = scanner .next();
			 System.out.println("Enter Password: ");
			 String pword = scanner .next();
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Supriya@1996");
			 ps = con.prepareStatement("select username , password1 from user1 where username = ? and password1 = ? ");
		
			 ps.setString(1, uname);
			 ps.setString(2, pword);
			 rs = ps.executeQuery();
			 while(rs.next())
			 {
				 String s1 = rs.getString("username");
				 String s2 = rs.getString("password1");
				 if(s1.contains(uname)&& s2.contains(pword))
				 {
					 count = 1;
				 }
				 System.out.println("sucessfully login....");
			 }
			 
			 
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
				
			}
		 finally
			{
				if(ps!=null)
				{  
					try {
						ps.close();
				        }
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
				}
				if(con!=null)
				{  
					try {
						con.close();
				        }
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
				}
				
			}
		 if(count == 1)
		 {
			 co = count;
		 }
		 
		return co;
		 
		 
	 }
	 public void getManu()
		{
			
			Connection con =null;
			 PreparedStatement ps = null;
			 try
			 {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Supriya@1996");
				 ps = con.prepareStatement("select * from product");
				 ResultSet rs = ps.executeQuery();
				 String productid = "p_id";
				 String name ="p_name";
				 String discription = "p_discription";
				 String prise = "p_price";
				 String quantity = "p_quantity";
				 System.out.printf("%-30s%-30s%-30s%-30s%-30s\n",productid,name,discription ,prise,quantity);	 
				 while(rs.next())
				 {
					 int id = rs.getInt("p_id");
					 String pname = rs.getString("p_name");
					 String discrip = rs.getString("p_discription");
					 float pris = rs.getFloat("p_price");
					 int qty = rs.getInt("p_quantity");
					 System.out.printf("%-30s%-30s%-30s%-30s%-30s\n",id,pname,discrip,pris,qty);	
					 }
			 
			 }
			 catch(Exception e)
				{
					e.printStackTrace();
					
				}
		}
	 public static void main(String[] args) throws SQLException
	 {
		 UserRegistartion ur = new UserRegistartion();
		 int choice;
		 Scanner sc = new Scanner(System.in);
		  System.out.println("Enter 1 if you have already account ");
		  System.out.println("Enter 2 for create account ");
		  choice = sc.nextInt();
		  switch(choice)
		  {
		  case 1 : int a = ur.userLogin();
		           if(a == 1)
		           {
		        	   ur.getManu();
		           }
		           else
		           {
		        	   System.out.println("Enter valid username and password"); 
		           }
                 break;
		  case 2 : ur.userRegistation();
		         break;
		  default:  System.out.println("click on valid option ");
			      
		  }
		  
		  }
		 
	 

}
