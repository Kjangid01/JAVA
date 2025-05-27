import java.util.*;

public class luckynum{
public static void main(String []arg){
    
    Scanner sc = new Scanner(System.in);
    System.out.print("enter the number: ");
    int num= sc.nextInt();

    /*int len=String.valueOf(a).length(); 
       
    int half, fhalf=0, shalf=0, i ;
    if(len%2!=0){
        System.out.print("Enter a Valid Number");   }
    else{
        half=len/2;
        for(i=0;i<len;i++){

            if(i<half) {
                fhalf = a[i] + fhalf ;
            }
            else(i>half) {
                shalf = shalf + a[i];
            }
            System.out.print("sum of first half :" +fhalf);
            System.out.print("sum of sec half :"+shalf);
            if(fhalf==shalf){
                System.out.print(a+" is lucky number.");  }
            else{
                System.out.print("Not a lucky number.");
            }
        }
    }*/

        String numberAsString = Long.toString(num);
        int length = numberAsString.length();
        
        // Half length of the number
        int halfLength = length / 2;
        
        // Sum of digits in first half with index less than halfLength
        int sumFirstHalf = 0;
        for (int i = 0; i < halfLength; i++) {
            int digit = Character.getNumericValue(numberAsString.charAt(i));
            sumFirstHalf += digit;
        }
        
        // Sum of digits in second half with index less than halfLength
        int sumSecondHalf = 0;
        for (int i = halfLength; i < length; i++) {
            int digit = Character.getNumericValue(numberAsString.charAt(i));
            sumSecondHalf += digit;
        }
        
        // Output results
        System.out.println("Length of the number is: " + length);
        System.out.println("Half length of the number is: " + halfLength);
        System.out.println("Sum of digits in first half: " + sumFirstHalf);
        System.out.println("Sum of digits in second half: " + sumSecondHalf);
        
        scanner.close();
    }
}
}

}