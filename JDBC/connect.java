import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    public static void main(String[] args) {
        // String url = ;
        // String username = ;
        // String password = ;

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","volyo@123");
            System.out.println("Connection successful!");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}