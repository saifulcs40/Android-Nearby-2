package com.example.saiful.nearbyhospitals.Adapter;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saiful.nearbyhospitals.Nearby.Result;
import com.example.saiful.nearbyhospitals.R;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.ViewHolder> {

    private List<Result> resultList;
    private Dialog hospitalDialog;

    public NearbyAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_nearby,viewGroup,false);
        final ViewHolder viewHolder = new ViewHolder(view);


        viewHolder.hospitalDetailsCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.hospitalNameTV.setText(resultList.get(i).getName());
        viewHolder.hospitalAddressTV.setText(resultList.get(i).getVicinity());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView hospitalImageIV;
        private TextView hospitalNameTV,hospitalAddressTV;
        private CardView hospitalDetailsCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospitalImageIV = itemView.findViewById(R.id.hospital_image);
            hospitalNameTV = itemView.findViewById(R.id.hospital_name);
            hospitalAddressTV = itemView.findViewById(R.id.hospital_address);
            hospitalDetailsCard = itemView.findViewById(R.id.hospital_details_card);
        }
    }
}
