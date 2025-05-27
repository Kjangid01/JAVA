
import java.util.*;
import java.sql.*;

class BankMenu{

    public void showMainMenu(){

        System.out.println("------------------------------");
        System.out.println("1.Login");
        System.out.println("2.Create new Account");
        System.out.println("3.Admin");
        System.out.println("4.Exit");
        System.out.println("------------------------------");

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the choice (1/2/3/4): ");
        int ch= scn.nextInt();

        switch (ch) {
            case 1: Login();                
                break;

            case 2: CreateAcc();
                break;

            case 3: Admin();
                break;

            default: scn.close();
                break;
        }
    }

    //for login 
    public void Login() {        
        Scanner scn = new Scanner(System.in);
      
        try {                
            System.out.print("Enter Account no. for banking: ");
            int acc_num = scn.nextInt();

            System.out.print("Enter PIN: ");
            int pin = scn.nextInt();

            String query = "select * from accounts where Account_num=" + acc_num + " and PIN=" + pin;
            dbOperation db = new dbOperation();
            ResultSet rs = db.fetchQ(query);

            if (rs.next()) {
                int PIN = rs.getInt(4);
                int bal = rs.getInt(3);
                LoginMenu menu = new LoginMenu();
                menu.UserLogin(acc_num,PIN,bal);
            } else {
                System.out.println("Entered account number is incorrect. Enter Again.");
            }          
        } catch (Exception e) 
            {
                System.out.println(e);
            }
            scn.close();
    }

    //create account
    public void CreateAcc(){
        Scanner scn = new Scanner(System.in);
        try
		{
			System.out.print("Enter your name:");
			String name=scn.nextLine();

			System.out.print("Enter Initial Deposit:");	
			int balance=scn.nextInt();

			System.out.print("Create a 4-digit PIN:");
			int pin=scn.nextInt();

			int accno;

			String sql="select * from Accounts";                
            dbOperation ob=new dbOperation(); 
			ResultSet rs=ob.fetchQ(sql);
 			
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
			
			ob.updateQ("insert into accounts values("+accno+",'"+name+"',"+balance+","+pin+")");
			System.out.println("Account created . Your Account number is: "+accno);			
			scn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
    }

    //for admin 
    public void Admin(){
        Scanner scn = new Scanner(System.in);
      
        try {                
            System.out.print("Enter username: ");
            String usern = scn.nextLine();

            String query1 = "select * from admin where username='"+usern+"'";
            dbOperation db = new dbOperation();
            ResultSet rs1 = db.fetchQ(query1);
            if (rs1.next()) {
                String password= rs1.getString(3);
                System.out.print("Enter Password: ");
                String pass = scn.nextLine();
                
                if(pass.equals(password)){
                    
                    AdminMenu admin = new AdminMenu();
                    admin.Admin(usern,password);

                }
                else{
                    System.out.println("Wrong password...");
                }

            } else {
                System.out.println("Entered username is incorrect.");
                
            }          
        } catch (Exception e) 
            {
                System.out.println(e);
            }
            scn.close();

    }

}

class Bank{
    public static void main(String args[]){

        BankMenu b1= new BankMenu();
        b1.showMainMenu();
    }
}
    
