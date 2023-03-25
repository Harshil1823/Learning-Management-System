import java.util.ArrayList;
/**
 * @author JavaDoc
 * Represents a comment on course or module.
 */
public class Comment {
    private String comment;
    private String author;
    private ArrayList<Comment> replies;

    /**
     * Constructor to initialize a comment.
     * @param userID User ID of who wrote comment.
     * @param text The comment itself.
     */
    public Comment(String userID, String text) {
        this.author = userID;
        this.comment = text;
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
}
