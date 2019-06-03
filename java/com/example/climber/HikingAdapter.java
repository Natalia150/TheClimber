package com.example.climber;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HikingAdapter extends RecyclerView.Adapter<HikingAdapter.MyViewHolder> {


    Context context;
    ArrayList<HikesClass> hikes;
    public HikingAdapter(Context c, ArrayList<HikesClass> h)
    {
        context = c;
        hikes = h;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview1,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.name.setText(hikes.get(position).getName());
        myViewHolder.info.setText(hikes.get(position).getInfo());
        myViewHolder.altitude.setText(hikes.get(position).getAltitude());
        Picasso.get().load(hikes.get(position).getProfilePic()).into(myViewHolder.profilePic);
        if (hikes.get(position).getPermission()) {
            myViewHolder.btn.setVisibility(View.VISIBLE);
            myViewHolder.onClick(position);
        }
    }

    @Override
    public int getItemCount() {
        return hikes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView name, altitude, info;
        ImageView profilePic;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            altitude = (TextView) itemView.findViewById(R.id.altitude);
           profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
           btn = (Button) itemView.findViewById(R.id.checkDetails);
           info = (TextView)itemView.findViewById(R.id.info);
        }
         public void onClick(final int position)
         {
             btn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    // Toast.makeText(context, " Good luck! ", Toast.LENGTH_SHORT).show();
                 }
             });
         }
    }
}
