package ca.bcit.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DataDisplayActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // get the country from the intent
        try{
            Intent get = getIntent();
            int articleIndex = (Integer) get.getExtras().get("index");
            ArrayList<Article> articleList = (ArrayList) get.getExtras().get("articleList");
            Article article = articleList.get(articleIndex);

            ImageView photo = findViewById(R.id.smallThumbnail);
            if (article.geturl() != null) {
                new ImageDownloaderTask(photo).execute(article.geturlToImage());
            }

            TextView source = findViewById(R.id.source);
            TextView author = findViewById(R.id.author);
            TextView name = findViewById(R.id.title);
            TextView desc = findViewById(R.id.description);
            TextView publishedAt = findViewById(R.id.publishedAt);
            TextView content = findViewById(R.id.content);

            String sourceText = "Source: " + article.getSource();
            String authorText = "Author: " + article.getAuthorName();
            String nameText = "Title: " + article.getTitle();
            String desctiptionText = "Description: " + article.getDescription();
            String publishedAtText = "Published At: " + article.getpublishedAt();
            String contentText = "Content: " + article.getcontent();

            source.setText(sourceText);
            author.setText(authorText);
            name.setText(nameText);
            desc.setText(desctiptionText);
            publishedAt.setText(publishedAtText);
            content.setText(contentText);
        } catch(NullPointerException e) {
            System.out.println("Article details lost");
        }


    }


}
