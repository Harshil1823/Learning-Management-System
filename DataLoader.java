import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    public static ArrayList<User> user = new ArrayList<User>();


    public ArrayList<User> getUsers(){
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser(); 
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i =0; i< usersJSON.size(); i++ ){
                JSONObject userJSON = (JSONObject)userJSON.get(i);
            }

        }
        return new ArrayList<User>();
    }

    public ArrayList<Author> getAuthors() {
        return new ArrayList<Author>();
    }

    public getCourses() {

    }
}
