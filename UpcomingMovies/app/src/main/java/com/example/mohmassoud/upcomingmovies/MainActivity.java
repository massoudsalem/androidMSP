package com.example.mohmassoud.upcomingmovies;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<listItem> itemList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        itemList = new ArrayList<>();
        new apiTMDB().execute();

    }

    public class apiTMDB extends AsyncTask<Void, Void, ArrayList> {

        @Override
        protected ArrayList doInBackground(Void... params) {
            try {
                URL url = new URL("https://api.themoviedb.org/3/movie/upcoming?api_key=f33aed092875f62fedf5a43ad12f8ab9&language=en-US&page=1");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader input = new BufferedReader(inputStreamReader);
                String line = "", jsonStr = "";
                while ((line = input.readLine()) != null) {
                    jsonStr += line;
                }
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                for (int i = 0; i < jsonArray.length(); ++i) {
                    String name=jsonArray.getJSONObject(i).getString("title");
                    String des=jsonArray.getJSONObject(i).getString("overview");
                    String imgurl="https://image.tmdb.org/t/p/w342/" + jsonArray.getJSONObject(i).getString("poster_path");
                    Double rating=jsonArray.getJSONObject(i).getDouble("vote_average");
                    itemList.add(new listItem(name,des,imgurl,rating));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return itemList;
        }

        @Override
        protected void onPostExecute(ArrayList arrayList) {
            recyclerView=findViewById(R.id.customRecycleview);
            adapter=new RecyclerViewAdapter(MainActivity.this,itemList);
            recyclerView.setAdapter(adapter);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}