package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarPage extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_page);
        button=(Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                openDialog();

            }
        });
//        return false;
    }

    public void openDialog(){

    }

}