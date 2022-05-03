package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences.Editor myPreferenceEditor;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        editText = findViewById(R.id.edit_text);

        Button button = findViewById(R.id.button_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPreferenceEditor.putString("savedPreference", editText.getText().toString());
                myPreferenceEditor.apply();
                finish();
            }
        });
    }
}