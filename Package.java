import java.util.*;
//import java.util.Scanner;

class Package 
{
    public static void main(String args[])
    {
        String s=new String();
       
        System.out.print("Enter the string:");

        Scanner scn=new Scanner(System.in);

        s=scn.nextLine();

        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }
    }
}

