package com.tldn1.recyclerviewvolleypicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tldn1.recyclerviewvolleypicasso.Adapter.RecyclerAdapter;
import com.tldn1.recyclerviewvolleypicasso.Background.BackgroundTask;
import com.tldn1.recyclerviewvolleypicasso.Model.SomethingModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<SomethingModel> arrayList = new ArrayList<SomethingModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        arrayList = backgroundTask.getList();
        adapter = new RecyclerAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);
    }
}
