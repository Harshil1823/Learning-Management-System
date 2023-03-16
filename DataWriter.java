import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userArray = User.getUser();
        JSONArray jsonUser = new JSONArray();

        for(int i=0; i<userArray.size();i++){
            jsonUser.add(getUserJSON(userArray.get(i)));
        }

        try(FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUser.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getUserID());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PHONENUMBER, user.getPhoneNumber());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_USERNAME, user.getUsername());

    return userDetails;
    }

    public void saveCourses() {

    }

    public void saveAuthors() {
        Author author = Author.getInstance(); 
        ArrayList<Author> 

    }
}
