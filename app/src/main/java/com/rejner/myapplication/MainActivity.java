package com.rejner.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button start;
    private Button stop;
    private Button reset;
    private boolean czyAktywny;
    private int ileSekund;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);

        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(czyAktywny) {
                            ileSekund++;
                            textView.setText(zwrocLadnyCzas(ileSekund));
                        }
                        handler.postDelayed(this, 1000);
                    }
                }
        );

        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyAktywny = true;
                    }
                }
        );
        stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyAktywny = false;
                    }
                }
        );
        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyAktywny = false;
                        ileSekund = 0;
                        textView.setText("00:00:00");
                    }
                }
        );
    }
    private String zwrocLadnyCzas(int ileSekund){
        int sekundy = ileSekund % 60;
        int minuty = (ileSekund / 60) % 60;
        int godziny = ileSekund / 3600;
        return String.format("%02d:%02d:%02d", godziny, minuty, sekundy);
    }
}