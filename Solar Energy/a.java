import java.util.Scanner;
public class a{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

         System.out.printf("Enter ID : ");
         int ID = sc.nextInt();

         System.out.printf("Enter energy : ");
         double energy = sc.nextDouble();

         System.out.printf("Enter panels : ");
         int panels = sc.nextInt();
         
         System.out.printf("Enter status : ");
         char status = sc.next().charAt(0);

         System.out.println("Panel ID : "+ID);
         System.out.println("Energy generated : "+energy+"kWh");
         System.out.println("Number of solar panels : "+panels);
         System.out.println("System status : "+status);

         sc.close();
    }
    
}
