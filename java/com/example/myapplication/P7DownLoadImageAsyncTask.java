package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class P7DownLoadImageAsyncTask extends AppCompatActivity {
    ImageView loadImage;
    Button BtnDownLoad;
    Bitmap bitmap = null;
    InputStream inputStream = null;
    ProgressDialog progressDialog;
//    String urlImage = "https://www.google.com/search?q=images&tbm=isch&chips=q:images,g_1:nature:zldKiJlAiMo%3D&hl=en&sa=X&ved=2ahUKEwiggb_AuoDzAhWOXn0KHVSWCEEQ4lYoA3oECAEQFg&biw=1519&bih=754#imgrc=_SRLn3WwOzz5NM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_down_load_image_async_task);
        BtnDownLoad = findViewById(R.id.downLoadBtn);
        loadImage = findViewById(R.id.DownLoadImage);

    }

    public void downLoad(View view) {
        DownLoadImage downLoadImage = new DownLoadImage();
//        downLoadImage.execute("C://Users//DELL//Pictures//Screenshots//Screenshot(1).png");this does not work
        downLoadImage.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg");
    }


    public class DownLoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(P7DownLoadImageAsyncTask.this, R.style.MyAlertDailog);

            progressDialog.setMessage("Please wait It;s downloading now... !");
            progressDialog.show();

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (loadImage != null) {
                progressDialog.hide();
                loadImage.setImageBitmap(bitmap);
                Toast.makeText(P7DownLoadImageAsyncTask.this, "DownLoaded ", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.show();
            }
        }
    }
}
