package com.example.epulapp.projetandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.BROADCAST_NOTIF");
        intent.putExtra("data","Notice me senpai!");
        //LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
        getContext().sendBroadcast(intent);


        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("DEBUG_PROJET", "On resume");
    }

    @Override
    public void onStart() {
       super.onStart();
        Log.d("DEBUG_PROJET", "onStart");

    }
}
