import java.sql.ResultSet;
import java.util.*;

//import javax.naming.spi.DirStateFactory.Result;

public class AdminMenu {
    
    Scanner scn = new Scanner(System.in);
    dbOperation ob = new dbOperation();

    public void Admin(String username, String pword){

        System.out.println("------------------------------");
        System.out.println("------Admin Operations:------");
        System.out.println("------------------------------");
        System.out.println("1.Manage Accounts");
        System.out.println("2.Manage Transactions");
        System.out.println("3.Report");
        System.out.println("4.Change Password");
        System.out.println("5.Exit");
        System.out.println("------------------------------");
        System.out.print("Enter the choice: ");

        int ch= scn.nextInt();

        switch (ch) {
            case 1: manage_acc();         
                break;

            case 2: del();             
                break;

            case 3: report();            
                break;

            case 4: changePass(username, pword);            
                break;
        
            default:System.out.println("incorret input entered.");
                break;
        }

    }

    //show account table
    public void show(){
        try {
            String sql = "select * from accounts";
            dbOperation ob = new dbOperation();
            ResultSet rs = ob.fetchQ(sql);
            System.out.println("------------------------------------");
            System.out.println("Acc_no. \tAcc Holder Name \tBalance ");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t\t"+rs.getDouble(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
   }

    //delete account : 2
    public void del(){
        show();
        System.out.println("------------------------------------");
        Scanner scn = new Scanner(System.in);
        try {
            System.out.print("Enter account number to delete. :");
            int acc=scn.nextInt();
            dbOperation ob = new dbOperation();
            String sql1= "select * from accounts where account_num="+acc;
            ResultSet rs = ob.fetchQ(sql1);
            if(rs.next()){
                String sql = "delete from accounts where account_num="+acc;            
                ob.updateQ(sql);
                System.out.println("Account deleted Successfully.");
            }
            else {
                System.out.println("invalid account number.");
            }           
        } catch (Exception e) {
            System.out.println(e);
        }
        scn.close();
    }

    //update account
    public void update(){
        show();
        System.out.println("------------------------------------");
        Scanner scn = new Scanner(System.in);
        try {
            System.out.print("Enter account number to manage changes:");
            int acc=scn.nextInt();
            String sql1= "select * from accounts where account_num="+acc;
            ResultSet rs = ob.fetchQ(sql1);
            if(rs.next()){
                //int pin=rs.getInt(3);
                System.out.print("want to change what-> :");
                System.out.print("1.Change User name");
                System.out.print("2.Change PIN");
                System.out.print("Enter the choice: ");
                int ch3= scn.nextInt();
                if(ch3==1){
                    System.out.print("Enter new Name:  ");
                    String name = scn.nextLine();
                    String sql ="update accounts set Acc_Holder_name='"+name+"' Account_num="+acc;
                    ob.updateQ(sql);
                    System.out.println("Account holder name changed successfuly..");
                } else if(ch3==2){
                    System.out.print("Enter new PIN:  ");
                    int npin = scn.nextInt();
                    String sql ="update accounts set pin="+npin+" Account_num="+acc;
                    ob.updateQ(sql);
                    System.out.println("Account PIN changed successfuly..");
                }else {
                System.out.println("invalid account number.");
                }
            }else{
                System.out.println("Invalid account number");
            }           
        } catch (Exception e) {
            System.out.println(e);
        }
        scn.close();
    }

    //change password :3
    public void changePass(String uname, String pass){
        System.out.println("------Change Password-------");
        //System.out.println(pass);
        System.out.print("Enter old password : ");
        String oldPass = scn.next();
        //System.out.println(oldPass);
        if(pass.equals(oldPass)){
            System.out.println("");        
            System.out.print("enter new password: ");
            String password=scn.next();
            
            System.out.print("enter confirm password: ");
            String cpassword=scn.next();
            
            if(password.equals(cpassword)){
                String query = "update admin set password='"+password+"' where username='"+uname+"'";            
                ob.updateQ(query);
                System.out.println("Password updated successfully.");       
            } else {
                
                System.out.println("new password and confirm password not match."); 
            }
        } else {
            System.out.print("old password is incorrect.");
            return;
        }
    }

    // Manage accounts
    public void manage_acc(){
        System.out.println("------------------------------");
        System.out.println(" ");
        System.out.println("1.Create New Accounts");
        System.out.println("2.Delete Account");
        System.out.println("3.Update Account");
        System.out.println("4.Back-->");
        System.out.println("------------------------------");
        System.out.print("Enter the choice: ");
        int ch1= scn.nextInt();
        if(ch1==1){
            BankMenu bn= new BankMenu();
            bn.CreateAcc();
        }
        else if(ch1==2){
            del();
        }
        else if(ch1==3){
            update();
        }
        else if(ch1==4){
            //break;
        }
        else{
            System.out.println("Invalid input...");
        }
    }

    //reports
    public void report(){
        System.out.println("------------------------------");
        System.out.println(" ");
        System.out.println("1.List Accounts");
        System.out.println("2.Daili transactions");
        System.out.println("------------------------------");
        System.out.print("Enter the choice: ");

        int ch2= scn.nextInt();
        if(ch2==1){
            show();
        }
        else if(ch2==2){
            // show daily transactions
        }
        else{
            System.out.println("Invalid input...");
        }
    }

    
    
}
