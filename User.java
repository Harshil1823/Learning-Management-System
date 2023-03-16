
import java.util.ArrayList;

public class User {
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String phoneNumber;
    private String password;
    private String userName;
    private ArrayList<Course> grades;
    public ArrayList<User> users;

    public boolean addUser(String firstname, String lastname, String email, String phonenumber, String password, String ) {
        this.userName = username;
        this.password = password;
    }

    // Might make check for innapropriate phrases.
    public boolean validUsername(String userName) {
        if (userName.length() < 6 && users.contains(userName))
            return false;
        return true;
    }

    public boolean validPassword(String password) {
        if (password.length() >= 8 && containsNumber(password) && containsSpecialCharacter(password))
            return true;
        return false;
    }

    public boolean isAuthor() {

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
}
