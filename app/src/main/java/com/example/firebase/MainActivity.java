package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btt;
    EditText edit;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Demo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btt = findViewById(R.id.button);
        edit = findViewById(R.id.edt);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStudentData();
            }
        });
    }
    public void insertStudentData()
    {
        String username = edit.getText().toString();
        Student st = new Student(username);

        myRef.push().setValue(st);
        Toast.makeText(this, "Data Inserted",Toast.LENGTH_SHORT).show();
    }
}