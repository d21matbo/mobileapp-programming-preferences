package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.text_view);

        myPreferenceRef = getSharedPreferences("saved", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String data = myPreferenceRef.getString("savedPreference", "Data missing");
        textView.setText(data);
    }

    private void onButtonClick(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
