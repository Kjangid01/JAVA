import java.util.*;
import java.sql.*;

class LoginMenu{

    Scanner scn = new Scanner(System.in);
    public void UserLogin(int accnum,int pin, int Bal) {

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
        System.out.print("Enter the choice: ");
 
        int ch=scn.nextInt();

        //for deposit money
        if(ch==1){
            deposit(accnum);          
        }

        //for withdraw money
        else if(ch==2){
            withdraw(accnum,Bal);
        }
        
        //for transfering funds
        else if(ch==3){
            transfer(accnum,Bal);
        }

        //for showing balance
        else if(ch==4){
            System.out.println("Your current balance: "+Bal);
        }

        //for history
        else if(ch==5){
            show_history(accnum,Bal);
        }

        else if(ch==6){
            scn.close();
            
        }
        else{
            System.out.println("Error..incorrect entered input.");
        }
    }

    public void deposit(int accnum){
        try {
            System.out.print("Enter Depositing Amount: ");
            int money=scn.nextInt();
            String sql="update Accounts set Balance=Balance+"+money+" where Account_num="+accnum;
            dbOperation ob= new dbOperation();
            ob.updateQ(sql);

            //for storing txn history
            String txnQ = "insert into transactions (account_no, type, amount) values("+accnum+",'Deposit',"+money+")";
            ob.updateQ(txnQ);
            System.out.println("Balance updated Successfully..Thanku");

            
        } catch (Exception e) {
            System.out.println("Ëxception: "+e);
        }        
    }

    public void withdraw(int accnum,int Bal){
        try {
            System.out.print("Enter Withdrawal Amount: ");
            int wmoney=scn.nextInt();
            dbOperation ob= new dbOperation();
            if(wmoney>Bal){
                System.out.print("Insufficient funds");
            }
            else{
                String sql="update Accounts set Balance=Balance-"+wmoney+" where Account_num="+accnum;
                ob.updateQ(sql);
                //for storing txn history
                String txnQ ="insert into transactions (account_no, type, amount) values("+accnum+",'withdrawal',"+wmoney+")";
                ob.updateQ(txnQ);
                System.out.print("Data updated.");
            }
        } catch (Exception e) {
            System.out.println("Ëxception: "+e);
        }        
    }

    public void transfer(int accnum,int Bal){
        try {
            System.out.print("Enter the reciever's account number: ");
            int rec_acc = scn.nextInt();
            dbOperation ob = new dbOperation();
            String qu= "select * from Accounts where Account_num="+rec_acc;
            ResultSet rs= ob.fetchQ(qu);
            if (rs.next()) { 
                System.out.print("Enter amount to transafer: ");
                int amt = scn.nextInt();
                if(Bal >= amt){
                    String query ="update Accounts set Balance=Balance-"+amt+" where Account_num="+accnum;
                    String nquery ="update Accounts set Balance=Balance+"+amt+" where Account_num="+rec_acc;
                    ob.updateQ(query);
                    ob.updateQ(nquery);                 
                    //for storing txn history
                    String txnQ ="insert into transactions (account_no, type, amount) values("+accnum+",'withdrawal',"+amt+")";
                    String txn1Q ="insert into transactions (account_no, type, amount) values("+rec_acc+",'Deposit',"+amt+")";
                    ob.updateQ(txnQ);
                    ob.updateQ(txn1Q);

                    System.out.print("Transaction successfully transfered.");
                }
                else{
                    System.out.println("Insufficient transferable funds.");
                }                
            }
            else{
                System.out.println("Reciever's account number is incorrect.");
            }
        } catch (Exception e) {
            System.out.println("Ëxception: "+e);
        }
    }

    public void show_history(int accnum,int bal){
        try {
            //showing transaction history and holder name
            dbOperation ob = new dbOperation();
            System.out.println("----------------------Account Hisstory-----------------------");
            String fetch="select * from accounts where account_num="+accnum;
            ResultSet rs=ob.fetchQ(fetch);
            rs.next();
            System.out.println("Account number: "+accnum);
            System.out.println("Äccount Holder Name: "+rs.getString(2));

            System.out.println("-----------------------------------------------------------------");
            System.out.println("   Sr.no \t Type\t\t Amount \t Transaction Date ");
            System.out.println("-----------------------------------------------------------------");

            String fq="select * from transactions where account_no="+accnum;
            ResultSet frs=ob.fetchQ(fq);
                        int a=0;
            while(frs.next()){    
                ++a;            
                System.out.println("\t"+a+"\t" + frs.getString(3)+"\t\t"+frs.getInt(4)+"\t"+frs.getString(5));
            }
            System.out.println("-----------------------------------------------------------------");


            //sum of deposits
            String dData ="select sum(amount) from transactions where account_no="+accnum+" and type='Deposit'";              
            ResultSet drs = ob.fetchQ(dData);
            if(drs.next()){
                int d_money= drs.getInt(1);
                System.out.println("Total Recieved money: "+d_money);
            }

            //su of withdrawal
            String wData ="select sum(amount) from transactions where account_no="+accnum+" and type='withdrawal'";
            ResultSet rs1 = ob.fetchQ(wData);          
            if(rs1.next()){
                int w_money= rs1.getInt(1);
                System.out.println("Total withdrawal money: "+w_money);
            }
            
            System.out.println("Current Balance: "+bal);
            System.out.println("---------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }
    }
}