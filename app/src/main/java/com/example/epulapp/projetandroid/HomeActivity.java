package com.example.epulapp.projetandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("Create", "Create");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy", "Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start", "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause", "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop", "Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Restart", "Restart");
    }
}
