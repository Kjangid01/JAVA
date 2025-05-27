import java.util.*;


public class sec_max {
    
    public static void find_max(int num1,int num2,int num3) {
        int max, smax;
        if(num1>num2) {
            max=num1;
            smax=num2; }
        else {
            max=num2;
            smax=num1;  }


        if (num3>max){
            max=num3;
            smax=max; }

        else 
            if(num3>smax){
                
                smax=num3;
            }
        System.out.print("Second max is :"+smax);
        }

    

    public static void main(String []args){
        
        int a, b, c;
        Scanner scn= new Scanner(System.in);

        System.out.print("Enter num1: ");
        a = scn.nextInt();

        System.out.print("enter num2: ");
        b = scn.nextInt();

        System.out.print("enter num3: ");
        c = scn.nextInt();
        
        
        find_max(a, b, c);


    }
    
}
