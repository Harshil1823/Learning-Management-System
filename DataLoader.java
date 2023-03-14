<<<<<<< HEAD
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    public static ArrayList<User> user = new ArrayList<User>();


=======
import java.util.ArrayList;
public class DataLoader {
>>>>>>> 22bdecfe5ba81a04d65aafde9b843ee38598072d
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

    public void getCourses() {

    }
}
