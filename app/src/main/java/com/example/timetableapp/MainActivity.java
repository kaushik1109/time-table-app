package com.example.timetableapp;

import static com.example.timetableapp.R.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    DBHelper DB;
    Button button, button2;
    EditText email, password;
//    RegisterPage rp=new RegisterPage();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        button = (Button) findViewById(id.button3);
        button2 = (Button) findViewById(id.button);
        email = (EditText) findViewById(id.editTextTextEmailAddress);
        password = (EditText) findViewById(id.editTextTextPassword);
        DB = new DBHelper(this);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String pass = password.getText().toString();

                if (username.equals("") || pass.equals("")) {
                    showMessage("Error", "Please Enter all fields");
                } else {
                    Boolean checkuserpass = DB.checkusernamepass(username, pass);
                    if (checkuserpass == true) {
                        openNewActivity();
                    } else {
                        showMessage("Error", "Invalid Credentials");
                    }


                }
            }


        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity2();
            }
        });
    }


    private void openNewActivity2() {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, CalendarPage.class);
        startActivity(intent);
    }

    void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


}




