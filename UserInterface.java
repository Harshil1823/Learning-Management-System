import java.util.Scanner:

public class UserInterface {
    
    private Scanner scanner;
    private LMS facade;

    public UserInterface(){
        scanner = new Scanner(System.in);
        facade = new LMS();
    }
}
