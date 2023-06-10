package com.example.h071211085_finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private ImageView img2,img3,back;
    private TextView tv4,tv5,tv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img2 = findViewById(R.id.gambar2);
        img3 = findViewById(R.id.gambar3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        back  = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detail.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}