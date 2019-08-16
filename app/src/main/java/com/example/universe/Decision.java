package com.example.universe;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Decision extends AppCompatActivity {

    int box_count = 2;

    //TEXTBOX List
    public List<RelativeLayout> textbox = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        //Add First 2 Automatically
        for(int i = 0; i <= 1; i++){
            RelativeLayout box = (RelativeLayout) LayoutInflater.from( getApplicationContext() ).inflate(R.layout.decision_layout,null,false);


            //add textbox to list
            textbox.add(box);

            //Set Count Number
            TextView count_number = (TextView) box.findViewWithTag("count_number");
            String text1 = "#" + (String) Integer.toString(i+1);
            count_number.setText(text1);

            //Add view to linearlayout
            LinearLayout lay = findViewById(R.id.layout_to_put);
            lay.addView(box);

            //Set box ID
            box.setId(i);
        }


        //Back Button
        ImageView back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Decision.super.onBackPressed();
            }
        });

        //Add input field button
        ImageView add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                RelativeLayout box = (RelativeLayout) LayoutInflater.from( getApplicationContext() ).inflate(R.layout.decision_layout,null,false);


                //add textbox to list
                textbox.add(box);

                //increase box count
                ++box_count;

                //Set Count Number
                TextView count_number = (TextView) box.findViewWithTag("count_number");
                String text1 = "#" + (String) Integer.toString(box_count);
                count_number.setText(text1);

                //Add view to linearlayout
                LinearLayout lay = findViewById(R.id.layout_to_put);
                lay.addView(box);

                //Set box ID
                box.setId(box_count-1);


                if(box_count >= 5){
                    view.setVisibility(View.GONE);
                }

                if(box_count > 2 && box_count <= 5){
                    findViewById(R.id.delete_button).setVisibility(View.VISIBLE);
                }





            }
        });

        //Delete input field button
        ImageView delete_button = findViewById(R.id.delete_button);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indeks = box_count - 1;
                LinearLayout lay = findViewById(R.id.layout_to_put);
                lay.removeView(textbox.get(indeks));
                textbox.remove(indeks);

                --box_count;

                if(box_count <= 2){
                    view.setVisibility(View.GONE);
                }

                if(box_count > 2 && box_count <= 5){
                    findViewById(R.id.add_button).setVisibility(View.VISIBLE);
                }

            }
        });


        //Decide Button
        Button buttonDecide = findViewById(R.id.buttonDecide);
        buttonDecide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(Decision.this);
                alert.setTitle("Universe's Decision");
                EditText decision = textbox.get( new Random().nextInt(box_count)).findViewWithTag("input_field");
                alert.setMessage("Universe Decided To: " + decision.getText().toString() );
                alert.setNeutralButton("Got It!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Decision.super.onBackPressed();
                    }
                });
                alert.show();

            }
        });




    }

}
