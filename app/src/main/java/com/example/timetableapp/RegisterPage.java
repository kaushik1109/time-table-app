package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPage extends Activity implements OnClickListener {
    EditText Name, Email, Password;
    DBHelper DB;
    SQLiteDatabase db;
    Button Insert;
//    private int title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        Name= (EditText) findViewById(R.id.editTextTextPersonName);
        Email= (EditText) findViewById(R.id.editTextTextPersonName2);
        Password= (EditText) findViewById(R.id.editTextTextPassword2);
        Insert= (Button) findViewById(R.id.button2);
        DB = new DBHelper(this);

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=Name.getText().toString();
                String username = Email.getText().toString();
                String pass = Password.getText().toString();
                if(name.equals("")||username.equals("")||pass.equals(""))
                {
                    showMessage("Error", "Please Enter all fields");
                }
                else{
                    Boolean checkmail=DB.checkemail(username);
                    if(checkmail==false)
                    {
                        Boolean insert = DB.insertData(name,username,pass);
                        if(insert==true){
                            showMessage("Success","Registered Successfully");
                        }
                    }
                }
            }
        });


    }

//        db=openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,email VARCHAR,password VARCHAR);");
//
//
//        return false;
//    }
//
//    @Override
//    public void onClick(View view) {
//        if (Name.getText().length() == 0 || Email.getText().length() == 0 || Password.getText().length() == 0) {
//            showMessage("Error", "Please enter all values");
//            return;
//        }
//        db.execSQL("INSERT INTO users VALUES (' " + Name.getText() + "' , '" + Email.getText() + "','" + Password.getText() + "');");
//        showMessage("Success", "Registered Successfully");
//        clearText();
//    }

    private void clearText() {
        Name.setText("");
        Email.setText("");
        Password.setText("");
    }

    void showMessage(String title, String message) {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void onClick(View view) {

    }
}
