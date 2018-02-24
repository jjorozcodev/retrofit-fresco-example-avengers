package com.uca.jj.apps.avengers.api;

import com.uca.jj.apps.avengers.models.HeroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Soy JJ on 23/02/2018.
 */

public interface ApiInterface {
    @GET("marvel")
    Call<List<HeroModel>> getHeroes();
}
