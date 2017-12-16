package com.example.epulapp.projetandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BeerDetailFragment extends Fragment {

    private static final String ARG_BEER = "beer";
    private Beer beer;

    private ImageView beer_image;
    private TextView beer_name;
    private TextView beer_tagline;
    private TextView beer_proposed_by;
    private TextView beer_first_brew;
    private TextView beer_abv;
    private TextView beer_ibu;
    private TextView beer_description;
    private TextView beer_food_pairing;

    public BeerDetailFragment() {
        // Required empty public constructor
    }

    public static BeerDetailFragment newInstance(Beer beer) {
        BeerDetailFragment fragment = new BeerDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BEER, beer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            beer = getArguments().getParcelable(ARG_BEER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer_detail, container, false);

        beer_image          = view.findViewById(R.id.beer_image);
        beer_name           = view.findViewById(R.id.beer_name);
        beer_tagline        = view.findViewById(R.id.beer_tagline);
        beer_proposed_by    = view.findViewById(R.id.beer_proposed_by);
        beer_first_brew     = view.findViewById(R.id.beer_first_brew);
        beer_abv            = view.findViewById(R.id.beer_abv);
        beer_ibu            = view.findViewById(R.id.beer_ibu);
        beer_description    = view.findViewById(R.id.beer_description);
        beer_food_pairing   = view.findViewById(R.id.beer_food_pairing);

        String proposed_by = beer.getProposed_by();
        proposed_by = proposed_by.substring(0,proposed_by.indexOf("<")-1);

        beer_image.setImageBitmap(beer.getImage());
        beer_name.setText(beer.getName());
        beer_tagline.setText(beer.getTagline());
        beer_proposed_by.setText(view.getContext().getString(R.string.Proposed_by) + ": " + proposed_by);
        beer_first_brew.setText(beer.getFirst_brewed());
        beer_abv.setText(beer.getAbv());
        beer_ibu.setText(beer.getIbu());
        beer_description.setText(beer.getDescription());
        beer_food_pairing.setText(TextUtils.join(", ", beer.getFood_pairing()));
       // beer_alcool.setText(view.getContext().getString(R.string.Abv) + " " + beer.getAbv() + "%");


        return view;
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
