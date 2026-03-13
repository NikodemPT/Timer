package com.rejner.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int ileSekund;
    TextView textView;
    ListView listView;
    boolean czyIdzie = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if (czyIdzie == true){
                            ileSekund++;
                            textView.setText(""+ileSekund);
                            handler.postDelayed(this, 1000);
                        }
                    }
                }
        );
    }
}