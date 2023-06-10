package com.example.h071211085_finalmobile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data3 {
    @SerializedName("results")

    private List<TvShow> results;

    public List<TvShow> getData3() {
        return results;
    }

}
