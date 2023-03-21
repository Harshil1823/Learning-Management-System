import java.util.Scanner;

public class UserInterface {
    
    private static Scanner scanner = new Scanner(System.in);
    private LMS facade;

    public UserInterface(){
        scanner = new Scanner(System.in);
        facade = new LMS();
    }
    /**
     * This is a welcomeScreen that will printed when user first views our system
     */
    public static void welcomeScreen() {
        int choice = 0;
        while(choice < 1 || choice > 5){
            System.out.println("Welcome to our LMS!");
            System.out.println("Press 1, to log in as a user.");
            System.out.println("Press 2, to log in as an author.");
            System.out.println("Press 3, to register as an author.");
            System.out.println("Press 4, to register as a user.");
            System.out.println("Press 5, to view all courses available.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    //TODO call login as a user method in facade
                    break;
                case 2:
                    //TODO call login as a author
                    break;
                case 3:
                    //TODO call register as an author
                    break;
                case 4:
                    //TODO call register as a user
                    break;
                case 5:
                    //TODO view all courses avaiable
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    System.out.println("\nEnter a valid choice \n");
                    break;
            }
        }
    }








    public static void main (String [] args) {
        welcomeScreen();
    }
}

