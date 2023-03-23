import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> userList;
    private static UserList instance;

    private UserList() {
        userList = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public static ArrayList<User> getUser(String userName) {
        if (userName == null) {
            return userList;
        }
        ArrayList<User> result = new ArrayList<>();
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                result.add(user);
            }
        }
        return result;
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public void saveUsers() {
        DataWriter writer = new DataWriter();
        writer.saveUsers();
    }
}
