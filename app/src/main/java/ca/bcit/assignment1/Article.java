package ca.bcit.assignment1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("source")
    @Expose
    private Source source;
    public String getSource() {
        return source.getName();
    }
    public void setSource(Source source) {
        this.source = source;
    }

    @SerializedName("author")
    @Expose
    private String authorName;
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @SerializedName("title")
    @Expose
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitlee(String title) {
        this.title = title;
    }

    @SerializedName("description")
    @Expose
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("url")
    @Expose
    private String url;
    public String geturl() {
        return url;
    }
    public void seturl(String url) {
        this.url = url;
    }

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    public String geturlToImage() {
        return urlToImage;
    }
    public void seturlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    public String getpublishedAt() {
        return publishedAt;
    }
    public void setpublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @SerializedName("content")
    @Expose
    private String content;
    public String getcontent() {
        return content;
    }
    public void setcontent(String content) {
        this.content = content;
    }
}
