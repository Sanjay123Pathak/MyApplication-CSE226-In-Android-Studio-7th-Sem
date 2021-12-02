package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class P6AsyncTaskProgressBar extends AppCompatActivity {
    ProgressDialog progressBar;
    ListView proList;
    String[] aa = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6_async_task_progress_bar);
//        progressBar=findViewById(R.id.progress1);
        proList = findViewById(R.id.listProgressBar);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        proList.setAdapter(adapter);
        new MyTask().execute();


    }

    class MyTask extends AsyncTask<Void, Integer, String> {

        int count;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = new ProgressDialog(P6AsyncTaskProgressBar.this, R.style.MyAlertDailog);
            progressBar.setMessage("Please wait it's loading");
            progressBar.setMax(10);
            progressBar.setProgress(1);
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.show();
            count = 0;
        }

        @Override
        protected String doInBackground(Void... voids) {
//            this is loading all the elements in the background and then displaying it on the array list
            for (int i = 1; i <= 10; i++) {
                count += 1;
                publishProgress(i);
                try {


                    Thread.sleep(1000);
                    arrayList.add(aa[count - 1]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Completed";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

//            super.onProgressUpdate(values);

            //**********************************this code is doing or showing all the num from 1 to 10
            progressBar.setProgress(values[0]);
//            arrayList.add(aa[count-1]);
//            adapter.notifyDataSetChanged();

        }

        // this is for the background task
        @Override
        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
            adapter.notifyDataSetChanged();
            progressBar.dismiss();
        }
    }

}



