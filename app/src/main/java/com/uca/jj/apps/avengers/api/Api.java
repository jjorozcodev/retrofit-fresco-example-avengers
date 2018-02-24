package com.uca.jj.apps.avengers.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Soy JJ on 23/02/2018.
 */

public class Api {

    private static final String BASE_URL = "https://www.simplifiedcoding.net/demos/";

    public static ApiInterface instance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
