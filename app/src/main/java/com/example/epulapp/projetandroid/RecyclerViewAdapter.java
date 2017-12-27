package com.example.epulapp.projetandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;


/**
 * Created by Epulapp on 29/11/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private HomeActivityCallback parent;
    private final List<Beer> beerList;

    public RecyclerViewAdapter(List<Beer> beerList) {
        this.beerList = beerList;
    }


    @Override
    public int getItemCount() {
        return this.beerList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);

        try {
            this.parent = (HomeActivityCallback) parent.getContext();

        } catch (ClassCastException e) {
            throw new ClassCastException(parent.getContext().toString() + " must implement HomeActivityCallback");
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Beer beer = beerList.get(position);
        holder.display(beer);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView beer_name;
        private final TextView beer_alcool;
        private ImageView beer_image;

        private Beer currentBeer;

        public MyViewHolder(final View itemView) {
            super(itemView);

            beer_name = itemView.findViewById(R.id.beer_name);
            beer_alcool = itemView.findViewById(R.id.beer_alcool);
            beer_image = itemView.findViewById(R.id.beer_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onSelectBeer(currentBeer);
                    Log.d("DEBUG_PROJET", currentBeer.getName());
                }
            });
        }

        public void display(Beer beer) {
            if(beer.getImage() == null){
                DownloadImageTask downloadImageTask = new DownloadImageTask(beer);
                downloadImageTask.execute(beer.getImage_url());
            }
            currentBeer = beer;
            beer_name.setText(beer.getName());
            beer_alcool.setText(itemView.getContext().getString(R.string.Abv) + " " + beer.getAbv() + "%");
            beer_image.setImageBitmap(beer.getImage());
        }

        private class DownloadImageTask extends AsyncTask<String, Beer, Bitmap> {
            private Beer beer;
            public DownloadImageTask(Beer beer) {
                this.beer = beer;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            protected Bitmap doInBackground(String... urls) {
                String urldisplay = urls[0];
                Bitmap mIcon11 = null;
                try {
                    InputStream in = new java.net.URL(urldisplay).openStream();
                    mIcon11 = BitmapFactory.decodeStream(in);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return mIcon11;
            }

            protected void onPostExecute(Bitmap result) {
                if(this.beer.getImage() == null){
                    this.beer.setImage(result);
                    beer_image.setImageBitmap(beer.getImage());
                }
            }
        }
    }

    public void onSelectBeer(Beer beer) {
        parent.onSelectBeer(beer);
    }
}
