import java.util.Scanner;

public class UserInterface {
    
    private Scanner scanner;
    private LMS facade;

    public UserInterface(){
        scanner = new Scanner(System.in);
        facade = new LMS();
    }

    public void displayMainMenu() {
        int choice;
        do {
            System.out.println("Welcome to our LMS!");
            System.out.println("1. Log in as a user");
            System.out.println("2. Log in as an author");
            System.out.println("3. Register as an author");
            System.out.println("4. Register as a user");
            System.out.println("5. View all courses available");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                facade.Login();
                break;

                case 2:
                facade.Logout();
                System.out.println("Goodbye!");
                break;

                case 3:
                //author and user or create another case for author
                
                facade.newUser();
                break;

                case 4:
                facade.StartCourse();
                break;

                case 5:
                facade.mainMenu();
                break;

                case 6:
                facade.continueCourse();
                break;

                case 7:
                facade.createCourse();
                break;

                case 8:
                facade.DeleteCourse();
                break;

                default:
                System.out.println("Invalid choice. Please try again.");

            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.displayMainMenu();

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
                facade.viewCourses();
                break;
            case 2:
                facade.createCourse();
                break;
            case 3:
                facade.editCourse();
                break;
            case 4:
                facade.deleteCourse();
                break;
            case 5:
                facade.logout();
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    } while (choice != 5);
}
}
