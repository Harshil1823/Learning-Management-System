import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);
    private static LMS facade;
    private static User user;

    public static void main(String[] args) throws InterruptedException {
        facade = new LMS();
        welcomeScreen();
    }

    /**
     * WelcomeSCreen that asks the user for options such as
     * log in, register, and to exit from our system
     * 
     * @throws InterruptedException
     */
    public static void welcomeScreen() throws InterruptedException {
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

    /**
     * This method has the full functionality of author
     * main menu, author can see enroled courses, available courses,
     * which courrses they created, edit courses, and things of that nature
     * 
     * @param user - passes in the user which is author
     * @throws InterruptedException
     */
    public static void displayAuthorMenu(User user) throws InterruptedException {
        while (true) {
            System.out.println("Author Home Screen");
            System.out.println("Press 1, to view all enrolled/completed courses.");
            System.out.println("Press 2, to view all available courses.");
            System.out.println("Press 3, to view all created courses.");
            System.out.println("Press 4, to create a course.");
            System.out.println("Press 5, to edit a course.");
            System.out.println("Press 6, to take a course");
            System.out.println("Press 7 to view course details");
            System.out.println("Press 8, to leave a comment on a course.");
            System.out.println("Press 9, to leave a reply on a comment.");
            System.out.println("Press 10, to leave a review on a course.");
            System.out.println("Press 11, to print material to a file.");
            System.out.println("Press 12, to logout.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    facade.displayEnrolledCourses(user);
                    System.out.println();
                    break;
                case 2:
                    facade.displayCourses();
                    System.out.println();
                    break;
                case 3:
                    facade.displayCreatedCourses(user);
                    System.out.println();
                    break;
                case 4:
                    facade.createCourse(user);
                    System.out.println();
                    break;
                case 5:
                    facade.editCourse(user);
                    System.out.println();
                    break;
                case 6:
                    facade.takeCourse(user);
                    break;
                case 7:
                    facade.viewCourseDetails();
                    System.out.println();
                    break;
                case 8:
                    facade.courseComment(user);
                    System.out.println();
                    break;
                case 9:
                    facade.courseReply(user);
                    System.out.println();
                    break;
                case 10:
                    facade.courseReview(user);
                    System.out.println();
                    break;
                case 11:
                    facade.printToFile();
                    System.out.println();
                    break;
                case 12:
                    user = null;
                    welcomeScreen();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * This method has all the functionality that is given to the user
     * User can enroll in a course, view all the courses, take course,
     * view course details, leave a comment on a course, leave a review on a course
     * log out thing of that nature
     * 
     * @param user - passes in the user that is logged in
     * @throws InterruptedException
     */
    public static void displayUserMenu(User user) throws InterruptedException {
        System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
        while (true) {
            System.out.println("User Home Screen");
            System.out.println("Press 1, to view all courses available.");
            System.out.println("Press 2, to view enrolled/completed courses.");
            System.out.println("Press 3, to take a course");
            System.out.println("Press 4 to view course details");
            System.out.println("Press 5, to leave a comment on a course.");
            System.out.println("Press 6, to leave a reply on a comment.");
            System.out.println("Press 7, to leave a review on a course.");
            System.out.println("Press 8, to print material to a file.");
            System.out.println("Press 9, to logout.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    facade.displayCourses();
                    System.out.println();
                    break;
                case 2:
                    facade.displayEnrolledCourses(user);
                    System.out.println();
                    break;
                case 3:
                    facade.takeCourse(user);
                    break;
                case 4:
                    facade.viewCourseDetails();
                    System.out.println();
                    break;
                case 5:
                    facade.courseComment(user);
                    System.out.println();
                    break;
                case 6:
                    facade.courseReview(user);
                    System.out.println();
                    break;
                case 7:
                    facade.printToFile();
                    System.out.println();
                    break;
                case 8:
                    user = null;
                    welcomeScreen();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
