import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // create some sample data
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("1", "John", "Doe", "johndoe@example.com", "555-1234", "johndoe", "password", "true");
        User user2 = new User("2", "Jane", "Doe", "janedoe@example.com", "555-5678", "janedoe", "password", "false");
        users.add(user1);
        users.add(user2);
        
        ArrayList<Course> courses = new ArrayList<Course>();
        Course course1 = new Course("1", "Intro to Java", "Learn the basics of Java programming", "1", "3", null, null, null, null);
        Course course2 = new Course("2", "Advanced Java", "Take your Java skills to the next level", "2", "5", null, null, null, null);
        courses.add(course1);
        courses.add(course2);
        
        // save the data to files
        DataWriter writer = new DataWriter();
        writer.saveUsers(users);
        writer.saveCourses(courses);
        
        // load the data from files and print it out
        DataLoader loader = new DataLoader();
        ArrayList<User> loadedUsers = loader.getUsers();
        ArrayList<Course> loadedCourses = loader.getCourses();
        
        System.out.println("Loaded users:");
        for (User user : loadedUsers) {
            System.out.println(user);
        }
        
        System.out.println("Loaded courses:");
        for (Course course : loadedCourses) {
            System.out.println(course);
        }
    }
}
