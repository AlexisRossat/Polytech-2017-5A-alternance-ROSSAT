package com.example.epulapp.projetandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link } interface
 * to handle interaction events.
 * Use the {@link BeersListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeersListFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;
    private HomeActivityCallback parent;
    private List<Beer> listBeer;

    public BeersListFragment() {
        // Required empty public constructor
    }


    public static BeersListFragment newInstance(String param1, String param2) {
        BeersListFragment fragment = new BeersListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Beer[] arraylist = listBeer.toArray(new Beer[listBeer.size()]);
        outState.putParcelableArray("beerList", arraylist);
        Log.d("DEBUG_PROJET", "onSaveInstanceState");
    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        someVarA = savedInstanceState.getInt("someVarA");
        someVarB = savedInstanceState.getString("someVarB");
    }*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_beers_list, container, false);
        Log.d("DEBUG_PROJET", "Beers fragment on create view");

        if ((savedInstanceState != null) && (savedInstanceState.getParcelableArray("beerList") != null)) {
            this.listBeer = savedInstanceState.getParcelableArrayList("beerList");

            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listBeer);
            final RecyclerView rv = view.findViewById(R.id.beers_list);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            rv.setAdapter(recyclerViewAdapter);
        } else {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BeerService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BeerService beerService = retrofit.create(BeerService.class);
            Call<List<Beer>> beerList = beerService.beersList();
            beerList.enqueue(new Callback<List<Beer>>() {

                @Override
                public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                    List<Beer> listBeer = response.body();
                    //this.listBeer = response.body();
                    setBeerList(listBeer);
                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listBeer);
                    final RecyclerView rv = view.findViewById(R.id.beers_list);
                    rv.setLayoutManager(new LinearLayoutManager(getContext()));
                    rv.setAdapter(recyclerViewAdapter);
                }

                @Override
                public void onFailure(Call<List<Beer>> call, Throwable t) {

                }
            });
        }
        return view;
    }

    public void setBeerList(List<Beer> beerList){
        this.listBeer = beerList;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
