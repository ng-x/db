
import java.sql.*;
import java.util.*;
import java.io.*;

public class Db
{
	  private static final String dbClassName = "com.mysql.jdbc.Driver";
	  private static final String CONNECTION = "jdbc:mysql://192.168.2.232/Gaurav";
	  public static void main(String[] args) throws ClassNotFoundException,SQLException,IOException
	  {
		   DataInputStream d = new DataInputStream(System.in);

		    //System.out.println(dbClassName);
		    Class.forName(dbClassName);

		    Connection c = DriverManager.getConnection(CONNECTION,"TEB55","");

		    ResultSet rs;
		    Statement s = c.createStatement();
int ch;
do
{

		System.out.print("\n\n**********    MENU     **********\n");
		  System.out.println("\t1.Show\n\t2.Insert\n\t3.Update\n\t4.Delete\n\t5.Min\n\t6.Max\n\t7.Avg\n\t8.Sum\n\t9.Count\n\t10.Exit");
		  System.out.print("Enter your choice :");
		  ch = Integer.parseInt(d.readLine());

		 switch(ch)
		{
			case 1:
				//System.out.print("1");
			String query = "select * from stud";
		   	rs = s.executeQuery(query);
			System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
		          System.out.println("_________________________________________________________________\n");

		         while(rs.next())
			{
				int rno = rs.getInt("stud_rno");
				String name = rs.getString("stud_name");
				String course = rs.getString("stud_course");
	
				System.out.println("\t"+rno+" \t\t |\t "+name+" \t\t| \t"+course+" \t\t\n");
			}
			 System.out.println("__________________________________________________________________\n");
			 System.out.println("Done !");
			
			break;

			case 2:
				//System.out.print("2");
				System.out.print("\nEnter your roll_no :");
  				int rno = Integer.parseInt(d.readLine());
				System.out.print("\nEnter your name :");
				String name = d.readLine();
				System.out.print("\nEnter your course :");
				String course = d.readLine();

				System.out.print("\nEnter your Marks :");
				String marks = d.readLine();

				String iquery = "insert into stud values("+rno+",'"+name+"','"+course+"','"+marks+"')";
			   	int a = s.executeUpdate(iquery);
				//System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
				System.out.println("Inserted\n");
				 System.out.println("Done !");
			
			break;

			case 3:
				//System.out.print("3");
				int b;
				String uquery;
				System.out.print("\nEnter your roll_no :");
  				rno = Integer.parseInt(d.readLine());
				System.out.print("1.Roll_No\n2.Name\n3.course");
				System.out.print("Enter choice what u want to update :");
				int chh = Integer.parseInt(d.readLine());

				switch(chh)
				{
					case 1:
						System.out.print("\nEnter your roll_no :");
  						rno = Integer.parseInt(d.readLine());
						uquery = "update stud set stud_rno = '"+rno+"' where stud_rno = "+rno+"";
					   	b = s.executeUpdate(uquery);
						//System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
						System.out.println("Updated\n");
						 System.out.println("Done !");
					break;

					case 2:
						System.out.print("\nEnter your name :");
  						name = d.readLine();
						uquery = "update stud set stud_name = '"+name+"' where stud_rno = "+rno+"";
					   	b = s.executeUpdate(uquery);
						//System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
						System.out.println("Updated\n");
						 System.out.println("Done !");
					break;

					case 3:
						System.out.print("\nEnter your course :");
  						course = d.readLine();
						uquery = "update stud set stud_course = '"+course+"' where stud_rno = "+rno+"";
					   	b = s.executeUpdate(uquery);
						//System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
						System.out.println("Updated\n");
						 System.out.println("Done !");
					break;
				}
			break;
		
				case 4:
				//System.out.print("3");
				System.out.print("\nEnter roll_no to be deleted :");
  				rno = Integer.parseInt(d.readLine());

				String dquery = "delete from stud where stud_rno = "+rno+"";
			   	b = s.executeUpdate(dquery);
				//System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
				System.out.println("Deleted\n");
				 System.out.println("Done !");
				
			break;
			
			case 5:
				query = "select * from stud where stud_rno =  (select min(stud_rno) from stud)";
		   		rs = s.executeQuery(query);
				
				System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
		          	System.out.println("_________________________________________________________________\n");
				if(rs.next())
				{
					int rno1 = rs.getInt("stud_rno");
					String name1 = rs.getString("stud_name");
					String course1 = rs.getString("stud_course");
	
					System.out.println("\t"+rno1+" \t\t |\t "+name1+" \t\t| \t"+course1+" \t\t\n");
				}
			 	System.out.println("__________________________________________________________________\n");
			 	System.out.println("Done !");
			break;

			case 6:
				query = "select * from stud where stud_rno =  (select max(stud_rno) from stud)";
		   		rs = s.executeQuery(query);
				
				System.out.println("\n\tRoll_No \t |\t Name \t \t|\t Course\t ");
		          	System.out.println("_________________________________________________________________\n");
				if(rs.next())
				{
					int rno1 = rs.getInt("stud_rno");
					String name1 = rs.getString("stud_name");
					String course1 = rs.getString("stud_course");
	
					System.out.println("\t"+rno1+" \t\t |\t "+name1+" \t\t| \t"+course1+" \t\t\n");
				}
			 	System.out.println("__________________________________________________________________\n");
			 	System.out.println("Done !");
			break;

			case 7:
				query = "select avg(marks) from stud";
		   		rs = s.executeQuery(query);
				rs.next();
				String avg = rs.getString(1);		          	
				System.out.println("_________________________________________________________________\n");
				System.out.println("Averge marks is :"+avg);			 	
				System.out.println("__________________________________________________________________\n");
			 	System.out.println("Done !");
			break;

			case 8:
				query = "select sum(marks) from stud";
		   		rs = s.executeQuery(query);
				rs.next();
				String sum = rs.getString(1);		          	
				System.out.println("_________________________________________________________________\n");
				System.out.println("Sum of Marks is :"+sum);			 	
				System.out.println("__________________________________________________________________\n");
			 	System.out.println("Done !");
			break;

			case 9:
				query = "select count(stud_rno) from stud";
		   		rs = s.executeQuery(query);
				rs.next();
				String cnt = rs.getString(1);		          	
				System.out.println("_________________________________________________________________\n");
				System.out.println("Count of records :"+cnt);			 	
				System.out.println("__________________________________________________________________\n");
			 	System.out.println("Done !");
			break;

			case 10:
				System.exit(0);
				c.close();
			break;
		}

}while(ch!=10);
	

		    
   	}
}
