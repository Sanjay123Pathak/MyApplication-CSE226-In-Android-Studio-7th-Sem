package com.example.myapplication.P20RoomDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class P20CourseListAdapter extends RecyclerView.Adapter<P20CourseListAdapter.P20ViewHolder> {
   private Context context;
   private List<P20userRoomDb> CourseList;

    public P20CourseListAdapter(Context context) {
        this.context = context;

    }
public  void  setCourseList(List<P20userRoomDb>userRoomDbList){
        this.CourseList=userRoomDbList;
        notifyDataSetChanged();
}
    @NonNull
    @Override
    public P20CourseListAdapter.P20ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.p20_course_item_recyclerview,parent,false);


        return new P20ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull P20CourseListAdapter.P20ViewHolder holder, int position) {
       holder.t1.setText(this.CourseList.get(position).CourseName);
        holder.t2.setText(this.CourseList.get(position).CourseDescription);
        holder.t3.setText(this.CourseList.get(position).CourseDuration);

    }

    @Override
    public int getItemCount() {
        return this.CourseList.size();
    }

    public class P20ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public P20ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.text1);
            t2=itemView.findViewById(R.id.text2);
            t3=itemView.findViewById(R.id.text3);

        }
    }
}
