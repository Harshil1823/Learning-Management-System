import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Course> courseList = new ArrayList<>();

    @BeforeAll
    public static void jsonTestingSetup() {
        new File("json/userTest.json").mkdirs();
    }

    @BeforeEach
    public void setup() {
        userList.add(new User("David","Copperfield","NowyouSeeMe@gmail.com", "4044444444", "NowYouDont", "disappear", "MagicMan", "yes"));
        userList.add(new User("Susan", "veranda", "SVU@gmail.com", "5555555555", "SV", "password", "110101010100101", "no"));
        userList.add(new User(null, null, null, null, null, null, null, null));
        DataWriterTest.testSaveUsers(userList);

        ArrayList <Module> testModule = new ArrayList<>();
        ArrayList<Review> testReview = new ArrayList<>();
        courseList.add(new Course(null, null, null, null, null, null, null, null));
        courseList.add(new Course("Dr. Suess", "How to Write Children's books", "null", "111", "2314", "INTERMEDIATE", testModule, testReview));
    }

    @AfterEach
    public void tearDown() {
        userList.clear();
        courseList.clear();

    }

    @Test
    public void testLoadUsers() {
        assertEquals(3, userList.size());
        User user = userList.get(0);
        assertEquals("David", user.getFirstName());
        assertEquals("Copperfield", user.getLastName());
        assertEquals("NowyouSeeMe@gmail.com", user.getEmail());
        assertEquals("4044444444", user.getPhoneNumber());
        assertEquals("NowYouDont", user.getUserName());
        assertEquals("disappear", user.getPassword());
        assertEquals("MagicMan", user.getUserID());
        assertEquals("yes", user.isAuthor());
    }
    @Test
    public void testSecondIndex(){assertEquals(3, userList.size());
        User user = userList.get(1);
        assertEquals("Susan", user.getFirstName());
        assertEquals("veranda", user.getLastName());
        assertEquals("SVU@gmail.com", user.getEmail());
        assertEquals("5555555555", user.getPhoneNumber());
        assertEquals("SV", user.getUserName());
        assertEquals("password", user.getPassword());
        assertEquals("110101010100101", user.getUserID());
        assertEquals("no", user.isAuthor());

    }
    @Test
    public void testNullUsers(){ 
        assertEquals(3, userList.size());
        User user = userList.get(2);
        assertEquals(null, user.getFirstName());
        assertEquals(null, user.getLastName());
        assertEquals(null, user.getEmail());
        assertEquals(null, user.getPhoneNumber());
        assertEquals(null, user.getUserName());
        assertEquals(null, user.getPassword());
        assertEquals(null, user.getUserID());
        assertEquals(null, user.isAuthor());
        
    }
    @Test
    public void testNullCourse(){ 
        assertEquals(2, courseList.size());
        Course course = courseList.get(0);
        assertEquals(null, course.getAuthor());
        assertEquals(null, course.getTitle());
        assertEquals(null, course.getDescription());
        assertEquals(null, course.getUser_ID());
        assertEquals(null, course.getCourseID());
        assertEquals(null, course.getDifficulty());
        assertEquals(null, course.getModules());
        assertEquals(null, course.getReviews());
        
    }
    @Test
    public void testLoadCourse(){ 
        assertEquals(2, courseList.size());
        Course course = courseList.get(1);
        assertEquals("Dr. Suess", course.getAuthor());
        assertEquals("How to Write Children's books", course.getTitle());
        assertEquals("null", course.getDescription());
        assertEquals("111", course.getUser_ID());
        assertEquals("2314", course.getCourseID());
        assertEquals("INTERMEDIATE", course.getDifficulty());
        assertEquals(null, course.getModules());
        assertEquals(null, course.getReviews());
    }

}
