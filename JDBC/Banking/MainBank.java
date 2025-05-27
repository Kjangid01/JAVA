import java.util.*;
import java.sql.*;

class Bank
{
	public void showMainMenu()
	{
		System.out.println("------------------------------");
		
		System.out.println("1.Login");	
			
		System.out.println("2.Create new Account");

		System.out.println("3.Admin");

		System.out.println("4.Exit");
	
		System.out.println("------------------------------");
 
		Scanner scn=new Scanner(System.in);

		System.out.print("Enter the choice:");

		int choice=scn.nextInt();


		if(choice==1)
		{	//AuthenticateUser();
			Login();			

		}
		else
		{
			if(choice==2)
				CreateAccount();
		}
		scn.close();

	}

	//for login process
	public void Login()
	{
		Scanner scn=new Scanner(System.in);
		try {						
			while (true) {
				
				System.out.print("Enter Account no. for banking: ");
				int acc=scn.nextInt();
				System.out.print("Enter PIN: ");
				int pin =scn.nextInt();	
				String sql = "select * from account where Account_no="+acc+" and Pin="+pin;
				DBClass2 ob=new DBClass2();	
				ResultSet rs=ob.fetchdataa(sql);				
				if(rs.next())
				{
					int bal=rs.getInt(3);
					
					UserMenu um=new UserMenu();
					um.User(acc,bal,pin);
				}
				
				else{
					System.out.println("Entered account number is incorrect. Enter Again.");					
				}
								
			}
		} catch (Exception e) {			
			System.out.println(e);
		}	
		scn.close();
	}

	//for creating account
	public void CreateAccount()
	{
		try
		{
			Scanner scn=new Scanner(System.in);

			System.out.print("Enter your name:");

			String name=scn.nextLine();

			System.out.print("Enter Initial Deposit:");
	
			int balance=scn.nextInt();

			System.out.print("Create a 4-digit PIN:");

			int pin=scn.nextInt();

			int accno;

			String sql="select * from Account";
                
            		DBClass2 ob=new DBClass2();
 
			ResultSet rs=ob.fetchdataa(sql);
 			
			if(rs.next())
			{
				accno=rs.getInt(1);
				while(rs.next())
				{
					accno=rs.getInt(1);
				}
				accno++;	
			}	
			else
			{
				accno=1000;			
			}
			
			ob.moddata("insert into Account values("+accno+",'"+name+"',"+balance+","+pin+")");

			System.out.println("Data inserted successfully, "+accno+" account created.");
			
			scn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	/*public void operation()
	{
		try
		{
			System.out.println("------------------------------");

			System.out.println("Banking Operations:-");

			System.out.println("------------------------------");

			System.out.println("1.Deposit Money");

			System.out.println("2.Withdraw Money");

			System.out.println("3.Transfer Funds");

			System.out.println("4.Balance Inquiry");

			System.out.println("5.Tranaction History");

			System.out.println("6.Log out");

			System.out.println("------------------------------");

			// System.out.println("Enter the choice:");

			// int choice=scn.nextInt();


		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	} */

	
	/*public void admin()
	{
		try
		{
			System.out.println("------------------------------");

			System.out.println("Admin DashBoard:-");

			System.out.println("------------------------------");

			System.out.println("1.View All Accounts");

			System.out.println("2.Delete an Account");

			System.out.println("3.Reset User PIN");

			System.out.println("4.Log out");

			System.out.println("------------------------------");

			System.out.println("Enter the choice");

			int choiceA=scn.nextInt();

			if(choiceA==1)
			{
				//String sql="select * from account";

				//ResultSet rs=stmt.executeQuery(sql);
			}

		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
	}*/
	
	}
class MainBank
{
		public static void main(String args[])
		{
			Bank ob=new Bank();

			ob.showMainMenu();

			//ob.operation();

			//ob.admin();	
		}
}
					
				 

		