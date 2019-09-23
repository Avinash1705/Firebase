package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.searchkaro.Model.newData;

import java.util.ArrayList;
import java.util.List;

public class NewItemActivity extends AppCompatActivity {
    private ListView ll_data;
    private TextView listname;
    private ImageView imageView;
    List<newData> heroList;
    //the listview
    ListView listView;

    String[] text={"Vivo","Iphone","1+"};
     Integer [] img={R.drawable.advertisement,R.drawable.bussineess,R.drawable.contact};
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

  //initilizing object
        heroList = new ArrayList<>();
        listView =  findViewById(R.id.lv_allData);

        heroList.add(new newData(R.drawable.advertisement,"advertisement"));
        heroList.add(new newData(R.drawable.bussineess,"Bussiness"));
        heroList.add(new newData(R.drawable.advertisement,"advertisement"));

        //creating the adapter
        newItemDataAdapter adapter = new newItemDataAdapter(this,R.layout.row_data,heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }
}