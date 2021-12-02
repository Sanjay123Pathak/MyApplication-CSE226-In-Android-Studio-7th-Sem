package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class P2CustomArrayListAdapter extends ArrayAdapter<P2CustomArrayList> {
    int count_deleted_items=0;
    Context context;

    ArrayList<P2CustomArrayList> arrayLists;
    public P2CustomArrayListAdapter(Context context, int textViewResourceId, ArrayList<P2CustomArrayList> objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        arrayLists=objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getPosition(P2CustomArrayList item) {
        return super.getPosition(item);
    }

    @Override
    public View getView(int position, View abc, ViewGroup parent) {
        View v=abc;
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.p2listviewcustom,null);

        TextView p2_text=v.findViewById(R.id.p2Text);
        CircleImageView p2_image=v.findViewById(R.id.p2Image);

        p2_image.setImageResource(arrayLists.get(position).getImage());
        p2_text.setText(arrayLists.get(position).getName());
        Button p2_btn=v.findViewById(R.id.p2btn);

          p2_image.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (!arrayLists.get(position).name.equals(""))
                  {  arrayLists.get(position).name="";
                      notifyDataSetChanged();
                  }
              }
          });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " You clicked position no : "+arrayLists.get(position).getName(), Toast.LENGTH_LONG).show();

            }
        });
//        this is for removing items for the list
             p2_btn.setTag(position);//setting tag

           p2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 // without setTag method
//                arrayLists.remove(pos);
//                Toast.makeText(context, " You deleted : "+ " " + count_deleted_items, Toast.LENGTH_LONG).show();
//                arrayLists.remove(getItem(position));
//                notifyDataSetChanged();


                //with setTag method
                int pos=(Integer) v.getTag();
                String s=Integer.toString(pos);
                count_deleted_items++;

                Toast.makeText(context, " You deleted : "+ " " + count_deleted_items, Toast.LENGTH_LONG).show();
                arrayLists.remove(pos);

                arrayLists.remove(arrayLists.get(pos));
                notifyDataSetChanged();


            }

        });

        return v;
    }

}
