package com.example.searchkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.searchkaro.Model.advData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Advertise_User extends AppCompatActivity {

    List<advData> heroList;
    //the listview
    ListView listView;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise__user);
        heroList = new ArrayList<>();
//        listView =  findViewById(R.id.lv_adv);
//        imageView=findViewById(R.id.check_image);
        databaseReference = FirebaseDatabase.getInstance().getReference("images");
        heroList.add(new advData(R.drawable.advertisement,"advertisement"));
        heroList.add(new advData(R.drawable.bussineess,"Bussiness"));
        heroList.add(new advData(R.drawable.advertisement,"advertisement"));

        //creating the adapter
        advAdapter adapter = new advAdapter(this,R.layout.adv_data,heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}