import java.util.ArrayList;
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
                    user = facade.Login();
                    // passing in the logged in user
                    displayHomeScreen(user);
                    break;
                case 2:
                    user = facade.LoginAuthor();
                    break;
                case 3:
                //sets user to a registered author
                    user = facade.registerAuthor();
                    break;
                case 4:
                //sets user to a registered user.
                    user = facade.registerUser();
                    break;
                case 5:
                //displays all courses
                    facade.displayCourses();
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
                    facade.displayCourses();
                    break;
                case 2:
                    // LMS.createCourse();
                    break;
                case 3:
                    // LMS.editCourse();
                    break;
                case 4:
                    facade.deleteCourse();
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

    public static void viewCourseDetails() {

        CourseList courseList = new CourseList();
        System.out.println("\nWhich course would you like to view details about? Please enter the corresponding number to the course: (Enter 0 to go back to the main menu)");
        int selectedCourseIndex = scanner.nextInt();
        scanner.nextLine();
        if (selectedCourseIndex == 0) {
            return;
        }

        // Adjusting index to fit ArrayList
        selectedCourseIndex--;
        //returns the course User chose in courseList and we store that as a course object
        Course courses = courseList.getCourse(selectedCourseIndex);

        
        System.out.println("View Course details:");
        System.out.println(courses.getTitle());
        System.out.println(courses.getDescription());

        ArrayList<Review> reviews = courses.getReviews();
        if (!reviews.isEmpty()) {
            for (Review review : reviews) {
                System.out.println(review);
            }
        } else {
            System.out.println("No reviews yet.");
        }
        ArrayList<Comment> comments = courses.getCourseComments();
        if (!comments.isEmpty()) {
            System.out.println("Comments:");
            for (Comment comment : comments) {
                System.out.println(comment.getText());
            }
        }
        boolean validInput = false;
        while(!validInput) {
            System.out.println("\nEnter any interger to go back to the main menu.");
            int input = scanner.nextInt();
            if(input >= 0){
                displayMainMenu();
                validInput = true;
            } else if (input <= 0){
                displayMainMenu();
                validInput = true;
            } else {
                System.out.println("not a valid Input!");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("Please select the following option:");
        System.out.println("Press 1, View courses that are available");
        System.out.println("Press 2, to go to the home screen");
        System.out.println("Press 3, to go to course selection and enroll in a course");
        System.out.println("Press 4, to logout.");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option){
            case 1:
                //TODO courses that are avialable and there details
                facade.displayCourses();
                viewCourseDetails();
                break;
            case 2:
                //IDK this might cause issues
                // we will check during testing
                displayHomeScreen(user);
                break;
            case 3:
                courseSelection();                
                break;
            case 4:
                user = null;
                System.out.println("You have successfully logged out.");
                welcomeScreen();
                break;
        }
    }

    public static void courseSelection(){
        facade.displayCourses();
        System.out.println("Enter the name of the course you would like to enroll in.");
        String courseTitle = scanner.nextLine();

        if (facade.enrollInCourse(user, courseTitle)) {
            // If successful, display message to user
            System.out.println("Successfully enrolled in " + courseTitle);
        } else {
            // If unsuccessful, display message to user
            System.out.println("Could not enroll in " + courseTitle);
        }
    }

    public static void main(String[] args) {
        welcomeScreen();
    }
    
} // end of class


//Adding the code here. We can organize after we have everything
//createAuthorCourse
/*static void createCourse() {
        System.out.println("Create a new course screen:");
        System.out.print("Enter the course title: ");
        String courseTitle = scanner.nextLine();
        System.out.print("Enter the course description: ");
        String courseDescription = scanner.nextLine();


        System.out.println("\nCourse created successfully!");
        System.out.println("\nGo to main menu and press 3, to select the course you created. So, you can add module and topics within your course.");
        System.out.println("To return to main menu press 0.");
    }
}
 */

 //selectCourse

 /*
  * static void selectCourse() {
        System.out.println("Select a course Screen:");

        // Display the list of courses the author has created (you should implement the logic for this)

        System.out.println("\nPress 1, create a new module");
        System.out.println("Press 2, to view all modules");
        System.out.println("Press 3, select a module");
        System.out.println("Press 0, to return to main menu");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Implement creating a new module
                    break;
                case 2:
                    // Implement viewing all modules
                    break;
                case 3:
                    // Implement selecting a module
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 0);
    }
}
  */

