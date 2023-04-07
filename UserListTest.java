import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {
    private UserList userList;

    @BeforeClass
	public void oneTimeSetup() {
		
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		//runs before each test
        userList = UserList.getInstance();
        userList.clear();
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
    @Test
    public void testAddUser() {
        // Create a new user to add to the list
        User user = new User("John", "Doe", "john.doe@example.com", null, null, null, null, null);
        userList.addUser(user);

        // Ensure that the user was added to the list
        assertTrue(userList.contains(user));
    }
    @Test
    public void testAddUserDoesNotAddDuplicate() {
        // Create a new user to add to the list
        User user = new User("John", "Doe", "john.doe@example.com", null, null, null, null, null);
        userList.addUser(user);

        // Add the same user again
        userList.addUser(user);

        // Ensure that the user was not added to the list twice
        assertEquals(1, userList.size());
    }
    @Test
    public void testAddUserAddsToEmptyList() {
        // Ensure that the list is initially empty
        assertEquals(0, userList.size());

        // Create a new user to add to the list
        User user = new User("John", "Doe", "john.doe@example.com", null, null, null, null, null);
        userList.addUser(user);

        // Ensure that the user was added to the list
        assertEquals(1, userList.size());
        assertTrue(userList.contains(user));
    }
    @Test
    public void testGetUser() {
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);
    
        // Test getting a user with a valid username
        User user = userList.getUser("johndoe");
        assertNotNull(user);
        assertEquals("John", user.getFirstName());
    }
    @Test
    public void testGetUserNullUserName(){
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);
        // Test getting a user with a null username
        User user = userList.getUser("null");
        // Test getting a user with a null username
        assertNull(user);
    }
    @Test
    public void testGetUserWithInvalidUserName(){
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);
        // Test getting a user with a null username
        User user = userList.getUser("kdlsjflkds");
        // Test getting a user with an invalid username
        assertNull(user);
    }
    @Test
    public void testRemoveUser(){
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);

        userList.removeUser(user1);
        assertEquals(1, userList.size());
    }
    @Test
    public void testRemoveUserSameUser(){
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);

        userList.removeUser(user1);
        assertEquals(1, userList.size());
        //removing the same user again
        userList.removeUser(user1);
        assertEquals(1, userList.size());
    }
    @Test
    public void testRemoveUserMutiple(){
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);

        userList.removeUser(user1);
        userList.removeUser(user2);
        assertEquals(0, userList.size());
    }
    @Test
    public void testRemoveUserNull(){
        User user1 = new User("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "hashedpassword", "f558ac43-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "0123456789", "jamessmith", "adsfadsf", "f558ac44-cc7a-4dcb-86ce-8720a3cf3d8e", null);
        userList.addUser(user1);
        userList.addUser(user2);

        userList.removeUser(null);
        assertEquals(2, userList.size());
    }
    
}
