package com.acadgild.siddharth.storageassignment142;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "new_image";
                Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.you);
                try{
                    String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                    File file = new File(extStorageDirectory, "ic_launcher.jpg");
                  FileOutputStream  outStream = new FileOutputStream(file);
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                    outStream.flush();
                    outStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
