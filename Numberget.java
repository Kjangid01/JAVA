import java.util.*;

class Number 
{
    int num;
    public void readnum()
    {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the value of num : ");
        num = scn.nextInt();
    }
    public void shownum()
    {
        System.out.println("Number : " + num);
    }       
}
class Numberget
{
    public static void main(String []arg)
    {
        Number ob=new Number();
        ob.readnum();
        ob.shownum();    
    }
}
