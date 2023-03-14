public class UserList {
    private UserList userList;
    private ArrayList<User> users;

    private UserList(){

    }
    public UserList getInstance(){
        return new UserList();
    }

    public User getUser(String userName){
        return new User();
    }
}
