import java.util.Scanner;
/**
 * @author JavaDoc
 * Used as facade to call methods.
 */
public class LMS {
    private static UserList userList;
    private static CourseList courseList;
    private static Scanner keyboard = new Scanner(System.in);
    public LMS(){
        userList = userList.getInstance();
        courseList = courseList.getInstance();
    }
    /**
     * Calls login in userList class.
     * @return Returns the user that logged in. If invalid, returns null.
     */
    public static User Login(){
       return userList.login();
    }

    /**
     * Call loginAuthor in userList class.
     * @return newly logged in author if valid. Otherwise null.
     */
    public static User LoginAuthor(){
        return userList.loginAuthor();
    }
    
    /**
     * Calls registerUser in userList().
     * @return newly registered User.
     */
    public static User registerUser(){
        return userList.registerUser();
    }
    /**
     * Calls registerAuthor in userList.
     * @return newly registered Author.
    */
    public static User registerAuthor(){
        return userList.registerAuthor();
    }
    
    /**
     * Calls viewCourses in courseList.
     */
    public static void displayCourses(){
        courseList.viewCourses();
    }

    /**
     * Finds course by title and deletes from course list.
     */
    public static void deleteCourse(){
        System.out.print("Please enter course to be deleted: ");
        courseList.deleteCourse(courseList.getCourseByTitle(keyboard.next()));
        System.out.println();
    }

    public static void createCrouse(){

    }


    /*
    public StartCourse(){

    }

    public mainMenu(){

    }

    public continueCourse(){

    }

    public createCourse(){

    }

    public DeleteCourse(){
        
    }
    */
}
