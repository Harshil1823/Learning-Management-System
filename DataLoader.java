import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants {
    public static ArrayList<User> user = new ArrayList<User>();
    public static ArrayList<Author> author = new ArrayList<Author>(); 

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

                
                user.add(new User(uFirstName, uLastName, uPhoneNumber, uPassword));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /*public ArrayList<Author> getAuthors() {
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser(); 
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for(int i = 0; i < usersJSON.size(); i++ ){
                JSONObject userJSON = (JSONObject) usersJSON.get(i);
                String aFirstName = (String) userJSON.get(AUTHOR_FIRST_NAME);
                String aLastName = (String) userJSON.get(AUTHOR_LAST_NAME);
                String aPhoneNumber = (String) userJSON.get(AUTHOR_PHONENUMBER);
                String aPassword = (String) userJSON.get(AUTHOR_PASSWORD);

                
                Author.add(new Author(aFirstName, aLastName, aPhoneNumber, aPassword));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }
*/
    public void getCourses() {
        try {
        FileReader reader = new FileReader(COURSE_FILE_NAME);
        JSONParser parser = new JSONParser(); 
        JSONArray usersJSON = (JSONArray) parser.parse(reader);

        for(int i = 0; i < usersJSON.size(); i++ ){
            JSONObject userJSON = (JSONObject) usersJSON.get(i);
            String cCourseID = (String) userJSON.get(COURSE_ID);
            String cTitle = (String) userJSON.get(COURSE_TITLE);
            String cDescription = (String) userJSON.get(COURSE_DESCRIPTION);
            String cModule = (String) userJSON.get(COURSE_MODULE);

            
            Course.add(new Course(cCourseID,cTitle,cDescription,cModule));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    }
}