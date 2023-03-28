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
        this.userList = userList.getInstance();
        this.courseList = courseList.getInstance();
    }
    /**
     * Calls login in userList class.
     * @return Returns the user that logged in. If invalid, returns null.
     */
    public User Login(){
       return userList.login();
    }

    /**
     * Call loginAuthor in userList class.
     * @return newly logged in author if valid. Otherwise null.
     */
    public User LoginAuthor(){
        return userList.loginAuthor();
    }
    
    /**
     * Calls registerUser in userList().
     * @return newly registered User.
     */
    public User registerUser(){
        return userList.registerUser();
    }
    /**
     * Calls registerAuthor in userList.
     * @return newly registered Author.
    */
    public User registerAuthor(){
        return userList.registerAuthor();
    }
    
    /**
     * Calls viewCourses in courseList.
     */
    public void displayCourses(){
        courseList.viewCourses();
    }

    /**
     * Finds course by title and deletes from course list.
     */
    public void deleteCourse(){
        System.out.print("Please enter course to be deleted: ");
        courseList.deleteCourse(courseList.getCourseByTitle(keyboard.next()));
        System.out.println();
    }

    public void displayEnrolledCourses(User user){
        courseList.displayEnrolledCourses(user);
    }
    /**
     * 
     */
    public void createCourse(User user){
        courseList.addCourse(courseList.createCourse(user));
    }

    public void editCourse(){
        courseList.editCourse();
    }
    /**
     * calls the method in course list that check to see 
     * if the user is already taking the course,
     * if not then enroll them in that course
     * if no such course exists then return false
     * @param user
     * @param title
     * @return
     */
    public boolean enrollInCourse(User user, String title) {
        return courseList.enrollInCourse(user, title);
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
