import java.util.ArrayList;
/**
 * @author JavaDoc
 * Represents a user.
 */
public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private boolean isAuthor;
    private String userID;
    private String username;
    private String password;
    private ArrayList<Course> grades;
    public ArrayList<User> users;
    public ArrayList<Course> courses;

    /**
     * Constructor to initialize user.
     * @param firstname String first name.
     * @param lastname String last name.
     * @param email String user email.
     * @param phonenumber String user phone number.
     * @param username String of username.
     * @param password String of password.
     * @param userID String of user ID.
     * @param isAuthor String "yes" or "no" to determine if author.
     */
    public User(String firstname, String lastname, String email, String phonenumber, String username,
            String password, String userID, String isAuthor) {
        if (validUser(firstname, lastname, email, phonenumber, username, password, userID, isAuthor)) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phonenumber = phonenumber;
            this.username = username;
            this.password = password;
            this.isAuthor = validAuthor(isAuthor);
            this.userID = userID;
            this.courses = new ArrayList<Course>();
            users.add(this);
        }
    }
    /**
     * add a course to a user's list of courses by calling the 
     * addCourse method on a User object and passing in a Course object.
     * @param course
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Determines if a user is valid.
     * @param firstname String first name.
     * @param lastname String last name.
     * @param email String user email.
     * @param phonenumber String user phone number.
     * @param username String of username.
     * @param password String of password.
     * @param userID String of user ID.
     * @param isAuthor String "yes" or "no" to determine if author.
     * @return true if valid, false otherwise.
     */
    public boolean validUser(String firstname, String lastname, String email, String phonenumber, String username,
            String password, String userID, String isAuthor) {
        if (validName(username) && validName(lastname) && validEmail(email) && validPhoneNumber(phonenumber)
                && validUsername(username) && validPassword(password) && validUserID(userID)) {
            return true;
        }
        return false;
    }

    /**
     * Returns first name of user.
     * @return String of first name.
     */
    public String getFirstName() {
        return firstname;
    }

    /**
     * Returns last name of user.
     * @return String of last name.
     */
    public String getLastName() {
        return lastname;
    }

    /**
     * Returns email of user.
     * @return String of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns user phone number.
     * @return String of phone number.
     */
    public String getPhoneNumber() {
        return phonenumber;
    }

    /**
     * Returns the user password.
     * @return String of password.
     */
    public String getPassword(){
        return password;
    }

    /**
     * Returns if author or not.
     * @return true if author, false otherwise.
     */
    public boolean isAuthor() {
        return isAuthor;
    }

    /**
     * Returns username.
     * @return String of username.
     */
    public String getUserName() {
        return username;
    }

    /**
     * Returns user ID.
     * @return String of user id.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Checks if name is valid.
     * @param name String name from user.
     * @return true if valid, false otherwise.
     */
    private boolean validName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }

    /**
     * Checks if username is valid.
     * @param userName String of username.
     * @return true if valid, false otherwise.
     */
    private boolean validUsername(String userName) {
        return userName != null && userName.length() >= 6 && !userName.isEmpty();
    }

    /**
     * Checks if phone number is valid.
     * @param phonenumber String of phone number.
     * @return true if valid, false otherwise.
     */
    private boolean validPhoneNumber(String phonenumber) {
        return phonenumber != null && phonenumber.matches("\\d{10}");
    }

    /**
     * Checks if valid email.
     * @param email String of email.
     * @return true if valid, false otherwise.
     */
    private boolean validEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    /**
     * Checks if valid password.
     * @param password String of password.
     * @return true if valid, false otherwise.
     */
    private boolean validPassword(String password) {
        return password.length() >= 8 && containsNumber(password) && containsSpecialCharacter(password);
    }

    /**
     * Checks if valid user ID.
     * @param userID String of user ID.
     * @return true if valid, false otherwise.
     */
    private boolean validUserID(String userID) {
        return userID != null && !userID.isEmpty();
    }

    /**
     * Checks if author inputs is valid.
     * @param isAuthor String of "yes" or "no"
     * @return true if yes, false otherwise.
     */
    private boolean validAuthor(String isAuthor) {
        if (isAuthor.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    /**
     * Checks if contains number.
     * @param password String of password.
     * @return true if contains number, false otherwise.
     */
    private boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    /**
     * Checks if contains special character.
     * @param password String of password.
     * @return true if contains special character, false otherwise.
     */
    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }
    /**
     * accesing this in the UI, and that's why it's public
     * @return all the courses that user is taking
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }
}
