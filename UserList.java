import java.util.ArrayList;
public class UserList {
    private UserList userList;
    private ArrayList<User> users;

    private UserList(){

    }
    public static UserList getInstance(){
        return new UserList();
    }

    public static ArrayList<User> getUser(String userName){
        return new User();
    }
}
