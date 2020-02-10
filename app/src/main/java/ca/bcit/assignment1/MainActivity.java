package ca.bcit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    EditText searchText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        searchText = findViewById(R.id.editText);
    }

    public void onInputClick(View v) {
        DisplayListActivity disList = new DisplayListActivity(searchText.getText().toString());
        Intent i = new Intent(this, DisplayListActivity.class);
        startActivity(i);
    }

    public String getCurDate() {
        String date;
        LocalDateTime myDateObj = LocalDateTime.now();
        return date;
    }
}
