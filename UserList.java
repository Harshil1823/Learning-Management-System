import java.util.ArrayList;
/**
 * @author JavaDoc
 * Handles user list operations.
 */
public class UserList {
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
     * Lets user login with information.
     */
    public void login(){

    }
}
