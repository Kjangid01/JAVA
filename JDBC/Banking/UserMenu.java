import java.util.*;
//import java.sql.*;

class UserMenu
{
    public void User(int accnum,int Bal,int pin)
    {
        Scanner scn=new Scanner(System.in);
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

        System.out.println("Enter the choice:");
        int ch=scn.nextInt(); 
        
        //for deposit money
        if(ch==1){
            
            System.out.print("Enter Deposit Money: ");
            int money=scn.nextInt();
            String sql="update Account set Balance=Balance+"+money+" where Account_no="+accnum;
            DBClass2 ob= new DBClass2();
            ob.moddata(sql);
            System.out.println("Balance updated Successfully..Thanku");

        }

        //for withdraw money
        else if(ch==2){
            try {                    
                DBClass2 ob= new DBClass2();                            
                System.out.println("Enter the Withdraw Money");
                int wmoney=scn.nextInt();
                if(Bal>=wmoney){
                String sql2="update Account set Balance=Balance-"+wmoney+" where Account_no="+accnum;                    
                ob.moddata(sql2);
                System.out.println("Balance updated Successfully..Thanku");  
                }
                else 
                {
                    System.out.println("Insufficient Balance.");
                }
            } catch (Exception e) {
                System.out.print(e);
            }       
        }

        //for transferring amount
        else if(ch==3){
            System.out.print("Enter the reciever's account number: ");
            int reciever_acc=scn.nextInt();

            System.out.print("Transfer Amount: ");
            int amt=scn.nextInt();

            System.out.print("Enter PIN: ");
            int mpin=scn.nextInt();

            try {                   
                if(mpin==pin){
                    String recieverq="update Account set Balance=Balance+"+amt+" where Account_no="+reciever_acc;
                    String selfQ = "update Account set Balance=Balance-"+amt+" where Account_no="+accnum;
                    DBClass2 ob =new DBClass2();
                    ob.moddata(recieverq);
                    ob.moddata(selfQ);
                    System.out.print("Transfered Amount Successfully..");
                }
                else {
                    System.out.print("Entered PIN is incorrect. Transaction failed.");
                }                                   
            } catch (Exception e) {
                System.out.println(e);
            }                
        }

        //for Balance Inquiry
        else if(ch==4)
        {
            System.out.println("your current balance is: "+Bal);
            // try
            // {
            //     String sql="select * from accounts where accno="+accnum;
            //     DBClass2 ob =new DBClass2();
            //     ResultSet rs=ob.fetchdataa(sql);                           
                    
            //         }
            // catch(Exception e)
            // {
            //     System.out.println(e);
            // }                                      
        }

        //for Tranaction History
        scn.close();
    }
}