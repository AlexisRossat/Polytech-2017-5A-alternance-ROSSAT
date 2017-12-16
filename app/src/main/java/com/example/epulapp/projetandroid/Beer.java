package com.example.epulapp.projetandroid;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Epulapp on 29/11/2017.
 */

class Beer implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("first_brewed")
    @Expose
    private String first_brewed;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("abv")
    @Expose
    private String abv;  // Alcohol By Volume
    @SerializedName("ibu")
    @Expose
    private String ibu; //(International Bitterness Units)
    @SerializedName("contributed_by")
    @Expose
    private String proposed_by;
    @SerializedName("food_pairing")
    @Expose
    private String[] food_pairing;
    private Bitmap image;

    public static Creator<Beer> getCREATOR() {
        return CREATOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getProposed_by() {
        return proposed_by;
    }

    public void setProposed_by(String proposed_by) {
        this.proposed_by = proposed_by;
    }

    public String[] getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(String[] food_pairing) {
        this.food_pairing = food_pairing;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.tagline);
        parcel.writeString(this.first_brewed);
        parcel.writeString(this.description);
        parcel.writeString(this.abv);
        parcel.writeString(this.ibu);
        parcel.writeString(this.proposed_by);
        parcel.writeStringArray(this.food_pairing);
        parcel.writeValue(this.image);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    private static final Parcelable.Creator<Beer> CREATOR = new Parcelable.Creator<Beer>() {
        public Beer createFromParcel(Parcel in) {
            return new Beer(in);
        }

        public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Beer(Parcel in) {
        this.id             = in.readInt();
        this.name           = in.readString();
        this.tagline        = in.readString();
        this.first_brewed   = in.readString();
        this.description    = in.readString();
        this.abv            = in.readString();
        this.ibu            = in.readString();
        this.proposed_by    = in.readString();
        in.readStringArray(this.food_pairing);
        this.image          = (Bitmap) in.readValue(Bitmap.class.getClassLoader());
    }


}
