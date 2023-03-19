
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

    public boolean addUser(String firstname, String lastname, String email, String phonenumber, String username,
            String password, String author, String userID) {
        if (validName(username) && validName(lastname) && validEmail(email) && validPhoneNumber(phonenumber)
                && validUsername(username) && validPassword(password) && isAuthor(author) && validUserID(userID)) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phonenumber = phonenumber;
            this.username = username;
            this.password = password;
            this.isAuthor = true;
            this.userID = userID;
            return true;
        }
        return false;
    }

    public String getFirstName() {
        if (firstname == null)
            return null;
        return this.firstname;
    }

    public String getLastName() {
        if (lastname == null)
            return null;
        return this.lastname;
    }

    public String getEmail() {
        if (email == null)
            return null;
        return this.email;
    }

    public String getPhoneNumber() {
        if (phonenumber == null)
            return null;
        return this.phonenumber;
    }

    public boolean isAuthor() {
        if (this.isAuthor)
            return true;
        return false;
    }

    public String getUserID() {
        if (userID == null)
            return null;
        return this.userID;
    }

    private boolean validName(String firstname) {
        int letterCount = 0;
        for (char i : firstname.toCharArray())
            if (Character.isLetter(i))
                letterCount++;
        if (letterCount == firstname.length())
            return true;
        return false;
    }

    // Might make check for innapropriate phrases.
    private boolean validUsername(String userName) {
        if (userName == null || userName.length() < 6 || users.contains(userName))
            return false;
        return true;
    }

    private boolean validPhoneNumber(String phonenumber) {
        if (phonenumber == null || phonenumber.isEmpty() || phonenumber.length() != 10)
            return false;
        return true;
    }

    private boolean validEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@") || !email.contains(".com"))
            return false;
        return true;
    }

    private boolean validPassword(String password) {
        if (password.length() >= 8 && containsNumber(password) && containsSpecialCharacter(password))
            return true;
        return false;
    }

    private boolean isAuthor(String author) {
        if (author.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    private boolean validUserID(String userID) {
        if (userID == null || userID.isEmpty())
            return false;
        return true;
    }

    private boolean containsNumber(String password) {
        for (char i : password.toCharArray()) {
            if (Character.isDigit(i))
                return true;
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (char i : password.toCharArray()) {
            if (!Character.isLetterOrDigit(i))
                return true;
        }
        return false;
    }

    public Object getUserName() {
        return null;
    }

    public Object getPassword() {
        return null;
    }
}
