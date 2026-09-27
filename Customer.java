import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Customer {
    private String name;
    private long mobileNum;
    private String pin;
    private String accountNum;
    private double balance=0;

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    //BUFFERING ADD KARNE KE LIYE METHOD
    public void delay()
    { try{
        System.out.print(ConsoleColors.YELLOW+ "Loading"  +ConsoleColors.RESET);
        for(int i=3;i>0;i--)
        {
            Thread.sleep(600);
            System.out.print(ConsoleColors.YELLOW+ "." +ConsoleColors.RESET);
        }
        System.out.println("");
        }catch(InterruptedException e)
        {
            System.out.println("");
        }
    }

    //CUSTOMER REGISTRATION KE LIYE METHOD
    public void displayCustomerRegistration()throws IOException
    { 
        System.out.println("--------------------------------------------------" +"\n" + "               CUSTOMER REGISTRATION                " + "\n" + "--------------------------------------------------");
        System.out.println("");

        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        

        System.out.print("Enter Customer Name: ");
        name=br.readLine();
        System.out.print("Enter Mobile no.: ");
        mobileNum=Long.parseLong(br.readLine());
       

    }
    
    //CUSTOMER KA LOGIN PANEL
    public void displayCustomerLoginPanel()throws IOException ,InterruptedException
    {
        System.out.println("--------------------------------------------------" +"\n" + "               CUSTOMER LOGIN  PANEL                " + "\n" + "--------------------------------------------------");
        System.out.println("");

        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        
        while(true)
        {
            System.out.println("Enter 12-digit A/c Number: ");
            accountNum=br.readLine();
            System.out.println("");
            if(accountNum.length()==12)
            {
                break;
            }
            else{
                System.out.println(ConsoleColors.RED+ "Invalid A/c Number! Please Enter Exactly 12-digits" +ConsoleColors.RESET);
            }
        }

        while(true)
        {
            System.out.println("Enter 4-digit PIN: ");
            pin=br.readLine();
            System.out.println("");
            if(pin.length()==4)
            {
                break;
            }
            else{
                System.out.println(ConsoleColors.RED+ "Invalid PIN! Please Enter Exactly 4-digits" +ConsoleColors.RESET);
            }
        }
        System.out.println(ConsoleColors.GREEN+ "Welcome "+name+"! You have successfully logged in at "+date+" | "+time);
        System.out.println("------------------------------------------------------------------------------------------"+ConsoleColors.RESET); //90
        System.out.println("");
        System.out.print(ConsoleColors.YELLOW+ "LOADING MENU " +ConsoleColors.RESET);
        for(int i=5;i>0;i--)
        {
            Thread.sleep(600);
            System.out.print(ConsoleColors.YELLOW+ " "+i +ConsoleColors.RESET);
        }
        System.out.println("");
        
    }

    //BALANCE CHECK KARNE KE LIYE METHOD 
    private void checkBalance()
        {
            System.out.println(ConsoleColors.BLUE+ "Your current balance is: "+balance+ConsoleColors.RESET);
        }
    
    //MONEY WITHDRAW KARNE KE LIYE METHOD
    protected void withdrawMoney()throws IOException{
            
            System.out.print("Enter amount to withdraw: ");
            double amount=Double.parseDouble(br.readLine());

            if(amount>balance)
            {
                System.out.println(ConsoleColors.RED+ "Insufficient Balance!" +ConsoleColors.RESET);
            }
            else
            { 
                balance=balance-amount;
                System.out.println(ConsoleColors.BLUE+ "Withdrawn Successful!" +ConsoleColors.RESET);
            }

        }
    
    //MONEY DEPOSIT KARNE KE LIYE METHOD
    protected void depositMoney()throws IOException{
            
            
            System.out.print("Enter amount to deposit: ");
            double amount=Double.parseDouble(br.readLine());

            balance=balance+amount;
            System.out.println(ConsoleColors.BLUE+ "Deposit Successful!" +ConsoleColors.RESET);
        }

    //PIN CHANGE KARNE KE LIYE METHOD
    private void changePIN()throws IOException
    {   while(true){
        System.out.print("Enter 4-digit New PIN: ");
        String newPIN=br.readLine();
        
            if(newPIN.length()==4)
            {
                if(newPIN==pin)
                {
                    System.out.println(ConsoleColors.RED+ "New PIN cannot be the same as the old PIN. " +ConsoleColors.RESET);
                }
                else
                {
                    pin=newPIN;
                    System.out.println(ConsoleColors.BLUE+ "PIN changed successfully!" +ConsoleColors.RESET);
                    break;
                }
            }
            else{
                System.out.println(ConsoleColors.RED+ "Invalid PIN! Please Enter Exactly 4-digits" +ConsoleColors.RESET);
            }
            
            
        }


    }
    

    //CUSTOMER MENU SHOW KARNE KE LIYE METHOD
    public void showCustomerMenu()throws IOException, NoSuchElementException{
        
        while(true){
        System.out.println("--------------------------------------------------" +"\n" + "               CUSTOMER MENU                " + "\n" + "--------------------------------------------------"); 
        System.out.println("Hii  Mr. "+name);
        System.out.println("");
        System.out.println("Press 1 :: Check A/c Balance");
        System.out.println("Press 2 :: Cash Withdrawal");
        System.out.println("Press 3 :: Cash Deposit");
        System.out.println("Press 4 :: PIN Change");
        System.out.println("Press 5 :: EXIT !!");
        System.out.println("");

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();
        

        switch (choice) {
                case 1:
                    checkBalance();
                    System.out.println("");
                    System.out.println("");
                    delay();
                    break;
                case 2:
                    withdrawMoney();
                    System.out.println("");
                    System.out.println("");
                    delay();
                    break;
                case 3:
                    depositMoney();
                    System.out.println("");
                    System.out.println("");
                    delay();
                    break;
                case 4:
                    changePIN();
                    System.out.println("");
                    System.out.println("");
                    delay();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println(ConsoleColors.RED+ "-----Thank you for using our ATM. Goodbye!-----" +ConsoleColors.RESET);
                    System.out.println("");
                    System.exit(0);
                    break;
                default:
                    System.out.println(ConsoleColors.RED+ "Invalid choice. Please select 1-5." +ConsoleColors.RESET);
            }
        }

        
        
        
    }
}
