import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants {
    public static ArrayList<User> user = new ArrayList<User>();

    public ArrayList<User> getUsers(){
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser(); 
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for(int i = 0; i < usersJSON.size(); i++ ){
                JSONObject userJSON = (JSONObject) usersJSON.get(i);
                String uFirstName = (String) userJSON.get(USER_FIRST_NAME);
                String uLastName = (String) userJSON.get(USER_LAST_NAME);
                String uPhoneNumber = (String) userJSON.get(USER_PHONENUMBER);
                String uPassword = (String) userJSON.get(USER_PASSWORD);

                User u = new User();
                user.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<Author> getAuthors() {
        return new ArrayList<Author>();
    }

    public void getCourses() {

    }
}