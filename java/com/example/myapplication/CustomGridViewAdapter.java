package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewAdapter extends ArrayAdapter<CustomGridViewClass> {
 List<CustomGridViewClass>gridList= new ArrayList<>();
//     Context context;
    int a;

    public CustomGridViewAdapter( Context context, int resource,  List<CustomGridViewClass> objects) {
        super(context, resource, resource, objects);
//         this.context=context;
         gridList=objects;
         a=resource;

    }

    @Override
    public int getCount() {
        return gridList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            // getting reference to the main layout and
            // initializing
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.customgridview, null);
        }

        // initializing the imageview and textview and
        // setting data
        ImageView imageView = v.findViewById(R.id.grid_Image);
        TextView  textView=v.findViewById(R.id.grid_text);

        // get the item using the  position param
        CustomGridViewClass custom_image = gridList.get(position);

        imageView.setImageResource(custom_image.getImage_id());
        textView.setText(custom_image.getName_id());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i=new Intent(v.getContext(),ReceiveDetailFromGridView.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              i.putExtra("image_id",custom_image.getImage_id());
              i.putExtra("name_id",custom_image.getName_id());
              v.getContext().startActivity(i);
            }
        });

        return v;
    }
}
