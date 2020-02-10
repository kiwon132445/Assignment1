package ca.bcit.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    public void onClickDetails(View v) {
        Intent i = new Intent(this, DataDisplayActivity.class);
        startActivity(i);
    }
}
