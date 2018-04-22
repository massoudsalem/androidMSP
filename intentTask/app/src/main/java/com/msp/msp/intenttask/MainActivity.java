package com.msp.msp.intenttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToGeek(View view) {
        Intent intent;
        intent = new Intent(this,Geek.class);
        startActivity(intent);
    }

    public void goToBatman(View view) {
        Intent intent;
        intent = new Intent(this,Batman.class);
        startActivity(intent);
    }

    public void goToNormalHuman(View view) {
        Intent intent;
        intent = new Intent(this,NormalHuman.class);
        startActivity(intent);
    }
}
