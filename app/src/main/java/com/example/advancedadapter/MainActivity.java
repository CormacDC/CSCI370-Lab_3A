package com.example.advancedadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students = new ArrayList<>();
    Student jerry = new Student("jerry","bob","CSCI");
    Student barry = new Student("barry", "bob", "MATH");
    Student larry = new Student("larry", "bob", "PHYS");
    Student harry = new Student("harry", "bob", "ASTR");
    Student tim = new Student("tim", "bob", "HIST");

    ListView listView;

    Context context;

    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.student);

        students.add(jerry);
        students.add(barry);
        students.add(larry);
        students.add(harry);
        students.add(tim);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){

                Toast.makeText(getApplicationContext(),"test short click",Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l){

                Toast.makeText(getApplicationContext(),"test long click",Toast.LENGTH_LONG).show();

                return true;
            }
        });

        context = getApplicationContext();

        studentAdapter = new StudentAdapter(context,students);

        listView.setAdapter(studentAdapter);
    }
}