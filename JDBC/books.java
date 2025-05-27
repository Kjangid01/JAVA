import java.util.*;
import java.sql.*;
import java.time.LocalDate;


public class books {

    public static void main(String args[]){

        String url = "jdbc:mysql://localhost:3306/volyo";
        String user= "root";
        String password = "mysql123";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully.");
            Statement stmt = con.createStatement();
            
            Scanner scn=new Scanner(System.in);

            System.out.println("------Book Issue------");
            System.out.print("Enter Book Id: ");
            int bid=scn.nextInt();
            System.out.println("-----------------");
            ResultSet rs=stmt.executeQuery("select * from books where bookId="+bid);
            while(rs.next()){
                String name = rs.getString("bookName");
                String aname = rs.getString("authorName");
                String publisher = rs.getString("publisher");
                int page =rs.getInt("pages");
                String edition = rs.getString("edition");

                System.out.println("Book Name: "+name);
                System.out.println("Author Name: "+aname);
                System.out.println("Publisher: "+publisher);
                System.out.println("Pages in book: "+page);
                System.out.println("Edition of book: "+edition);
            }

            LocalDate curDate=LocalDate.now();
            LocalDate newDate=curDate.plusDays(10);
            System.out.println("Issue Date: "+curDate);
            System.out.println("Return date of issued book : "+newDate);

            System.out.print("Enter MemberId to save record : ");
            int mid = scn.nextInt();

            // System.out.println("Do u want to save record fsue book");
            stmt.executeUpdate("insert into transaction values("+bid+","+mid+",'"+curDate+"','"+newDate+"')");
            System.out.println("Data inserted successfully...");


            


        } catch (Exception e) {
            
            System.out.println(e);
        }
    }
    
}
