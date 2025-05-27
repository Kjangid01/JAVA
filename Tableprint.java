import java.util.*;

class Tableprint{
     
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number for it's table: ");
        int a= sc.nextInt();
        int i;
        for(i=1;i<=10;i++){
            System.out.println(a+"*"+i+"="+a*i);
        }
    }
}   