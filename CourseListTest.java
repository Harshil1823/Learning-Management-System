import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;
import static org.junit.Assert.assertTrue;

public class CourseListTest {
    public static CourseList courseList = CourseList.getInstance();

    @BeforeAll
    public static void setUp() {
        Course course1 = new Course("Dom", "titleofcourse", "Course description", UUID.randomUUID().toString(),
                UUID.randomUUID().toString(), "beginner", new ArrayList<>(), new ArrayList<>());
        courseList.addCourse(course1);
    }

    @Test
    public void testCourseListNotEmpty() {
        assertFalse(courseList.getCourses().isEmpty(), "CourseList should not be empty");
    }

    @Test
    public void testAddCourse() {
        int initialSize = courseList.getCourses().size();
        ArrayList<Module> modules = new ArrayList<>();
        ArrayList<Review> reviews = new ArrayList<>();
        Course course2 = new Course("John", "titleofcourse2", "Course description 2", UUID.randomUUID().toString(),
                UUID.randomUUID().toString(), "intermediate", modules, reviews);
        courseList.addCourse(course2);
        int newSize = courseList.getCourses().size();
        assertEquals(initialSize + 1, newSize, "CourseList size should have increased by 1");
    }

    @Test
    public void testGetCourse_ValidIndex() {
        Course course = courseList.getCourses().get(0);
        Course retrievedCourse = courseList.getCourse(0);
        assertEquals(course, retrievedCourse, "The retrieved course should match the course at index 0");
    }

    @Test
    public void testGetCourse_NegativeIndex() {
        Course retrievedCourse = courseList.getCourse(-1);
        assertNull(retrievedCourse, "The retrieved course should be null for a negative index");
    }

    @Test
    public void testGetCourse_IndexOutOfBounds() {
        int invalidIndex = courseList.getCourses().size();
        Course retrievedCourse = courseList.getCourse(invalidIndex);
        assertNull(retrievedCourse, "The retrieved course should be null for an index out of bounds");
    }

    @Test
    public void testGetCourse_EmptyList() {
        CourseList emptyCourseList = new CourseList();
        Course retrievedCourse = emptyCourseList.getCourse(0);
        assertNull(retrievedCourse, "The retrieved course should be null for an empty list");
    }

    @Test
    public void testGetCourse_LastCourse() {
        int lastIndex = courseList.getCourses().size() - 1;
        Course lastCourse = courseList.getCourses().get(lastIndex);
        Course retrievedCourse = courseList.getCourse(lastIndex);
        assertEquals(lastCourse, retrievedCourse, "The retrieved course should match the last course in the list");
    }

    @Test
    public void testAddCourse_SingleCourse() {
        int initialSize = courseList.getCourses().size();
        Course course = new Course("Single", "Single Course Title", "Single Course Description",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "advanced", new ArrayList<>(),
                new ArrayList<>());
        courseList.addCourse(course);
        int newSize = courseList.getCourses().size();
        assertEquals(initialSize + 1, newSize, "CourseList size should have increased by 1");
    }

    @Test
    public void testAddCourse_NullCourse() {
        int initialSize = courseList.getCourses().size();
        Course course = null;
        courseList.addCourse(course);
        int newSize = courseList.getCourses().size();
        assertEquals(initialSize, newSize, "CourseList size should not change when adding a null course");
    }

    @Test
    public void testAddCourse_MultipleCourses() {
        int initialSize = courseList.getCourses().size();
        Course course1 = new Course("Multiple 1", "Multiple Course Title 1", "Multiple Course Description 1",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "beginner", new ArrayList<>(),
                new ArrayList<>());
        Course course2 = new Course("Multiple 2", "Multiple Course Title 2", "Multiple Course Description 2",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "intermediate", new ArrayList<>(),
                new ArrayList<>());
        courseList.addCourse(course1);
        courseList.addCourse(course2);
        int newSize = courseList.getCourses().size();
        assertEquals(initialSize + 2, newSize, "CourseList size should have increased by 2");
    }

    @Test
    public void testGetInstance_SameInstance() {
        CourseList instance1 = CourseList.getInstance();
        CourseList instance2 = CourseList.getInstance();
        assertSame(instance1, instance2, "getInstance() should return the same instance");
    }

    @Test
    public void testGetInstance_NotNull() {
        CourseList instance = CourseList.getInstance();
        assertNotNull(instance, "getInstance() should not return a null instance");
    }

    @Test
    public void testGetCourseByTitle_ValidTitle() {
        String validTitle = "titleofcourse";
        Course course = courseList.getCourseByTitle(validTitle);
        assertNotNull(course, "The retrieved course should not be null for a valid title");
        assertEquals(validTitle, course.getTitle(), "The retrieved course title should match the requested title");
    }

    @Test
    public void testGetCourseByTitle_NonExistentTitle() {
        String nonExistentTitle = "NonExistent Course Title";
        Course course = courseList.getCourseByTitle(nonExistentTitle);
        assertNull(course, "The retrieved course should be null for a non-existent title");
    }

