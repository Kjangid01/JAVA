import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;


public class crud {

     public static void print_table(Statement stmt){
            try{
                    String printq = "select * from employees";
                    ResultSet rs = stmt.executeQuery(printq);                   
                    
                    System.out.println("+-------+--------------+----------+");
                    System.out.println("EmpId\t|Name\t\t|Salary\t");
                    System.out.println("+-------+--------------+----------+");
                    while(rs.next()){
                        System.out.println(rs.getInt(1)+"\t|"+rs.getString(2)+" \t|"+rs.getInt(3));
                    }
                    System.out.println("+-------+--------------+----------+");
        	} catch(Exception e){
                System.out.print(e);

            }
        }

    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/volyo";
        String user= "root";
        String password = "mysql123";

        

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("connected Successfully...");
            Statement stmt = con.createStatement();
            Scanner scn = new Scanner(System.in);

            

            // while(true){
                System.out.println("-----------------------------------------------");
                System.out.println(" 1 : Insert new employee Data in table Enployees.");
                System.out.println(" 2 : Read/Print Data of Employees.");
                System.out.println(" 3 : Update a Data of Employees.");
                System.out.println(" 4 : Delete a Data from Employees.");
                System.out.println(" 5 : Exit..");
                System.out.println("-----------------------------------------------");
                System.out.print("Enter your choice (1-5): ");

                int ch=scn.nextInt();
                switch (ch){
                    //for inserting data
                    case 1: System.out.println("-----------------------------------------------");
                            System.out.println("how much data do you want to insert? ");
                            int n= scn.nextInt();
                            for(int i=1;i<=n;i++){
                                int id;
                                while (true) {  // Loop to validate unique ID
                                    System.out.print("Enter Employee ID: ");
                                    id=scn.nextInt();
                                    String check = "select *from employees where EmpId="+id;
                                    ResultSet rsall = stmt.executeQuery(check);
                                    if(rsall.next()){
                                        System.out.println("EmplID already exist. Please enter a new Id.");
                                    } else {
                                            break; // Exit loop when unique ID is found
                                        }
                                }
                                System.out.print("Enter Employee Name: ");
                                String name=scn.next();
                                
                                System.out.print("Enter Employee Salary: ");
                                int sal=scn.nextInt();

                                String insertq = "insert into employees values("+id+", '"+ name +"',"+ sal +")";

                                stmt.executeUpdate(insertq);
                                System.out.println("Data inserted Successfully...");
                            }
                            
                            break;

                    //for print table data
                    case 2: print_table(stmt);
                            break;

                    //for updating data
                    case 3: print_table(stmt);
                            System.out.print("Select Employees Id to updat data: ");
                            int up=scn.nextInt();
                            System.out.println("What do you want to upadate:");
                            System.out.println("a: Employee Name. ");
                            System.out.println("b: Employee Salary. ");
                            System.out.print("Enter choice (a/b): ");
                            String a=scn.next();

                            //for updating name
                            if(a.equals("a")){
                                System.out.print("Enter new name to update :");
                                String newname = scn.next();                                
                                stmt.executeUpdate("update employees set Name='"+newname+"' where EmpId="+up);
                                System.out.print("Data Updated Successfully..");
                            }
                            //for updating salary
                            else if(a.equals("b")){
                                System.out.print("Enter new salary to update :");
                                int newsal = scn.nextInt();                                
                                stmt.executeUpdate("update employees set Salary="+newsal+" where EmpId="+up);
                                System.out.print("Data Updated Successfully..");
                            }
                            break;

                    //for delete data or table
                    case 4: print_table(stmt);

                            //fordelete
                            System.out.print("Select the id to delete data:");
                            int del=scn.nextInt();
                            stmt.executeUpdate("delete from employees where EmpId="+del);
                            System.out.println("Data deleted Successfully..");
                            System.out.println("-----------------------------------------------");
                            System.out.println(" ");
                            //}
                            break;

                    case 5: System.out.println("Exit....");
                            con.close();
                            scn.close();                    
                            break;
                    
                    default: System.out.print("Invalid Choice..");
                            
                }
                System.out.println("-----------------------------------------------");

                
            //} 

            
        } 
        catch(Exception e){
            System.out.println(e);
        }

    }
    
}
