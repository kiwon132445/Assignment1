package ca.bcit.assignment1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseArticle {
    @SerializedName("articles")
    @Expose
    private ArrayList<Article> articles = new ArrayList<>();

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
