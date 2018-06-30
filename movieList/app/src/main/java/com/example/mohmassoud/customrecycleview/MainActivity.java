package com.example.mohmassoud.customrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<listItem>itemList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        createItems();
        recyclerView=findViewById(R.id.customRecycleview);
        adapter=new RecyclerViewAdapter(this,itemList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    void createItems(){
        itemList.add(new listItem("Doctor Strange", "Doctor Strange is a movie starring Benedict Cumberbatch, Chiwetel Ejiofor, and Rachel McAdams. While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.\n", R.drawable.img_1,8.0));
        itemList.add(new listItem("Captain America: Civil War", "Captain America: Civil War is a movie starring Chris Evans, Robert Downey Jr., and Scarlett Johansson. Political involvement in the Avengers' activities causes a rift between Captain America and Iron Man.\n", R.drawable.img_2,7.7));
        itemList.add(new listItem("The Revenant", "A frontiersman on a fur trading expedition in the 1820s fights for survival after being mauled by a bear and left for dead by members of his own hunting team.\n", R.drawable.img_3,8.1));
        itemList.add(new listItem("Ready Player One", "When the creator of a virtual reality world called the OASIS dies, he releases a video in which he challenges all OASIS users to find his Easter Egg, which will give the finder his fortune.\n", R.drawable.img_4,7.3));
        itemList.add(new listItem("The IT Crowd", "The comedic adventures of a rag-tag group of technical support workers at a large corporation.\n", R.drawable.img_5,8.5));
        itemList.add(new listItem("Big Hero 6", "The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.\n", R.drawable.img_6,8.0));
    }
}
