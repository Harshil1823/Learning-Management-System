import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * @author JavaDoc
 * Represents a comment on course or module.
 */
public class Comment {
    private String comment;
    private String author;
    private ArrayList<String> replies;
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Constructor to initialize a comment.
     * @param userID User ID of who wrote comment.
     * @param text The comment itself.
     */
    public Comment(String userID, String text) {
        this.author = userID;
        this.comment = text;
        this.replies = new ArrayList<>();
    }

    /**
     * Makes sure comment is valid.
     * @param comment The comment itself.
     * @return True if comment is valid, false otherwise.
     */
    public boolean checkValidComment(String comment) {
        if (!comment.isEmpty())
            return true;
        return false;
    }

    /**
     * Returns User ID of who wrote comment.
     * @return String of user ID.
     */
    public String getUserID() {
        return author;
    }

    /**
     * Returns the comment.
     * @return String of comment.
     */
    public String getText() {
        return comment;
    }
    /**
     * prints out the comment 
     * and then user can reply to the comment 
     * comment is stored on reply arraylist
     */
    public void reply(){
        System.out.print("What would you like to reply to this comment: ");
        System.out.println(comment);

        String reply = keyboard.nextLine();
        replies.add(reply);
        System.out.println("Reply added.");
    }
    /**
     * probably could've been in the UI
     * but it displays comment and then relies to it
     */
    public void display(){

        System.out.println("       -Comment:");
        System.out.println("        -" + comment);

        System.out.println("        -Replies:");
        for(String reply : replies)
            System.out.println("        -" + reply);
    }

 
}
