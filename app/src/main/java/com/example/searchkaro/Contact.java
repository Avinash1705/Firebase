package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.searchkaro.Model.newData;

import java.util.ArrayList;
import java.util.List;

public class Contact extends AppCompatActivity {
    List<newData> heroList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //initilizing object
        heroList = new ArrayList<>();
        listView =  findViewById(R.id.lv_allData);

        heroList.add(new newData(R.drawable.advertisement,"Contact 1"));
        heroList.add(new newData(R.drawable.bussineess,"Contact 2"));
        heroList.add(new newData(R.drawable.advertisement,"Contact 3"));

        //creating the adapter
        newItemDataAdapter adapter = new newItemDataAdapter(this,R.layout.row_data,heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }
}
