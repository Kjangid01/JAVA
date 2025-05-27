import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.*;


import java.sql.*;

public class Database extends JFrame {
    
    JFrame f1;
    JTable t1;
    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/volyo","root","mysql123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees");

            String col[] = {"EmpID","Name","Salary"};
            Object [][] data = new Object[6][3];
            
            int i=0;
            while(rs.next()){
                data[i][0]=rs.getInt(1);
                data[i][1]=rs.getString(2);
                data[i][2]=rs.getInt(3);
                i++;
            }

            Container c=getContentPane();
            t1=new JTable(data,col);

            t1.setCellSelectionEnabled(true);
            ListSelectionModel sel = t1.getSelectionModel();
            sel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            sel.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e){
                    String sel=null;

                    int row[]=t1.getSelectedRows();
                    int colm[]=t1.getSelectedColumns();

                    for(int i=0;i<row.length;i++){
                        for(int j=0;j<colm.length;j++){
                            // sel=(String)t1.getValueAt(row[i], colm[j]);
                            Object value = t1.getValueAt(row[i], colm[j]);
                            sel = value.toString();
                            // System.out.println(t1.getValueAt(row[i], colm[j]).toString());
                        }
                    }
                    System.out.println(sel);
                }
            }); 

            c.add(new JScrollPane(t1));
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String []args){
        Database db1 = new Database();
        db1.setSize(300, 200);
        db1.setVisible(true);
    }
}
