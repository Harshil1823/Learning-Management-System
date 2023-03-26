import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author JavaDoc
 * Handles user list operations.
 */
public class UserList {
    public static Scanner keyboard = new Scanner(System.in);
    private static ArrayList<User> userList;
    private static UserList instance;

    /**
     * Constructor to create new userList.
     */
    private UserList() {
        userList = new ArrayList<>();
    }

    /**
     * Returns user list instance. 
     * @return returns instance of new userlist or previouse instance.
     */
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    /**
     * Adds user to list.
     * @param user Type user to be added.
     */
    public void addUser(User user) {
        userList.add(user);
    }

    /**
     * Returns user chosen by name.
     * @param userName String of username.
     * @return user chosen.
     */
    public static User getUser(String userName) {
        if (userName == null) {
            return null;
        }
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Removes users from user list.
     * @param user Type user to be removed.
     */
    public void removeUser(User user) {
        userList.remove(user);
    }

    /**
     * Saves users to data writer.
     */
    public void saveUsers() {
        DataWriter writer = new DataWriter();
        writer.saveUsers(userList);
    }

    /**
     * Login for user.
     * @return User if valid, null otherwise.
     */
    public User login() {
        User tempUser = null;
        System.out.print("Please enter username: ");
        System.out.println();
        //Checks to see if user in list.
        for (User user : userList) {
            if (user.getUserName().equals(keyboard.next())) {
                tempUser = user;
            }
        }
        //Check if password matches, if so return user.
        System.out.print("Please enter password: ");
        if(tempUser.getPassword().equals(keyboard.next()))
            return tempUser;
        return tempUser;
    }

    /**
     * Login for the author.
     * @return logged in author if valid or null if not valid.
     */
    public User loginAuthor(){
        User tempUser = null;
        System.out.print("Please enter username: ");
        System.out.println();
        //Checks to see if user in list.
        for (User user : userList) {
            if (user.getUserName().equals(keyboard.next())) {
                tempUser = user;
            }
        }
        //Check if password matches, if so return user.
        System.out.print("Please enter password: ");
        if(tempUser.getPassword().equals(keyboard.next()) && tempUser.isAuthor())
            return tempUser;
        return tempUser;
    }

    /**
     * Adds new user to list and returns it.
     * @return newly added user.
     */
    public User registerUser(){
        System.out.println("Please enter the provided information below to register as User.");
        System.out.print("First Name: ");
        String firstName = keyboard.next();
        System.out.println();

        System.out.print("Last Name: ");
        String lastName = keyboard.next();
        System.out.println();

        System.out.print("Email Address: ");
        String email = keyboard.next();
        System.out.println();

        System.out.print("Phone Number: ");
        String phoneNumber = keyboard.next();
        System.out.println();
        
        System.out.print("Username: ");
        String username = keyboard.next();
        System.out.println();

        System.out.print("Password: ");
        String password = keyboard.next();
        System.out.println();
        
        User user = new User(firstName, lastName, email, phoneNumber, username, password, UUID.randomUUID().toString(), "no");
        userList.add(user);
        return user;
    }

    /**
     * Adds new author to list and returns it.
     * @return new author.
     */
    public User registerAuthor(){
        System.out.println("Please enter the provided information below to register as User.");
        System.out.print("First Name: ");
        String firstName = keyboard.next();
        System.out.println();

        System.out.print("Last Name: ");
        String lastName = keyboard.next();
        System.out.println();

        System.out.print("Email Address: ");
        String email = keyboard.next();
        System.out.println();

        System.out.print("Phone Number: ");
        String phoneNumber = keyboard.next();
        System.out.println();
        
        System.out.print("Username: ");
        String username = keyboard.next();
        System.out.println();

        System.out.print("Password: ");
        String password = keyboard.next();
        System.out.println();
        
        User user = new User(firstName, lastName, email, phoneNumber, username, password, UUID.randomUUID().toString(), "yes");
        userList.add(user);
        return user;
    }
}
