package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class P5RecyclerViewAdapter extends RecyclerView.Adapter<P5RecyclerViewAdapter.MyViewHolder> {
Context context;
ArrayList<P5RecyclerView> arr1;

    public P5RecyclerViewAdapter(Context context, ArrayList<P5RecyclerView> arr1) {
        this.context = context;
        this.arr1 = arr1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.p5_recycler_view_layout,parent,
                false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                P5RecyclerView p= arr1.get(position);
                holder.imageView.setImageResource(p.getImage());
                holder.txtName.setText(p.getName());
                holder.txtReg.setText(String.valueOf(p.getReg_no()));

    }

    @Override
    public int getItemCount() {
        return arr1.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        CircleImageView imgRemove;
        TextView txtName;
        TextView txtReg;
        CardView cardView;
        LinearLayout lnLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView2);
            imgRemove=itemView.findViewById(R.id.imgRemove);
            imgRemove.setVisibility(View.INVISIBLE);
            txtName=itemView.findViewById(R.id.text2);
            txtReg=itemView.findViewById(R.id.text3);
            cardView=itemView.findViewById(R.id.cardView);
            lnLayout=(LinearLayout) itemView.findViewById(R.id.linearLay);
            lnLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                    imgRemove.setVisibility(View.VISIBLE);
                    imgRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            delete(getAbsoluteAdapterPosition());
                            imgRemove.setVisibility(View.INVISIBLE);
                        }
                    });
                    return true;
                }
                public  void  delete(int position)
                {
                    Toast.makeText(context, "Item deleted successfully !", Toast.LENGTH_SHORT).show();
                    arr1.remove(position);
                    notifyDataSetChanged();
                }
            });



        }

    }
}

