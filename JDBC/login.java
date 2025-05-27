import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class login {
    public static void main(String args[]){

        String url="jdbc:mysql://localhost:3306/volyo";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,"root", "mysql123");
            System.out.println("Connected Successfully.");
            Statement stmt = con.createStatement();
            Scanner scn = new Scanner(System.in);

            // String q = "Create table login(username varchar(30) primary key, password int, email varchar(80) unique key)";
            // stmt.executeUpdate(q);
            // System.out.println("login table created..");

            System.out.println("----------------------------------");
            System.out.println("-\tRegistration\t-");
            System.out.println("----------------------------------");

            String user, mail, pass, cpass;
            
            while (true){
                System.out.print("Enter username :");
                user = scn.next();

                String userc = "select *from login where username='"+user+"'";
                ResultSet rs = stmt. executeQuery(userc);
                if(rs.next()){
                    System.out.println("Username already exist.., Eneter new Usernme.");
                }
                else { 
                    break;
                }
            }

            while(true){
            System.out.print("Enter Password: ");
            pass= scn.next();
            System.out.print("Confirm Password: ");
            cpass= scn.next();            
                if(cpass.equals(pass)){
                    break;
                }
                 else {
                  System.out.println("Confirm password & Passowrd shoulb be same. Enter same password...");
                 }
                
                
            }
            
            while(true){
            System.out.print("Enter emailId: ");
            mail=scn.next();
            String mailq = "select *from login where email='"+mail+"'";
            ResultSet rs2 = stmt. executeQuery(mailq);            
                if(rs2.next()){
                    System.out.println("Email already exist..,Enter new email");
                } else{
                    break;
                }
            }
            
            String insertq = "insert into login values('"+user+"', '"+pass+"', '"+mail+"')";
            stmt. executeUpdate(insertq);
            System.out.println("Login successfully..");              

            con.close();
                
        } catch(Exception e) {
            System.out.println("Exception "+e);
        }    
    }    
}