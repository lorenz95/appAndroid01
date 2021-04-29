package com.example.examplecontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "Test Serializzazione";

    public static final String TAG_insert = "Insert Button";
    public static final String TAG_view = "View Button";

    public static String nomeFile = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File path = getApplicationContext().getFilesDir();
        nomeFile = path+"/contatto.ser";

        Button btnInsert = findViewById(R.id.buttonInsert);
        Button btnView = findViewById(R.id.buttonView);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), TAG_insert, Toast.LENGTH_SHORT).show();
                FragmentManager fm = getSupportFragmentManager();
                InsertFragment insertFragment = new InsertFragment();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.placeHolder, insertFragment, TAG_insert).commit();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), TAG_view, Toast.LENGTH_SHORT).show();
                FragmentManager fm = getSupportFragmentManager();
                ListFragment listFragment = new ListFragment();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.placeHolder, listFragment, TAG_view).commit();
            }
        });
    }
}