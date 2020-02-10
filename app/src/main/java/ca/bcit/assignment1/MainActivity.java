package ca.bcit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        startActivity(i);
    }

}
