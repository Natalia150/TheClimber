package com.example.climber;

import android.content.Context;
import android.content.Intent;
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

public class ClimbingAdapter extends RecyclerView.Adapter<ClimbingAdapter.MyViewHolder> {


    Context context;
    ArrayList<ClimbingO> routes;
    public ClimbingAdapter(Context c, ArrayList<ClimbingO> o)
    {
        context = c;
        routes = o;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.name.setText(routes.get(position).getName());
        myViewHolder.grade.setText(routes.get(position).getGrade());
        Picasso.get().load(routes.get(position).getProfilePic()).into(myViewHolder.profilePic);
        if (routes.get(position).getPermission()) {
            myViewHolder.btn.setVisibility(View.VISIBLE);
            myViewHolder.onClick(position);
        }
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView name, grade;
        ImageView profilePic;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            grade = (TextView) itemView.findViewById(R.id.grade);
           profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
           btn = (Button) itemView.findViewById(R.id.checkDetails);
        }
         public void onClick(final int position)
         {
             btn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     Intent intent = new Intent(context, DetailsActivity.class);
                    // intent.putExtra("image_url", mImages.get(position));
                   //  intent.putExtra("image_name", mImageNames.get(position));
                     context.startActivity(intent);
                 }
             });
         }
    }
}
