package com.example.epulapp.projetandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Epulapp on 29/11/2017.
 */

public interface BeerService {

    public static final String ENDPOINT = "https://api.punkapi.com/v2/";

    @GET("beers/")
    Call<List<Beer>> beersList();

}