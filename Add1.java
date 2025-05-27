import java.util.*;
class Add1
{
	
    public static void main(String[ ] args)
    { 
	int sum,a,b;
        Scanner scn=new Scanner(System.in);

        System.out.print("enter the value:");
        a=scn.nextInt();

        System.out.print("enter the value:");
        b=scn.nextInt();
        
	sum=a+b;
        
        
        System.out.print("Sum of Digit:"+sum);
    }
}