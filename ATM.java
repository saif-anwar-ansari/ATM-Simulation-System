import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class ATM
{   
    public static void main(String[] args)throws IOException ,InterruptedException{
        System.out.println("==================================================" +"\n" + "               WELCOME TO MAKSAD ATM               " + "\n" + "==================================================");
        
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Date: "+date + "          "+"Time: "+time);
        System.out.println("");
        System.out.println("Please select your role to continue: ");
        System.out.println("");
        System.out.println("Press 1 :: Admin Login");
        System.out.println("Press 2 :: Customer Login");
        System.out.println("Press 3 :: EXIT !!");
        System.out.println("");

        Scanner sc=new Scanner(System.in);
        System.out.print("Please Enter Your Choice: ");
        int input=sc.nextInt();

        if(input==1)
        {
            Admin admin=new Admin();
            admin.displayAdminLoginPanel();
            admin.showAdminMenu();
        }
        else if(input==2)
        {
            Customer customer=new Customer();
            // customer.displayCustomerRegistration();
            customer.displayCustomerLoginPanel();
            customer.showCustomerMenu();
        }
        else if(input==3)
        {   System.out.println("");
            System.out.println("--------------------------------------------------" +"\n" + "          THANKS FOR USING MAKSAD ATM                " + "\n" + "--------------------------------------------------");
            System.exit(0);
        }
        else
        {
            System.out.println("Please select appropriate option !!");
        }
       


      sc.close();   
    }
}