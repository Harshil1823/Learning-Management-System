import java.util.ArrayList;

public class User {
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String phonenumber;
    protected boolean isAuthor;
    protected String userID;
    private String username;
    private String password;
    private ArrayList<Course> grades;
    public ArrayList<User> users;
    public ArrayList<Course> courses;

    public User(String userID2, String uFirstName, String uLastName, String userEmail, String uPhoneNumber,
            String userName2, String uPassword, String isUser) {
    }

    public boolean addUser(String firstname, String lastname, String email, String phonenumber, String username,
            String password, String userID) {
        if (validName(username) && validName(lastname) && validEmail(email) && validPhoneNumber(phonenumber)
                && validUsername(username) && validPassword(password) && validUserID(userID)) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phonenumber = phonenumber;
            this.username = username;
            this.password = password;
            this.isAuthor = containsSpecialCharacter(password) && containsNumber(password);
            this.userID = userID;
            return true;
        }
        return false;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public int getUserID() {
        return Integer.parseInt(userID);
    }

    private boolean validName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }

    private boolean validUsername(String userName) {
        return userName != null && userName.length() >= 6 && !userName.isEmpty();
    }

    private boolean validPhoneNumber(String phonenumber) {
        return phonenumber != null && phonenumber.matches("\\d{10}");
    }

    private boolean validEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean validPassword(String password) {
        return password.length() >= 8 && containsNumber(password) && containsSpecialCharacter(password);
    }

    private boolean validUserID(String userID) {
        return userID != null && !userID.isEmpty();
    }

    private boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
