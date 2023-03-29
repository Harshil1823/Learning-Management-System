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

    public void displayCreatedCourses(User user){
        for(int i = 1; i <= user.getCreatedCourses().size(); i++){
            System.out.println(i + ". ");
            System.out.println(user.getCreatedCourses().get(i-1).getTitle());
        }
    }

    /**
     * Finds course by title and deletes from course list.
     */
    public void deleteCourse(){
        System.out.print("Please enter course to be deleted: ");
        courseList.deleteCourse(courseList.getCourseByTitle(keyboard.next()));
        keyboard.nextLine();
        System.out.println("Course deleted");
    }
    /**
     * 
     * @param user passes in user as a object and checks it's enrolled courses
     * and prints them out to the user
     * calls the method that is implemented in courseList
     */
    public void displayEnrolledCourses(User user){
        courseList.displayEnrolledCourses(user);
    }
    /**
     * @param user - passes in user as a object (author only)
     * calls the method that is implemented in courseList to add a course
     * and it creates a course for author and adds it to the course array
     * that is within CourseList class
     */
    public void createCourse(User user){
        courseList.addCourse(courseList.createCourse(user));
    }
    /**
     * @param user passes in user as a object (author only)
     * checks to see if the course that author wants to edit is within the course 
     * arrayList and if it is then gives teh author the option to edit the course
     * edit things such as modules, topics, quiz, etc...
     */
    public void editCourse(User user){
        courseList.editCourse(user);
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
    public boolean enrollInCourse(User user) {
        return courseList.enrollInCourse(user);
    }
    /**
     * lets the user comment on a course
     * @param user - passes in user as a object (user)
     */
    public void courseComment(User user){
        courseList.courseComment(user);
    }
    /**
     * lets the user Review on a course
     * @param user - passes in a user as a object (user)
     */
    public void courseReview(User user){
        courseList.courseReview(user);
    }
    /**
     * You can check the courseDetails such as 
     * who created the course, title, description, and 
     * modules
     */
    public void viewCourseDetails(){
        courseList.getCourseDetails();
    }

}
