import java.util.List;
import java.util.Scanner;

public class UserInterface {
    
    private static Scanner scanner = new Scanner(System.in);
    private static LMS facade = new LMS();
    private static User user;
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
            scanner.nextLine();

            switch(choice){
                case 1:
                    user = LMS.Login();
                    // passing in the logged in user
                    displayHomeScreen(user);
                    break;
                case 2:
                    user = LMS.LoginAuthor();
                    break;
                case 3:
                //sets user to a registered author
                    user = LMS.registerAuthor();
                    break;
                case 4:
                //sets user to a registered user.
                    user = LMS.registerUser();
                    break;
                case 5:
                //displays all courses
                    LMS.displayCourses();
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
                    LMS.displayCourses();
                    break;
                case 2:
                    // LMS.createCourse();
                    break;
                case 3:
                    // LMS.editCourse();
                    break;
                case 4:
                    LMS.deleteCourse();
                    break;
                case 5:
                    user = null;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);
    }

    //I did all this in facade.
    /* 
    public static User loginUser() {
        System.out.println("Please enter your username to log in: ");
        String userName = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        LMS userFacade = new LMS();

        // Call checkLoginUser method in facade that checks 
        // if the user is in the database and can login
        boolean isLoggedIn = userFacade.checkLoginUser(userName, password);

        if (isLoggedIn) {
            System.out.println("You have successfully logged in!");
            User user = userFacade.getUserByUsername(userName);
            return user;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }

        //TODO call checkLoginUser method in facade that checks if 
        // the user is in the database that can login
        // and if they are not in the database then don't
        // log them in
        return null;
                  
    }

    private static void loginAuthor() {
        System.out.println("Please enter your username to log in: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // TODO call checkLoginAuthor method in facade that checks if 
        // the author is in the database that can login
        // and if they are not in the database then don't
        // log them in
    }

    public static void RegistrationScreenUser() {
        
        System.out.println("Please enter the provided information below to register as User.");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Email Address: ");
        String email = scanner.nextLine();
        
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // TODO: Add method to create new user with the provided information.
        // You can call a method from your facade class to handle this task.
    }

    public static void RegistrationScreenAuthor() {

        System.out.println("Please enter the provided information below to register as a Author.");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Email Address: ");
        String email = scanner.nextLine();
        
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // TODO: Add method to create new author with the provided information.
        // You can call a method from your facde class to handle this task.
        // Remember to set the isAuthor flag to true for the new author.
    }
    */
    public static void displayHomeScreen(User user) {
        System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() +"!");
        System.out.println();
        System.out.println("You are currently enrolled in the following courses:");
        List<Course> courses = user.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("[" + (i+1) + "] " + courses.get(i).getTitle());
        }
        System.out.println("[0] Back to main menu");
        System.out.println("Enter the number of the course you wish to view:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 0) {
            displayMainMenu();
        } else if (choice > 0 && choice <= courses.size()) {
            //course list starts at 0
            //so if user enter 2, in course list it's 1. so choice - 1
            Course selectedCourse = courses.get(choice - 1);
            displayCourse(selectedCourse);
        } else {
            System.out.println("Invalid choice. Please try again.");
            displayHomeScreen(user);
        }
    }
    
    /*
     * From here the user will be going to course that they are already enrolled
     * in
     * and finish the current course
     */
    private static void displayCourse(Course selectedCourse) {
    }

    
    private static void displayMainMenu() {
    }


    public static void main(String[] args) {
        welcomeScreen();
    }
    
} // end of class
