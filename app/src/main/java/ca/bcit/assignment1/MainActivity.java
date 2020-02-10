package ca.bcit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    EditText searchText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        searchText = findViewById(R.id.editText);
    }

    public void onInputClick(View v) {
        Intent i = new Intent(this, DisplayListActivity.class);
        i.putExtra("curDate", getCurDate());
        i.putExtra("userInput", searchText.getText().toString());
        startActivity(i);
    }

    public String getCurDate() {
        String date;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(("yyyy-MM-dd"));
        date = myDateObj.format(dateFormat);
        System.out.println(date);
        return date;
    }
}
