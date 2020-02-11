package ca.bcit.assignment1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DisplayListActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    // URL to get contacts JSON
    private static String SERVICE_URL = "https://newsapi.org/v2/everything?";
    private ArrayList<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        articleList = new ArrayList<Article>();
        //lv = findViewById(R.id.toonList); <-- change to layout.xml that contains the listview
        new GetArticles().execute();
    }
    public void onClickDetails(View v) {
        //Pass the Article object to DataDisplay activity as an extra
        Intent i = new Intent(this, DataDisplayActivity.class);
        startActivity(i);
    }

    private class GetArticles extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                // a JSON object that looks like this { "articles": . . . . }
                jsonStr = "{\"articles\":" + jsonStr + "}";
                Gson gson = new Gson();
                BaseArticle baseArticle = gson.fromJson(jsonStr, BaseArticle.class);
                articleList = baseArticle.getArticles();
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

            ArticleAdapter adapter = new ArticleAdapter(DisplayListActivity.this, articleList);

            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }
}
