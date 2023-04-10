package com.example.timetableapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;


public class ExampleDialog extends AppCompatDialogFragment {
    DBHelper myDB;
    private EditText label;
    private TimePicker time;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog, null);
//        myDB = new DBHelper(this);
        builder.setView(view)
                .setTitle("Enter your activity for today")
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface,int i){}

                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                           String my_label=label.getText().toString();
                            String my_time=label.getText().toString();
                    }
                });

        label=view.findViewById(R.id.edit_label);
        time=view.findViewById(R.id.pick_time);
        return builder.create();
    }
}
