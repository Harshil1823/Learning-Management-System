public class Review {
    private String userId;
    private String text;
    private String rating;
    private String date;

    public Review(String userId, String text, String rating, String date) {
        this.userId = userId;
        this.text = text;
        this.rating = rating;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public String getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDate(String date) {
        this.date = date;
    }


}