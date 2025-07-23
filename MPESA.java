import java.util.Scanner;
public class MPESA{
    public static String nameOfUser = "";
    public static String phoneNumber = "";
    public static int pin = 0;
    public static double balance = 0.0;
    public static boolean isLogedIn = false;
    public static Scanner input = new Scanner(System.in);
    
    public void registrationMethod(){
    }

    public static void mainMenu(){
        while(true){
            System.out.println("=========MPESA APP =====");
            System.out.println("Choose one of the option below");
            System.out.println("1.Register");
            System.out.println("2.exit");

            int choice = input.nextInt();
            // switch statement to allow the user to choose option:
            switch(choice){
                case 1:
                     userRegistration();
                     break;
                case 2:
                     System.out.println("Thank you for visiting us , next time yo");
                     return;
                default:
                     System.out.println("Invalid option please Enter a correct number");      
            }
        }
    }
    
    // the method for user registration
    public static void userRegistration(){
            System.out.println("Register here make sure all cresidential are alright");
            input.nextLine(); // consume newline
            
            System.out.println("Enter your full name here");
            nameOfUser = input.nextLine();

            System.out.println("Enter a phone number");
            phoneNumber = input.next();

            int password1, password2;
            do{
                   System.out.println("set your pin of four digit");
                   password1 = input.nextInt();

                   System.out.println(" confrm password");
                   password2 = input.nextInt();

                   if(password1 != password2){
                    System.out.println("invalid pin");
                   }
            }
            while(password1 != password2);
            
            pin = password1;
            System.out.println("Successfully registered, you can now log in");
            logInUser();
    }

    // method of log in after registration
    public static void logInUser(){
         System.out.println("=====LOG IN=====");
         int passKey;
          while(true){
          System.out.println("Enter a Pin");
          passKey = input.nextInt();

          if(passKey == pin){
            isLogedIn = true;
            displayMenu();
            return;
          }
          else{
             System.out.println("invalid pin");
          }
         }
    }
    
    // when already log in
    public static void displayMenu(){
        while(isLogedIn){
        System.out.println("====WELCOME TO MPESA APP BRO====");
        System.out.println("choose 1 deposit money");
        System.out.println("choose 2 for withdraw");
        System.out.println("choose 3 to check balance");
        System.out.println("choose 4 if you need to logout");

        int choice = input.nextInt();
        switch(choice){
            case 1:
             depositMoney();
             break;
            case 2:
             withdrawMoney();
             break;
            case 3:
             checkBalance();
             break;
            case 4:
             logout();
             break;
        }
        }
    }
    
    // deposit method for user to deposit money
    public static void depositMoney(){
         System.out.println("Enter the amount you need to deposit");
         double amount = input.nextDouble();
         depositMoney(amount);
    }
    
    // overloading the method of depositMoney()
    public static void depositMoney(double amount){
         balance += amount;
         System.out.println("Your new Balance is " + balance);
    }
    
    // method for withdrawing money
    public static void withdrawMoney(){
        System.out.println("Enter amount you need to withdraw");
        double amount = input.nextDouble();

        if(amount > balance){
            System.out.println("Low capital");
        }
        else{
            balance = balance - amount;
            System.out.println("After withdraw " + amount + " new balance is " + balance);
        }
    }
    
    // methods for checking balance
    public static void checkBalance(){
        System.out.println("your new balance is " + balance);
    }
    
    // method for log out
    public static void logout(){
        isLogedIn = false;
        System.out.println("Thank you for logging out");
    }
                
    public static void main(String [] args){
        mainMenu();
    }
}