import java.util.*;


public class profit_loss {
    public static void main(String []arg){
            
            int sprice, cprice,profit, loss; 
            Scanner scn= new Scanner(System.in);
            
            System.out.print("Enter the cost price: ");
            cprice = scn.nextInt();

            System.out.print("Enter the selling price: ");
            sprice= scn.nextInt();
        
            if (cprice<sprice ){
                profit=sprice-cprice;
                System.out.print("Earned profit of= "+ profit);
            }
            else if (cprice>sprice){
                loss=cprice-sprice;
                System.out.print("Have loss of= "+ loss);
            }
            else{
                System.out.print("No profit and no loss.");
                }
            
        }

    }
    

