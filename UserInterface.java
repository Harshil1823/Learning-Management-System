import java.util.ArrayList;
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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void displayAuthorMenu(User user) {
        while (true) {
            System.out.println("Author Home Screen");
            System.out.println("Press 1, to view all enrolled courses.");
            System.out.println("Press 2, to view all available courses.");
            System.out.println("Press 3, to create a course.");
            System.out.println("Press 4, to edit a course.");
            System.out.println("Press 5, to enroll in course");
            System.out.println("Press 6, to leave a comment on a course.");
            System.out.println("Press 7, to leave a review on a course.");
            System.out.println("Press 8, to logout.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    facade.displayEnrolledCourses(user);
                    break;
                case 2:
                    facade.displayCourses();
                    break;
                case 3:
                    facade.createCourse(user);
                    break;
                case 4:
                    facade.editCourse();
                    break;
                case 5:
                    // facade.searchCourse();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    user = null;
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
            System.out.println("Press 2, to view enrolled courses.");
            System.out.println("Press 3, to search for a course.");
            System.out.println("Press 3, to enroll in a course.");
            System.out.println("Press 4, to leave a comment on a course.");
            System.out.println("Press 5, to leave a review on a course.");
            System.out.println("Press 6, to logout.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    facade.displayCourses();
                    break;
                case 2:
                    facade.displayEnrolledCourses(user);
                    break;
                case 3:
                    facade.enrollInCourse(user);
                    break;
                case 4:
                    facade.courseComment(user);
                    break;
                case 5:
                    facade.courseReview(user);
                    break;
                case 6:
                    user = null;
                    welcomeScreen();
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

    /*
     * private static void displayMainMenu() {
     * System.out.println("Please select the following option:");
     * System.out.println("Press 1, View courses that are available");
     * System.out.println("Press 2, to go to the home screen");
     * System.out.
     * println("Press 3, to go to course selection and enroll in a course");
     * System.out.println("Press 4, to logout.");
     * 
     * int option = scanner.nextInt();
     * scanner.nextLine();
     * 
     * switch (option) {
     * case 1:
     * facade.displayCourses();
     * viewCourseDetails();
     * break;
     * case 2:
     * // IDK this might cause issues
     * // we will check during testing
     * //Might need to call DISPLAYUserMENU
     * //or DisplayHomeScreen
     * displayHomeScreen(user);
     * break;
     * case 3:
     * courseSelection();
     * break;
     * case 4:
     * user = null;
     * System.out.println("You have successfully logged out.");
     * welcomeScreen();
     * break;
     * }
     * }
     */

    public static void viewCourseDetails() {

        CourseList courseList = new CourseList();
        System.out.println(
                "\nWhich course would you like to view details about? Please enter the corresponding number to the course: (Enter 0 to go back to the main menu)");
        int selectedCourseIndex = scanner.nextInt();
        scanner.nextLine();
        if (selectedCourseIndex == 0) {
            return;
        }

        // Adjusting index to fit ArrayList
        selectedCourseIndex--;
        // returns the course User chose in courseList and we store that as a course
        // object
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
        while (!validInput) {
            System.out.println("\nEnter any interger to go back to the main menu.");
            int input = scanner.nextInt();
            if (input >= 0) {
                // displayMainMenu();
                validInput = true;
            } else if (input <= 0) {
                // displayMainMenu();
                validInput = true;
            } else {
                System.out.println("not a valid Input!");
            }
        }
    }

}
