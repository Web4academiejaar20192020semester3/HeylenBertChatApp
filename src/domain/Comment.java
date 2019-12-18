package domain;

public class Comment {
    private int topicId;
    private int rating;
    private String name;
    private String comment;


    public Comment(int topicId, String rating, String name, String comment) {
        setTopicId(topicId);
        setRating(Integer.parseInt(rating));
        setName(name);
        setComment(comment);
    }

    public Comment() {

    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        if (topicId < 0 || topicId > 5) {
            throw new IllegalArgumentException("not a valid id");
        }
        this.topicId = topicId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating > 10 || rating < 0) {
            throw new IllegalArgumentException("not a valid rating");
        }
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("not a valid name");
        }
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (comment.trim().isEmpty()) {
            throw new IllegalArgumentException("not a valid comment");
        }
        this.comment = comment;
    }
}