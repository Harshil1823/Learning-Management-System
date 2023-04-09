import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest extends DataConstants {
    private static final String TEST_USER_FILE = "testUsers.json";

    private static ArrayList<User> users;

    @BeforeAll
    public static void setUpBeforeClass() {
        // create a test directory if it does not exist
        new File("/Users/MACRaptor/JavaDoc/json/userTest.json").mkdir();
    }

    @BeforeEach
    public void setUp() {
        users = new ArrayList<User>();

        users.add(new User("David","Copperfield","NowyouSeeMe@gmail.com", "4044444444", "NowYouDont", "disappear", "MagicMan", "yes"));
        users.add(new User(null, null, null, null, null, null, null, null));;
    }

    @AfterEach
    public void tearDown() {
        // delete test file after each test
        File file = new File("/Users/MACRaptor/JavaDoc/json/userTest.json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public static void testSaveUsers(ArrayList<User> userList) {
        DataWriter.saveUsers(users);

        try {
            FileReader reader = new FileReader("/Users/MACRaptor/JavaDoc/json/userTest.json" + File.separator + TEST_USER_FILE);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);
            reader.close();

            assertEquals(users.size(), usersJSON.size());

            for (int i = 0; i < users.size(); i++) {
                JSONObject userJSON = (JSONObject) usersJSON.get(i);
                User user = users.get(i);

                assertEquals(user.getUserID(), userJSON.get(USER_ID));
                assertEquals(user.getFirstName(), userJSON.get(USER_FIRST_NAME));
                assertEquals(user.getLastName(), userJSON.get(USER_LAST_NAME));
                assertEquals(user.getEmail(), userJSON.get(USER_EMAIL));
                assertEquals(user.getPhoneNumber(), userJSON.get(USER_PHONENUMBER));
                assertEquals(user.getUserName(), userJSON.get(USER_USERNAME));
                assertEquals(user.getPassword(), userJSON.get(USER_PASSWORD));
                assertEquals(user.isAuthor(), userJSON.get(IS_AUTHOR));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
