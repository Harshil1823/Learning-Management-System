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

    // Checks if user valid and adds to user list.
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
            users.add(this);
        }
    }

    public boolean validUser(String firstname, String lastname, String email, String phonenumber, String username,
            String password, String userID, String isAuthor) {
        if (validName(username) && validName(lastname) && validEmail(email) && validPhoneNumber(phonenumber)
                && validUsername(username) && validPassword(password) && validUserID(userID)) {
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
    
    public String getPassword(){
        return password;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public String getUserName() {
        return username;
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

    private boolean validAuthor(String isAuthor) {
        if (isAuthor.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    private boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }
}
