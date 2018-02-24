package com.uca.jj.apps.avengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.uca.jj.apps.avengers.adapters.HeroAdapter;
import com.uca.jj.apps.avengers.api.Api;
import com.uca.jj.apps.avengers.models.HeroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);
        initViews();
        configureRecyclerView();
        fetchHttpRequest();
    }

    public void initViews(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    public void configureRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public  void fetchHttpRequest(){
        Call<List<HeroModel>> call = Api.instance().getHeroes();
        call.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                if(response.body()!=null){
                    HeroAdapter heroAdapter = new HeroAdapter(response.body());
                    recyclerView.setAdapter(heroAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
