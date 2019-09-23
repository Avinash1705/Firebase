package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.searchkaro.Model.advData;
import com.example.searchkaro.Model.newData;

import java.util.ArrayList;
import java.util.List;

public class Advertise_User extends AppCompatActivity {
    private ListView ll_data;
    private TextView listname;
    private ImageView imageView;
    List<advData> heroList;
    //the listview
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise__user);
        heroList = new ArrayList<>();
        listView =  findViewById(R.id.lv_allData);

        heroList.add(new advData(R.drawable.advertisement,"advertisement"));
        heroList.add(new advData(R.drawable.bussineess,"Bussiness"));
        heroList.add(new advData(R.drawable.advertisement,"advertisement"));

        //creating the adapter
        advAdapter adapter = new advAdapter(this,R.layout.adv_data,heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }
}