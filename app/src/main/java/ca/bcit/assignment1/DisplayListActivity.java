package ca.bcit.assignment1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayListActivity extends AppCompatActivity {

    DisplayListActivity(String date, String userInput) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}
