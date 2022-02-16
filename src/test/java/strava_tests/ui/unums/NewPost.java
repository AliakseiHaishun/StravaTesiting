package strava_tests.ui.unums;

public enum NewPost {

    POST_WITH_TITLE("This is title", "This is postText");

    private String postTitle;
    private String postText;

    NewPost(String postTitle, String postText) {

        this.postTitle = postTitle;
        this.postText = postText;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostText() {
        return postText;
    }


}
