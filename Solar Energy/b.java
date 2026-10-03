import java.util.Scanner;
public class b{
    public static void main(String[] args){

      Scanner sc = new Scanner(System.in);

      System.out.printf("Enter energy : ");
      double energy = sc.nextDouble();
      System.out.println("Energy Generated : "+energy+"kWh");
      
      if(energy>=10){
        System.out.println("Good Energy Generation");
      }
      else{
        System.out.println("Low Energy Generation");
      }
      sc.close();
    }
}
