package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
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
        return holder;
    }
}