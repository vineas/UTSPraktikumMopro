package com.example.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {
    Button btn_pindah;
    Button btn_pindah2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btn_pindah= findViewById(R.id.sosmed);
        btn_pindah2= findViewById(R.id.lokasi);


        btn_pindah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Sosmed(v);

            }
        });
        btn_pindah2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Lokasi(v);
            }
        });
    }

    public void Sosmed (View view){
        String url="https://www.instagram.com/vineas";
        Intent intent = new Intent(Intent. ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void Lokasi (View view){
        String url="https://www.google.com/maps/place/Gina+Florist/@-6.9295829,107.7148508,21z/data=!4m5!3m4!1s0x2e68c32a64a11861:0xe2df2d1a4ea62913!8m2!3d-6.9296846!4d107.7149807";
        Intent intent = new Intent(Intent. ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}