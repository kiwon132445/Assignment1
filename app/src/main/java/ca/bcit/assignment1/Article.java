package ca.bcit.assignment1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;

public class Article implements Serializable {
    Article(HashMap<String,String> article) {
        source = article.get("source");
        authorName = article.get("author");
        title = article.get("title");
        description = article.get("description");
        url = article.get("url");
        urlToImage = article.get("urlToImage");
        publishedAt = article.get("publishedAt");
        content = article.get("content");
    }
    @SerializedName("source")
    @Expose
    private String source;
    public String getSource() {
        return source;
    }

    @SerializedName("author")
    @Expose
    private String authorName;
    public String getAuthorName() {
        return authorName;
    }

    @SerializedName("title")
    @Expose
    private String title;
    public String getTitle() {
        return title;
    }

    @SerializedName("description")
    @Expose
    private String description;
    public String getDescription() {
        return description;
    }

    @SerializedName("url")
    @Expose
    private String url;
    public String geturl() {
        return url;
    }

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    public String geturlToImage() {
        return urlToImage;
    }

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    public String getpublishedAt() {
        return publishedAt;
    }

    @SerializedName("content")
    @Expose
    private String content;
    public String getcontent() {
        return content;
    }
}
