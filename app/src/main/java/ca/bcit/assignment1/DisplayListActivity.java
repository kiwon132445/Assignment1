package ca.bcit.assignment1;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.ArrayList;

public class DisplayListActivity extends ListActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleList = new ArrayList<>();
        new GetArticles().execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, DataDisplayActivity.class);
        i.putExtra("index", (int) id);
        i.putExtra("articleList", articleList);
        startActivity(i);
    }


    @SuppressLint("StaticFieldLeak")
    private class GetArticles extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            Intent get = getIntent();
            String service_url = "https://newsapi.org/v2/everything?q="
                    + get.getStringExtra("userInput") + "&from=";
            String jsonUrl = service_url + get.getStringExtra("curDate")
                    + "&sortBy=publishedAt&apiKey=" + "67c2d97156b94dafa0c709d729929000";
            String jsonStr = sh.makeServiceCall(jsonUrl);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    Log.d(TAG, "Json: " + jsonStr);
                    // this step is needed to wrap the JSON array inside
                    // a JSON object that looks like this { "articles": . . . . }
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray articles = jsonObj.getJSONArray("articles");

                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject c = articles.getJSONObject(i);
                        String source = c.getString("source");
                        String author = c.getString("author");
                        String title = c.getString("title");
                        String description = c.getString("description");
                        String url = c.getString("url");
                        String urlToImage = c.getString("urlToImage");
                        String publishedAt = c.getString("publishedAt");
                        String content = c.getString("content");

                        HashMap<String, String> article = new HashMap<>();
                        article.put("source", source);
                        article.put("author", author);
                        article.put("title", title);
                        article.put("description", description);
                        article.put("url", url);
                        article.put("urlToImage", urlToImage);
                        article.put("publishedAt",publishedAt);
                        article.put("content", content);

                        Article newsArticle = new Article(article);

                        articleList.add(newsArticle);
                    }

                }catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(DisplayListActivity.this,
//                    R.layout.activity_list, articleTitle);
            TitleAdapter articleAdapter = new TitleAdapter(DisplayListActivity.this,
                    articleList);

            // Attach the adapter to a ListView
            ListView listArticles = getListView();
            listArticles.setAdapter(articleAdapter);
        }
    }
}
