package com.example.epulapp.projetandroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements HomeActivityCallback {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.d("DEBUG_PROJET", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().add(R.id.main_container, homeFragment).commit();        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DEBUG_PROJET", "Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DEBUG_PROJET", "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEBUG_PROJET", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DEBUG_PROJET", "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DEBUG_PROJET", "Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("DEBUG_PROJET", "Restart");
    }


    @Override
    public void onButtonClick() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        QuestionFragment questionFragment = (QuestionFragment) fragmentManager.findFragmentById(R.id.question_fragment);
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

        if (questionFragment == null) {
            questionFragment = new QuestionFragment();
            fragmentTransaction.replace(R.id.main_container, questionFragment);
        } else {
            fragmentTransaction.show(questionFragment);
        }
        fragmentTransaction.addToBackStack("home_fragment");
        fragmentTransaction.commit();
    }
}
