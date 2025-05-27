import java.util.Scanner;
import java.sql.*;

class DemoJDBC{
    public static void main(String args[]){

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "volyo@123";
        String database = "my_db";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //for connection creating
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection to the database!");

            //for executing queries
            Statement stmt = con.createStatement();

            // fro creating database
            // String query = "create database "+database;
            // stmt.executeUpdate(query);
            // System.out.println("Database created. ");

            //for showing all databases.
            String showdb = "show databases";
            ResultSet rsdb = stmt.executeQuery(showdb);
            while(rsdb.next()){
                System.out.println(rsdb.getString(1));
            }

            //selecting database from list
            System.out.println();
            System.out.print("Select Databes in above list: ");
            Scanner scn= new Scanner(System.in);
            String db= scn.nextLine();

            //fro selecting database tu be use
            String usedb = "use "+db;
            stmt.executeUpdate(usedb);
            System.out.println(db+" databases Selected.");

            //for showing tables in selected database
            String query1 = "Show tables";
            ResultSet rs = stmt.executeQuery(query1);
            while(rs.next()){
                System.out.println(rs.getString(1));                
            }
            System.out.println();

            //for selecting tables in database
            System.out.print("Select table in above list: ");
            Scanner sc= new Scanner(System.in);
            String tb= sc.nextLine();

            //for printing selected table data
            String selquery = "select* from "+tb;
            ResultSet res = stmt.executeQuery(selquery);
            while(res.next()){
                System.out.print(res.getString(1));
            }

        
            con.close();
        }

        catch(Exception e) {
            System.out.println(e);     
          	
        }
    }
}