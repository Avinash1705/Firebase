package com.example.searchkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchkaro.Model.newData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Contact extends AppCompatActivity {
    List<newData> heroList;
    ListView listView;
    private String TAG="allUpdatedData_admin";
    String YourtransferredData;
    TextView allUpdatedData_admin;
    FirebaseDatabase database;
    DatabaseReference myRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Updating Admin Contact");
//        Intent intent = getIntent();
//         YourtransferredData = intent.getExtras().getString("ReadContactFromDatabase");
//        //initilizing object
//        heroList = new ArrayList<>();
//        listView =  findViewById(R.id.lv_allData);
         allUpdatedData_admin=findViewById(R.id.Amin_allDataUpdated);
//        Log.d(TAG, " allUpdatedData_admin"+allUpdatedData_admin);
//        allUpdatedData_admin.setText(YourtransferredData);
//        heroList.add(new newData(R.drawable.advertisement,"Contact 1"));
//        heroList.add(new newData(R.drawable.bussineess,"Contact 2"));
//        heroList.add(new newData(R.drawable.advertisement,"Contact 3"));
//
//
//        //creating the adapter
//        newItemDataAdapter adapter = new newItemDataAdapter(this,R.layout.row_data,heroList);
//
//        //attaching adapter to the listview
//        listView.setAdapter(adapter);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Intent i = new Intent(getApplicationContext(), Contact.class);
                i.putExtra("ReadContactFromDatabase", value);
                Log.d(TAG, "Value is: " + value);
                allUpdatedData_admin.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(getApplicationContext(),"Failed To read VAlue",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ReadToDatabase(){

    }
}