    @Test
    public void testGetCourseByTitle_CaseInsensitiveTitle() {
        String caseInsensitiveTitle = "TitleOfCourse";
        Course course = courseList.getCourseByTitle(caseInsensitiveTitle);
        assertNotNull(course, "The retrieved course should not be null for a case-insensitive title");
        assertEquals(caseInsensitiveTitle.toLowerCase(), course.getTitle().toLowerCase(),
                "The retrieved course title should match the requested title (case-insensitive)");
    }

    @Test
    public void testGetCourseByTitle_EmptyTitle() {
        String emptyTitle = "";
        Course course = courseList.getCourseByTitle(emptyTitle);
        assertNull(course, "The retrieved course should be null for an empty title");
    }

    @Test
    public void testGetCourseByTitle_NullTitle() {
        String nullTitle = null;
        Course course = courseList.getCourseByTitle(nullTitle);
        assertNull(course, "The retrieved course should be null for a null title");
    }

    @Test
    public void testGetCourses_NotEmpty() {
        ArrayList<Course> courses = courseList.getCourses();
        assertNotNull(courses, "getCourses() should not return a null list");
        assertFalse(courses.isEmpty(), "getCourses() should not return an empty list");
    }

    @Test
    public void testGetCourses_Empty() {
        CourseList emptyCourseList = new CourseList();
        ArrayList<Course> courses = emptyCourseList.getCourses();
        assertNotNull(courses, "getCourses() should not return a null list");
        assertTrue(courses.isEmpty(), "getCourses() should return an empty list");
    }

    @Test
    public void testGetCourses_AfterAddingCourse() {
        int initialSize = courseList.getCourses().size();
        Course newCourse = new Course("New Course", "New Course Title", "New Course Description",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "expert", new ArrayList<>(),
                new ArrayList<>());
        courseList.addCourse(newCourse);

        ArrayList<Course> updatedCourses = courseList.getCourses();
        assertNotNull(updatedCourses, "getCourses() should not return a null list");
        assertEquals(initialSize + 1, updatedCourses.size(),
                "getCourses() should return a list with an additional course");
    }

    @Test
    public void testViewCourses_NotEmpty() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        courseList.viewCourses();
        String[] outputLines = outContent.toString().split(System.lineSeparator());

        ArrayList<Course> courses = courseList.getCourses();
        assertEquals(courses.size(), outputLines.length, "Number of output lines should match the number of courses");

        for (int i = 0; i < courses.size(); i++) {
            assertTrue(outputLines[i].endsWith(courses.get(i).getTitle()),
                    "Output should contain the course title at the corresponding index");
        }

        System.setOut(System.out);
    }

    @Test
    public void testViewCourses_Empty() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CourseList emptyCourseList = new CourseList();
        emptyCourseList.viewCourses();

        String output = outContent.toString().trim();
        assertTrue(output.isEmpty(), "Output should be empty for an empty course list");

        System.setOut(System.out);
    }

    @Test
    public void testViewCourses_IndexNumbering() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        courseList.viewCourses();
        String[] outputLines = outContent.toString().split(System.lineSeparator());

        for (int i = 0; i < outputLines.length; i++) {
            assertTrue(outputLines[i].startsWith((i + 1) + ". "),
                    "Output should contain the correct index numbering");
        }

        System.setOut(System.out);
    }

    @Test
    public void testDisplayEnrolledCourses_NoCourses() {
        // String firstname, String lastname, String email, String phonenumber, String
        // username,
        // String password, String userID, String isAuthor
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        User user = new User("tFirstName", "tLastName", "BlahBLah@email.com", "1234567890", "password123!",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "yes");
        courseList.displayEnrolledCourses(user);

        String output = outContent.toString().trim();
        assertTrue(output.contains("You aren't enrolled in any courses"),
                "Output should show the user isn't enrolled in any courses");

        System.setOut(System.out);
    }

    @Test
    public void testDisplayEnrolledCourses_EnrolledCourses_NotCompleted() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Course> userCourses = new ArrayList<>();
        userCourses
                .add(new Course("testAuthor", "testTitle1", "testDescription", "testId1", "testCreatorId", "testLevel",
                        new ArrayList<>(), new ArrayList<>()));
        userCourses
                .add(new Course("testAuthor", "testTitle2", "testDescription", "testId2", "testCreatorId", "testLevel",
                        new ArrayList<>(), new ArrayList<>()));

        User user = new User("tFirstName", "tLastName", "BlahBLah@email.com", "1234567890", "password123!",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "yes");
        CourseList courseList = new CourseList();
        courseList.displayEnrolledCourses(user);

        String[] outputLines = outContent.toString().trim().split(System.lineSeparator());

        assertTrue(outputLines[0].endsWith("testTitle1 (Enrolled)"),
                "Output should show the first enrolled course with the correct status");
        assertTrue(outputLines[1].endsWith("testTitle2 (Enrolled)"),
                "Output should show the second enrolled course with the correct status");

        System.setOut(System.out);
    }


}