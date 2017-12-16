package com.example.epulapp.projetandroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {
    private HomeActivityCallback parent;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button button1vs1 = (Button) view.findViewById(R.id.btn1vs1);
        button1vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG_PROJET", "Click bouton 1 vs 1");
                onButtonClick();
            }
        });

        Button button1vsIa = (Button) view.findViewById(R.id.btn1vsIa);
        button1vsIa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG_PROJET", "beer button");
                onButtonBeers();
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            parent = (HomeActivityCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement HomeActivityCallback");
        }
    }

    public void onButtonClick() {
        parent.onButtonClick();
    }
    public void onButtonBeers() {
        parent.onButtonBeers();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
