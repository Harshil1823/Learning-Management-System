import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);
    private static LMS facade;
    private static User user;

    public static void main(String[] args) {
        facade = new LMS();
        welcomeScreen();
    }

    public static void welcomeScreen() {
        while (true) {
            System.out.println("Welcome to our LMS!");
            System.out.println("Press 1, to log in as a user.");
            System.out.println("Press 2, to log in as an author.");
            System.out.println("Press 3, to register as an user.");
            System.out.println("Press 4, to register as a author.");
            System.out.println("Press 0, to exit.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user = facade.Login();
                    displayUserMenu(user);
                    break;
                case 2:
                    user = facade.LoginAuthor();
                    displayAuthorMenu(user);
                    break;
                case 3:
                    user = facade.registerUser();
                    displayUserMenu(user);
                    break;
                case 4:
                    user = facade.registerAuthor();
                    displayAuthorMenu(user);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void displayAuthorMenu(User user) {
        while (true) {
            System.out.println("Author Home Screen");
            System.out.println("Press 1, to view all courses available.");
            System.out.println("Press 2, to view courses.");
            System.out.println("Press 3, to create a course.");
            System.out.println("Press 4, to edit a course.");
            System.out.println("Press 5, to search for a course.");
            System.out.println("Press 6, to leave a comment on a course.");
            System.out.println("Press 7, to leave a review on a course.");
            System.out.println("Press 8, to logout.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    welcomeScreen();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void displayUserMenu(User user) {
        System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
        while (true) {
            System.out.println("User Home Screen");
            System.out.println("Press 1, to view all courses available.");
            System.out.println("Press 2, to view taken courses.");
            System.out.println("Press 3, to search for a course.");
            System.out.println("Press 4, to leave a comment on a course.");
            System.out.println("Press 5, to leave a review on a course.");
            System.out.println("Press 6, to logout.");
            System.out.println("Press 0, to return to main menu.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
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
        System.out.println("Please select the following option:");
        System.out.println("Press 1, View courses that are available");
        System.out.println("Press 2, to go to the home screen");
        System.out.println("Press 3, to go to course selection and enroll in a course");
        System.out.println("Press 4, to logout.");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                facade.displayCourses();
                break;
            case 2:
                // IDK this might cause issues
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

    public static void courseSelection() {
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

}