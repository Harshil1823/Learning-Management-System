/**
 * @author JavaDoc
 * Represents a review of course.
 */
public class Review {
    private String userId;
    private String text;
    private String rating;
    private String date;

    /**
     * Constructor to initialize a review.
     * @param userId String of user ID
     * @param text String of review.
     * @param rating String of rating.
     * @param date String of date.
     */
    public Review(String userID, String text, String rating, String date) {
        this.userId = userID;
        this.text = text;
        this.rating = rating;
        this.date = date;
    }

    /**
     * Returns user ID
     * @return String of user ID.
     */
    public String getUserID() {
        return userId;
    }

    /**
     * Returns review.
     * @return String of review.
     */
    public String getText() {
        return text;
    }

    /**
     * Returns rating.
     * @return String of rating.
     */
    public String getRating() {
        return rating;
    }

    /**
     * Returns date.
     * @return String of the date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the userID.
     * @param userId String of user ID.
     */
    public void setUserID(String userID) {
        this.userId = userID;
    }

    /**
     * Sets the review.
     * @param text String of the review.
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * Sets the rating.
     * @param rating String of rating.
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Sets the date.
     * @param date String of the date.
     */
    public void setDate(String date) {
        this.date = date;
    }


}