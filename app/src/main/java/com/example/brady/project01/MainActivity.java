package com.example.brady.project01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] yearSelection = new String[1];
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Years, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText firstNameET = (EditText) findViewById(R.id.firstNameEntry);
        final EditText lastNameET = (EditText) findViewById(R.id.lastNameEntry);
        final EditText schoolET = (EditText) findViewById(R.id.schoolNameEntry);
        final EditText majorET = (EditText) findViewById(R.id.majorEntry);
        final RatingBar rateBar = (RatingBar) findViewById(R.id.ratingBar);



        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("firstName", firstNameET.getText().toString());
                intent.putExtra("lastName", lastNameET.getText().toString());
                intent.putExtra("schoolName", schoolET.getText().toString());
                intent.putExtra("majorName", majorET.getText().toString());
                intent.putExtra("year", spinner.getSelectedItem().toString());
                intent.putExtra("rating", String.valueOf(rateBar.getRating()));


                startActivity(intent);
            }
        });

    }

}
