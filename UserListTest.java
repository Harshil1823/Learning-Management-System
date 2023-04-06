import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {

    @BeforeClass
	public void oneTimeSetup() {
		
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		//runs before each test
	}
	
	@AfterEach
	public void tearDown() {
		//runs after each test
	}

    @Test
    public void testGetInstanceReturnsNull() {
         // Ensure that the instance is not null
         UserList instance = UserList.getInstance();
         assertEquals(UserList.class, instance.getClass());
    }
    @Test
    public void testGetInstanceReturnsSameInstance() {
        // Ensure that getInstance always returns the same instance
        UserList instance1 = UserList.getInstance();
        UserList instance2 = UserList.getInstance();
        assertEquals(instance1, instance2);
    }
    @Test
    public void testGetInstanceCalledTwiceReturnsSameInstance() {
        // Ensure that calling getInstance twice in a row returns the same instance
        UserList instance1 = UserList.getInstance();
        UserList instance2 = UserList.getInstance();
        assertEquals(instance1, instance2);
    }
}
