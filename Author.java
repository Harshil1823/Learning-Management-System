import java.util.ArrayList;

public class Author implements Account {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    private String password;
    private String userName;
    public ArrayList<Author> authors;
    public ArrayList<Course> courses;

    
    public boolean validUsername(String userName) {
        return true;
    }

    public boolean validPassword(String password) {
        return true;
    }
}
