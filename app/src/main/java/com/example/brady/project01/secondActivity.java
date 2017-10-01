package com.example.brady.project01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView nameView = (TextView) findViewById(R.id.textView2);
        String firstName = getIntent().getExtras().getString("firstName");
        String lastName = getIntent().getExtras().getString("lastName");
        String schoolName = getIntent().getExtras().getString("schoolName");
        String majorName = getIntent().getExtras().getString("majorName");
        String year = getIntent().getExtras().getString("year");
        String stars = getIntent().getExtras().getString("rating");
        String sentence = firstName + " " + lastName + " graduated from " + schoolName
                + " in " + year + " with a major in " + majorName + " and rated this app " + stars + " out of 5 stars!";
        nameView.setText(sentence);
    }
}
