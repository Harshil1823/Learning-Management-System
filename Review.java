public class Review  {
    private String text;
    private int rating;

    public Review(String userId, String text2, double rating2, String date) {
    }

    public void writeReview(Review review){

        Course.addReview(review); 
        return "";
    }

    public String printFAQ(){
        return "";
    }
}
