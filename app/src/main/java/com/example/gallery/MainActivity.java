package com.example.gallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ImageView testImage;
    ImageButton button;
    RecyclerView recyclerView;
    private static final int ACTIVITY_START_CAMERA_APP=0;
    private String mImageFileLocation="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new Adapter(dataqueue(),getApplicationContext()));
        button=findViewById(R.id.cam_btn);
        testImage=findViewById(R.id.testImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto(button);
            }
        });
    }

    public ArrayList<ModelClass> dataqueue(){
        ArrayList<ModelClass> holder = new ArrayList<>();
        ModelClass ob1=new ModelClass();
        ob1.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob1);
        ModelClass ob2=new ModelClass();
        ob2.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob2);
        ModelClass ob3=new ModelClass();
        ob3.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob3);
        ModelClass ob4=new ModelClass();
        ob4.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob4);
        ModelClass ob5=new ModelClass();
        ob5.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob5);
        ModelClass ob6=new ModelClass();
        ob6.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob6);
        ModelClass ob7=new ModelClass();
        ob7.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob7);
        ModelClass ob8=new ModelClass();
        ob8.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob8);
        ModelClass ob9=new ModelClass();
        ob9.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob9);
        ModelClass ob10=new ModelClass();
        ob10.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob10);
        ModelClass ob11=new ModelClass();
        ob11.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob11);
        ModelClass ob12=new ModelClass();
        ob12.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob12);
        ModelClass ob13=new ModelClass();
        ob13.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob13);
        ModelClass ob14=new ModelClass();
        ob14.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob14);
        ModelClass ob15=new ModelClass();
        ob15.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob15);
        ModelClass ob16=new ModelClass();
        ob16.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob16);
        ModelClass ob17=new ModelClass();
        ob17.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob17);
        ModelClass ob18=new ModelClass();
        ob18.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob18);
        ModelClass ob19=new ModelClass();
        ob19.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob19);
        ModelClass ob20=new ModelClass();
        ob20.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob20);
        ModelClass ob21=new ModelClass();
        ob21.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob21);
        ModelClass ob22=new ModelClass();
        ob22.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob22);
        ModelClass ob23=new ModelClass();
        ob23.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob23);
        ModelClass ob24=new ModelClass();
        ob24.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob24);
        ModelClass ob25=new ModelClass();
        ob25.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob25);
        ModelClass ob26=new ModelClass();
        ob26.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob26);
        ModelClass ob27=new ModelClass();
        ob27.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob27);
        ModelClass ob28=new ModelClass();
        ob28.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob28);
        ModelClass ob29=new ModelClass();
        ob29.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob29);
        ModelClass ob30=new ModelClass();
        ob30.setImageview(R.drawable.ic_launcher_background);
        holder.add(ob30);
        return holder;
    }

    public void takePhoto(View view){
        Intent intent=new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        File photoFile = null;
        try{
            photoFile=createImageFile();
        } catch (IOException e){
            e.printStackTrace();
        }
        if (photoFile!=null){
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
            startActivityForResult(intent,ACTIVITY_START_CAMERA_APP);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK){
//            Toast.makeText(this, "Photo taken successfully", Toast.LENGTH_SHORT).show();
//            Bundle extras = data.getExtras();
//            Bitmap capturedPhoto = (Bitmap) extras.get("data");
            Bitmap capturedPhoto = BitmapFactory.decodeFile(mImageFileLocation);
            testImage.setImageBitmap(capturedPhoto);
        }
    }

    File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName="Image_"+timeStamp+"_";
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName,".jpg",storageDirectory);
        mImageFileLocation=image.getAbsolutePath();
        return image;
    }
}