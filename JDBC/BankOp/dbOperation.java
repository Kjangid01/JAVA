 //import java.util.*;
import java.sql.*;

public class dbOperation {
    
    String url = "jdbc:mysql://localhost:3306/Bank";
    String user = "root";
    String pass = "mysql123";

    ResultSet fetchQ(String sql){
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //System.out.println("Connected Successfully.");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
            
        } catch (Exception e) {
            System.out.println("Exception : "+e);
        }  
        return null;
    }

    void updateQ(String sql){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            //System.out.println("Connected Successfully.");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println("Exception : "+e);
        }  
    }   
}
