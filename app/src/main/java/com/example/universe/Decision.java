package com.example.universe;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Decision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        ImageView back_arrow = findViewById(R.id.back_arrow);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Decision.super.onBackPressed();
            }
        });

        final List<EditText> textbox = new ArrayList<>();

        textbox.add((EditText) findViewById(R.id.texbox1));
        textbox.add((EditText) findViewById(R.id.texbox2));


        Button buttonDecide = findViewById(R.id.buttonDecide);

        buttonDecide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(Decision.this);
                alert.setTitle("Universe's Decision");
                alert.setMessage("Universe Decided To: " + textbox.get(new Random().nextInt(2)).getText().toString() );
                alert.setNeutralButton("Got It!",null);
                alert.show();



            }
        });


    }

}
