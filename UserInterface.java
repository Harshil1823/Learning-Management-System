import java.util.Scanner;

public class UserInterface {
    
    private static Scanner scanner = new Scanner(System.in);
    private static LMS facade;

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

public static void displayAuthorMenu() {
    int choice;

    do {
        System.out.println("Author Menu");
        System.out.println("1. View Courses");
        System.out.println("2. Create Course");
        System.out.println("3. Edit Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // facade.viewCourses();
                break;
            case 2:
                // facade.createCourse();
                break;
            case 3:
                // facade.editCourse();
                break;
            case 4:
                // facade.deleteCourse();
                break;
            case 5:
                // facade.logout();
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    } while (choice != 5);
}

    public static void main(String[] args) {
        welcomeScreen();
    }
    
} // end of class
