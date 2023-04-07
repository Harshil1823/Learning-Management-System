import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    @BeforeClass
	public void oneTimeSetup() {
	}
	
	@AfterClass
	public void oneTimeTearDown() {
	}
	
	@BeforeEach
	public void setup() {
	}
	
	@AfterEach
	public void tearDown() {
		//runs after each test
	}
    @Test
    public void testGetFirstNameWithValidName() {
        User user = new User("John", "Doe", "johndoe@example.com", "1234567890", "johndoe", "password", "1234", "no");
        assertEquals("John", user.getFirstName());
    }
    @Test
    public void testGetFirstNameWithNullUsername() {
        User user = new User(null, "Doe", "johndoe@example.com", "1234567890", null, "password", "1234", "no");
        assertEquals("", user.getFirstName());
    }
    @Test
    public void testGetFirstNameWithEmptyName() {
        User user = new User("", "", "johndoe@example.com", "1234567890", "johndoe", "password", "1234", "no");
        assertEquals("", user.getFirstName());
    }
    @Test
    public void testGetLastNameReturnsLastName() {
        User user = new User("John", "Doe", "johndoe@example.com", "555-555-5555", "johndoe", "password", "12345", "no");
        assertEquals("Doe", user.getLastName());
    }
    @Test
    public void testGetLastNameReturnsEmptyStringWhenUsernameIsNull() {
        User user = new User(null, null, null, null, null, null, null, null);
        assertEquals("", user.getLastName());
    }
}
