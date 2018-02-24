package com.uca.jj.apps.avengers.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.uca.jj.apps.avengers.R;
import com.uca.jj.apps.avengers.models.HeroModel;

import java.util.List;

/**
 * Created by Soy JJ on 23/02/2018.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<HeroModel> heroes;

    public HeroAdapter(List<HeroModel> heroes) {
        this.heroes = heroes;
    }

    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_heroes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroAdapter.ViewHolder holder, int position) {
        HeroModel heroModel = heroes.get(position);

        holder.name.setText(heroModel.getName());
        holder.realname.setText(heroModel.getRealname());
        holder.firstappearance.setText(heroModel.getFirstappearance());
        holder.createdby.setText(heroModel.getCreatedby());
        holder.bio.setText(heroModel.getBio());
        holder.circleImg.setImageURI(Uri.parse(heroModel.getImageurl()));
    }

    @Override
    public int getItemCount() {
        return this.heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView realname;
        TextView firstappearance;
        TextView createdby;
        TextView bio;
        SimpleDraweeView circleImg;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            realname = itemView.findViewById(R.id.realname);
            firstappearance = itemView.findViewById(R.id.firstappearance);
            createdby = itemView.findViewById(R.id.createdby);
            bio = itemView.findViewById(R.id.bio);
            circleImg = itemView.findViewById(R.id.imgItem);
        }
    }
}
